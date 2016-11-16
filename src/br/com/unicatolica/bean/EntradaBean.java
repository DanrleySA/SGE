/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.bean;

import br.com.unicatolica.dao.EntradaDAO;
import br.com.unicatolica.dao.ProdutoDAO;
import br.com.unicatolica.model.Entrada;
import br.com.unicatolica.utilitario.Alertas;

/**
 *
 * @author danrl
 */
public class EntradaBean {

    private Entrada entrada;
    private EntradaDAO entDAO;
    private ProdutoDAO pDao;
    
    public EntradaBean() {
        entrada = new Entrada();
        entDAO = new EntradaDAO();
        pDao = new ProdutoDAO();
    }

    public void salvar() {
        try {
            entDAO.salvar(entrada);
            Alertas.mensagemConfirmacao("Entrada finalizada com sucesso!");
        } catch (Exception e) {
            Alertas.mensagemErro("Erro ao tentar finalizar entrada!\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cancelar() {
        try {
            entDAO.cancelar(entrada);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cancelarProdutos() {
        try {
            pDao.cancelar(entrada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

}
