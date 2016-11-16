package br.com.unicatolica.dao;

import br.com.unicatolica.conexao.ConectaDB;
import br.com.unicatolica.model.Entrada;
import br.com.unicatolica.model.Produto;
import br.com.unicatolica.model.ProdutoEntrada;
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
public class ProdutoDAO {

    public void salvar(Produto p) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "insert into tb_produtos (descricao, codigo_barras, preco_custo, preco_venda, quantidade) values (?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, p.getDescricao());
        st.setString(2, p.getCodigoBarras());
        st.setDouble(3, p.getPrecoCusto());
        st.setDouble(4, p.getPrecoVenda());
        st.setInt(5, p.getQuantidade());
        st.execute();
        st.close();
        con.close();
    }

    public void atualizar(Produto p) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "update tb_produtos set descricao = ?, codigo_barras = ?, preco_custo = ?, preco_venda = ? where codigo = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, p.getDescricao());
        st.setString(2, p.getCodigoBarras());
        st.setDouble(3, p.getPrecoCusto());
        st.setDouble(4, p.getPrecoVenda());
        st.setInt(5, p.getCodigo());
        st.execute();
        st.close();
        con.close();
    }

    public void excluir(Produto p) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "delete from tb_produtos where codigo = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, p.getCodigo());
        st.execute();
        st.close();
        con.close();
    }

    public static Produto buscaProduto(Integer codigo) throws SQLException {
        Produto p = new Produto();
        Connection con = ConectaDB.getConnection();
        String sql = "select * from tb_produtos where codigo = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        if (rs.first()) {
            p.setCodigo(codigo);
            p.setCodigoBarras(rs.getString("codigo_barras"));
            p.setDescricao(rs.getString("descricao"));
            p.setQuantidade(rs.getInt("quantidade"));
            p.setPrecoCusto(rs.getDouble("preco_custo"));
            return p;
        } else {
            return null;
        }
    }

    public void salvarProdutoEntrada(ProdutoEntrada pe) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "insert into tb_itens_entrada (produto_id, entrada_id, quantidade, "
                + "valor_unit, valor_total) values(?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, pe.getProduto().getCodigo());
        st.setInt(2, EntradaDAO.getLastEntrada().getId());
        st.setInt(3, pe.getQuantidade());
        st.setDouble(4, pe.getValorUnitario());
        st.setDouble(5, pe.getValorTotal());
        st.execute();
        con.close();
    }

    public void adicionaNoEstoque(ProdutoEntrada pe) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "update tb_produtos set quantidade = quantidade + ? "
                + "where codigo = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, pe.getProduto().getQuantidade());
        st.setInt(2, pe.getProduto().getCodigo());
        st.execute();
        con.close();
    }

    public void cancelar(Entrada ent) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "delete from tb_itens_entrada where entrada_id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, ent.getId());
        st.execute();
        con.close();
    }

    public void retiraDoEstoque(ProdutoEntrada pe) throws SQLException {
        Connection con = ConectaDB.getConnection();
        String sql = "update tb_produtos set quantidade = quantidade - ? "
                + "where codigo = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, pe.getProduto().getQuantidade());
        st.setInt(2, pe.getProduto().getCodigo());
        st.execute();
        con.close();
    }

    public static List<ProdutoEntrada> listarProdutosEntrada(Entrada ent) throws SQLException {
        List<ProdutoEntrada> lista = new ArrayList<>();
        Connection con = ConectaDB.getConnection();
        String sql = "select * from tb_itens_entrada i, tb_produtos p "
                + "where entrada_id = ? and p.codigo = i.produto_id";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, ent.getId());
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            ProdutoEntrada p = new ProdutoEntrada();
            Produto prod = new Produto();
            prod.setCodigo(rs.getInt("produto_id"));
            prod.setDescricao("descricao");
            p.setQuantidade(rs.getInt("quantidade"));
            p.setValorUnitario(rs.getDouble("valor_unit"));
            p.setValorTotal(rs.getDouble("valor_total"));
            p.setProduto(prod);
            lista.add(p);
        }
        return lista;
    }
}
