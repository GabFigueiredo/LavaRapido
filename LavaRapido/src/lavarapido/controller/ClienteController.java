/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lavarapido.controller;

/**
 *
 * @author gabri
 */
import java.sql.SQLException;
import java.util.List;
import lavarapido.model.Cliente;
import lavarapido.dao.ClienteDAO;

public class ClienteController {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> listarClientes() throws SQLException {
        return clienteDAO.buscarClientes();
    }

    public Cliente buscarClientePorID(int id) throws SQLException {
        return clienteDAO.buscarClientePorID(id);
    }

    public boolean cadastrarCliente(Cliente cliente) throws SQLException {
        if (!verificarCPFExistente(cliente)) {
            clienteDAO.criarCliente(cliente);
            return true;
        }
        return false;
    }

    public boolean editarCliente(int id, String nome, String telefone, String email, String placaVeiculo) throws SQLException {
        Cliente mockDoCliente = new Cliente(id, "Mock", "Cpf", "Telefone", "Email", placaVeiculo);
        if (!verificarPlacaVeiculoExistente(mockDoCliente)) {
            clienteDAO.editarCliente(id, nome, telefone, email, placaVeiculo);
            return true;
        }
        
        return false;
    }

    public boolean excluirCliente(int id) throws SQLException {
        clienteDAO.excluirCliente(id);
        return true;
    }

    public boolean verificarCPFExistente(Cliente cliente) throws SQLException {
        for (Cliente c : clienteDAO.buscarClientes()) {
            if (c.getCpf().equals(cliente.getCpf())) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarPlacaVeiculoExistente(Cliente cliente) throws SQLException {
        for (Cliente c : clienteDAO.buscarClientes()) {
            if (c.getId() == cliente.getId()) {
                continue;
            }
            
            if (c.getPlacaVeiculo().equalsIgnoreCase(cliente.getPlacaVeiculo())) {
                return true;
            }
        }
        return false;
    }
}