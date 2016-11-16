
package br.com.unicatolica.bean;

import br.com.unicatolica.dao.UsuarioDAO;
import br.com.unicatolica.model.Usuario;
import br.com.unicatolica.utilitario.Alertas;
import br.com.unicatolica.view.FormPrincipal;

/**
 *
 * @author Reginaldo
 */
public class UsuarioBean {
    
    private Usuario usuario;
    private UsuarioDAO uDao;
    
    public UsuarioBean() {
        usuario = new Usuario();
        uDao = new UsuarioDAO();
    }
    
    public void logarSitema() {
        try {
            if(uDao.logar(usuario) == true) {
                Alertas.mensagemConfirmacao("Usuário logado!");
                new FormPrincipal().setVisible(true);
            } else {
                Alertas.mensagemAviso("Usuário ou senha incorretos!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alertas.mensagemErro("Erro ao executar a sql!");
        }
    }
    
    public void salvar() {
        try {
            uDao.salvar(usuario);
            Alertas.mensagemConfirmacao("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            Alertas.mensagemErro("Erro ao tentar salvar o usuário!");
        }
    }

    public void atualizar() {
        try {
            uDao.atualizar(usuario);
            Alertas.mensagemConfirmacao("Usuário atualizado com sucesso!");
        } catch (Exception e) {
            Alertas.mensagemErro("Erro ao tentar atualizar o usuário!");
        }
    }
    
    public void excluir() {
        try {
            uDao.excluir(usuario);
            Alertas.mensagemConfirmacao("Usuário excluído com sucesso!");
        } catch (Exception e) {
            Alertas.mensagemErro("Erro ao tentar excluir o usuário!");
        }
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
