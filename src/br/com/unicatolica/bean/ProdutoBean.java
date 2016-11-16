/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.bean;

import br.com.unicatolica.dao.ProdutoDAO;
import br.com.unicatolica.model.Produto;
import br.com.unicatolica.utilitario.Alertas;

/**
 *
 * @author Reginaldo
 */
public class ProdutoBean {
    
    private Produto produto;
    private ProdutoDAO pDao;
    
    public ProdutoBean() {
        produto = new Produto();
        pDao = new ProdutoDAO();
    }
    
    public void salvar() {
        try {
            pDao.salvar(produto);
            Alertas.mensagemConfirmacao("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            Alertas.mensagemErro(e.getMessage());
        }
    }
    
    public void atualizar() {
        try {
            pDao.atualizar(produto);
            Alertas.mensagemConfirmacao("Produto atualizado com sucesso!");
        } catch (Exception e) {
            Alertas.mensagemErro(e.getMessage());
        }
    }
    
    public void excluir() {
        try {
            pDao.excluir(produto);
            Alertas.mensagemConfirmacao("Produto excluído!");
        } catch (Exception e) {
            Alertas.mensagemErro(e.getMessage());
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
