package lavarapido.dao;

import database.Conn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lavarapido.model.Cliente;

public class ClienteDAO {

    public List<Cliente> buscarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = Conn.getConnection()) {
            String sql = "SELECT * FROM cliente";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("placa_veiculo")
                );
                clientes.add(c);
            }
        }
        return clientes;
    }

    public Cliente buscarClientePorID(int id) throws SQLException {
        Cliente c;
        try (Connection conn = Conn.getConnection()) {
            String sql = "SELECT * FROM cliente WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            c = null;
            if (rs.next()) {
                c = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("placa_veiculo")
                );
            }
        }
        return c;
    }
    
    public void criarCliente(Cliente cliente) throws SQLException {
    String sql = "INSERT INTO cliente (nome, cpf, telefone, email, placa_veiculo) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = Conn.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getEmail());
        stmt.setString(5, cliente.getPlacaVeiculo());
        stmt.executeUpdate();
    }
}

    public void excluirCliente(int id) throws SQLException {
        try (Connection conn = Conn.getConnection()) {
            String sql = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void editarCliente(int id, String nome, String telefone, String email, String placa_veiculo) throws SQLException {
        try (Connection conn = Conn.getConnection()) {
            String sql = "UPDATE cliente SET nome = ?, telefone = ?, email = ?, placa_veiculo = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, email);
            stmt.setString(4, placa_veiculo);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }
}
