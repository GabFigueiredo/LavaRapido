package lavarapido.dao;

import database.Conn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lavarapido.model.Agendamento;
import lavarapido.model.Cliente;
import lavarapido.model.TipoServico;

public class AgendamentoDAO {

    public List<Agendamento> buscarAgendamentos() throws SQLException {
        List<Agendamento> lista = new ArrayList<>();
        try (Connection conn = Conn.getConnection()) {
            String sql = "SELECT * FROM agendamento";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ClienteDAO ClienteDAO = new ClienteDAO();
            TipoServicoDAO TipoServicoDAO = new TipoServicoDAO();

            while (rs.next()) {
                Cliente cliente = ClienteDAO.buscarClientePorID(rs.getInt("cliente_id"));
                TipoServico servico = TipoServicoDAO.buscarServicoPorID(rs.getInt("tipo_servico"));
                
                Agendamento ag = new Agendamento(
                        rs.getInt("id"),
                        cliente, 
                        servico, 
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("status")
                );
                lista.add(ag);
            }
        }
        return lista;
    }

    public Agendamento buscarAgendamentoPorID(int id) throws SQLException {
        Agendamento ag;
        try (Connection conn = Conn.getConnection()) {
            String sql = "SELECT * FROM agendamento WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ag = null;
            
            ClienteDAO ClienteDAO = new ClienteDAO();
            TipoServicoDAO TipoServicoDAO = new TipoServicoDAO();

            Cliente cliente = ClienteDAO.buscarClientePorID(rs.getInt(1));
            TipoServico servico = TipoServicoDAO.buscarServicoPorID(rs.getInt("tipoServico"));
            
            if (rs.next()) {
                ag = new Agendamento(
                        rs.getInt("id"),
                        cliente,
                        servico,
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("status")
                );
            }
        }
        return ag;
    }
    
    public void criarAgendamento(Agendamento agendamento) throws SQLException {
    String sql = "INSERT INTO agendamento (cliente_id, tipo_servico, data_hora, status) VALUES (?, ?, ?, ?)";
    try (Connection conn = Conn.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, agendamento.getCliente().getId());
        stmt.setInt(2, agendamento.getTipoServico().getId());
        stmt.setTimestamp(3, Timestamp.valueOf(agendamento.getDataHora()));
        stmt.setString(4, agendamento.getStatus());
        stmt.executeUpdate();
    }
}

    public void excluirAgendamento(int id) throws SQLException {
        try (Connection conn = Conn.getConnection()) {
            String sql = "DELETE FROM agendamento WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void editarAgendamento(int id, String status) throws SQLException {
        try (Connection conn = Conn.getConnection()) {
            String sql = "UPDATE agendamento SET status = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}
