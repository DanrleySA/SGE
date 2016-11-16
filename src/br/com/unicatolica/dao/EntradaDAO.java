/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.dao;

import br.com.unicatolica.conexao.ConectaDB;
import br.com.unicatolica.model.Entrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danrl
 */
public class EntradaDAO {

    public void salvar(Entrada ent) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "insert into tb_entradas (memorando, valor_total, data_entrada)"
                + "values(?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, ent.getMemorando());
        st.setDouble(2, ent.getValorTotal());
        st.setString(3, ent.getData());
        st.execute();
        con.close();
    }

    public static Entrada getLastEntrada() throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "select id from tb_entradas order by id desc limit 1";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        Entrada ent = new Entrada();
        if (rs.first()) {
            ent.setId(rs.getInt("id"));
        }
        con.close();
        return ent;
    }

    public static List<Entrada> listarEntradas() throws SQLException {
        List<Entrada> lista = new ArrayList<>();
        Connection con = ConectaDB.getConnection();
        String sql = "select * from tb_entradas order by str_to_date(data_entrada, '%d/%m/%Y') desc, id desc";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Entrada ent = new Entrada();
            ent.setId(rs.getInt("id"));
            ent.setMemorando(rs.getString("memorando"));
            ent.setValorTotal(rs.getDouble("valor_total"));
            ent.setData(rs.getString("data_entrada"));
            lista.add(ent);
        }
        return lista;
    }

    public void cancelar(Entrada ent) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "delete from tb_entradas where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, ent.getId());
        st.execute();
        con.close();
    }
}
