package br.com.unicatolica.dao;

import br.com.unicatolica.conexao.ConectaDB;
import br.com.unicatolica.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class UsuarioDAO {

    public boolean logar(Usuario u) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "select * from tb_usuario where usuario = ? and senha = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, u.getUsuario());
        st.setString(2, u.getSenha());
        ResultSet rs = st.executeQuery();
        if (rs.first()) {
            return true;
        } else {
            return false;
        }
    }

    public void salvar(Usuario u) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "insert into tb_usuario (usuario, senha) values(?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, u.getUsuario());
        st.setString(2, u.getSenha());
        st.execute();
        st.close();
        con.close();
    }
    
    public void atualizar(Usuario u) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "update tb_usuario set usuario = ?, senha = ? where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, u.getUsuario());
        st.setString(2, u.getSenha());
        st.setInt(3, u.getId());
        st.execute();
        st.close();
        con.close();
    }
    
    public void excluir(Usuario u) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "delete from tb_usuario where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, u.getId());
        st.execute();
        st.close();
        con.close();
    }
    
    public List<Usuario> consultar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        Connection con = ConectaDB.getConnection();
        String sql = "select * from tb_usuario";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setUsuario(rs.getString("usuario"));
            u.setSenha(rs.getString("senha"));
            lista.add(u);
        }
        return lista;
    }
}







