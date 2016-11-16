/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.bean;

import br.com.unicatolica.dao.ProdutoDAO;
import br.com.unicatolica.model.ProdutoEntrada;
import br.com.unicatolica.utilitario.Alertas;

/**
 *
 * @author danrl
 */
public class ProdutoEntradaBean {

    private ProdutoEntrada produtoEntrada;
    private ProdutoDAO pDao;

    public ProdutoEntradaBean() {
        produtoEntrada = new ProdutoEntrada();
        pDao = new ProdutoDAO();
    }

    public void salvarProdutoEntrada() {
        try {
            pDao.salvarProdutoEntrada(produtoEntrada);
            pDao.adicionaNoEstoque(produtoEntrada);
        } catch (Exception e) {
            Alertas.mensagemErro("Erro ao tentar atualizar estoque!\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void retirarDoEstoque() {
        try {
            pDao.retiraDoEstoque(produtoEntrada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProdutoEntrada getProdutoEntrada() {
        return produtoEntrada;
    }

    public void setProdutoEntrada(ProdutoEntrada produtoEntrada) {
        this.produtoEntrada = produtoEntrada;
    }

}
