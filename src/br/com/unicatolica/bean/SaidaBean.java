/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.bean;

import br.com.unicatolica.dao.SaidaDAO;
import br.com.unicatolica.model.ProdutoSaida;
import br.com.unicatolica.model.Saida;
import java.sql.SQLException;

/**
 *
 * @author danrl
 */
public class SaidaBean {

    private Saida saida;

    public SaidaBean() {
        saida = new Saida();
    }

    public void salvarSaida() throws SQLException {
        SaidaDAO.salvar(saida);
        for (ProdutoSaida ps : saida.getLista()) {
            ps.setSaida(SaidaDAO.getUltimaSaida());
            SaidaDAO.salvarProdutosSaida(ps);
            SaidaDAO.retirarDoEstoque(ps);
        }
    }

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

}
