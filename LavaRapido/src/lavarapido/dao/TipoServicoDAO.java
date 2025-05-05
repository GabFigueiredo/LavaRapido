package lavarapido.dao;

import database.Conn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lavarapido.model.TipoServico;

public class TipoServicoDAO {

    public List<TipoServico> buscarServicos() throws SQLException {
        List<TipoServico> lista = new ArrayList<>();
        Connection conn = Conn.getConnection();
        String sql = "SELECT * FROM tipo_servico";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            TipoServico t = new TipoServico(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getDouble("preco")
            );
            lista.add(t);
        }

        conn.close();
        return lista;
    }

    public TipoServico buscarServicoPorID(int id) throws SQLException {
        Connection conn = Conn.getConnection();
        String sql = "SELECT * FROM tipo_servico WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        TipoServico t = null;
        if (rs.next()) {
            t = new TipoServico(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getDouble("preco")
            );
        }

        conn.close();
        return t;
    }
    
    public void criarServico(TipoServico servico) throws SQLException {
    String sql = "INSERT INTO tipo_servico (nome, descricao, preco) VALUES (?, ?, ?)";
    try (Connection conn = Conn.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, servico.getNome());
        stmt.setString(2, servico.getDescricao());
        stmt.setDouble(3, servico.getPreco());
        stmt.executeUpdate();
    }
}

    public void excluirServico(int id) throws SQLException {
        Connection conn = Conn.getConnection();
        String sql = "DELETE FROM tipo_servico WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }

    public void editarServico(int id, String novaDescricao, double novoPreco) throws SQLException {
        Connection conn = Conn.getConnection();
        String sql = "UPDATE tipo_servico SET descricao = ?, preco = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novaDescricao);
        stmt.setDouble(2, novoPreco);
        stmt.setInt(3, id);
        stmt.executeUpdate();
        conn.close();
    }
}
