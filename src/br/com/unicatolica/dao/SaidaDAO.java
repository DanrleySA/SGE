/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.dao;

import br.com.unicatolica.conexao.ConectaDB;
import br.com.unicatolica.model.ProdutoSaida;
import br.com.unicatolica.model.Saida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danrl
 */
public class SaidaDAO {

    public static void salvar(Saida saida) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "insert into tb_saidas (memorando, data_saida) values(?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, saida.getMemorando());
        st.setString(2, saida.getDataSaida());
        st.execute();
        con.close();
    }

    public static void salvarProdutosSaida(ProdutoSaida prod) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "insert into tb_produtos_saida (saida_codigo, produto_codigo, qtde)"
                + "values(?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, prod.getSaida().getCodigo());
        st.setInt(2, prod.getProduto().getCodigo());
        st.setInt(3, prod.getQuantidade());
        st.execute();
        con.close();
    }

    public static void retirarDoEstoque(ProdutoSaida prod) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "update tb_produtos set quantidade = quantidade - ? "
                + "where codigo = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, prod.getQuantidade());
        st.setInt(2, prod.getProduto().getCodigo());
        st.execute();
        con.close();
    }

    public static Saida getUltimaSaida() throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "select codigo from tb_saidas order by codigo desc limit 1";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        rs.first();
        Saida saida = new Saida();
        saida.setCodigo(rs.getInt("codigo"));
        con.close();
        return saida;
    }
}
