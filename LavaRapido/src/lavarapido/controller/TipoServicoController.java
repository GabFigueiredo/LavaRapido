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
import lavarapido.dao.TipoServicoDAO;
import lavarapido.model.TipoServico;

public class TipoServicoController {
    private final TipoServicoDAO tipoServicoDAO = new TipoServicoDAO();

    public List<TipoServico> listarTiposServico() throws SQLException {
        return tipoServicoDAO.buscarServicos();
    }

    public TipoServico buscarTipoServicoPorID(int id) throws SQLException {
        tipoServicoDAO.buscarServicoPorID(id);
        return null;
    }

    public boolean cadastrarTipoServico(TipoServico tipoServico) throws SQLException {
        if (!verificarNomeExistente(tipoServico)) {
            tipoServicoDAO.criarServico(tipoServico);
            return true;
        }
        return false;
    }

    public boolean editarTipoServico(int id, double novoPreco, String novaDescricao) throws SQLException {
            tipoServicoDAO.editarServico(id, novaDescricao, novoPreco);
            return true;
    }

    public boolean excluirTipoServico(int id) throws SQLException {
        tipoServicoDAO.excluirServico(id);
        return true;
    }

    public boolean verificarNomeExistente(TipoServico tipoServico) throws SQLException {
        for (TipoServico tipo : tipoServicoDAO.buscarServicos()) {
            if (tipo.getNome().equalsIgnoreCase(tipoServico.getNome())) {
                return true;
            }
        }
        return false;
    }
}

