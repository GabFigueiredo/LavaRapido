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
import java.time.LocalDateTime;
import java.util.List;
import lavarapido.dao.AgendamentoDAO;
import lavarapido.model.Agendamento;
import lavarapido.model.Cliente;
import lavarapido.model.TipoServico;

public class AgendamentoController {
    private final AgendamentoDAO agendamentoDAO;
    
    public AgendamentoController() {
        this.agendamentoDAO = new AgendamentoDAO();
    }
    
    public List<Agendamento> listarAgendamentos() throws SQLException {
        return agendamentoDAO.buscarAgendamentos();
    }

    public Agendamento listarAgendamentoPorID(int id) throws SQLException {
        return agendamentoDAO.buscarAgendamentoPorID(id);
    }

    public void criarAgendamento(Cliente cliente, TipoServico tipoServico, LocalDateTime data) throws SQLException {
        int novoId = agendamentoDAO.buscarAgendamentos().size() + 1;
        Agendamento agendamento = new Agendamento(novoId, cliente, tipoServico, data, "Pendente");
        agendamentoDAO.criarAgendamento(agendamento);
    }

    public void excluirAgendamento(int id) throws SQLException {
        agendamentoDAO.excluirAgendamento(id);
    }

    public void editarAgendamento(int id, String status) throws SQLException {
        agendamentoDAO.editarAgendamento(id, status);
    }

    public boolean verificarDataDisponivel(LocalDateTime data) throws SQLException {
        for (Agendamento agendamento : agendamentoDAO.buscarAgendamentos()) {
            if (agendamento.getDataHora().equals(data)) {
                return false;
            }
        }
        return true;
    }

}

