package controle;

import dao.DaoUsuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Usuario;
import util.JsfUtil;

/**
 *
 * @author José Processa as requisições e respostas da página index.xhtml
 */
@Named
@ViewScoped
public class NovoUsuarioControle implements Serializable {
    
    private Usuario usuario;
    private DaoUsuario dao;

    @PostConstruct
    public void iniciar() {
        usuario = new Usuario();
        dao = new DaoUsuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void salvar(){
        dao.inserir(usuario);
    }
}
