/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.model;

import java.util.List;

/**
 *
 * @author danrl
 */
public class Saida {

    private Integer codigo;
    private String memorando;
    private String dataSaida;
    private List<ProdutoSaida> lista;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMemorando() {
        return memorando;
    }

    public void setMemorando(String memorando) {
        this.memorando = memorando;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public List<ProdutoSaida> getLista() {
        return lista;
    }

    public void setLista(List<ProdutoSaida> lista) {
        this.lista = lista;
    }

}
