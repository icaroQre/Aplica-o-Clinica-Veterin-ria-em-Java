package controle;

import dao.DaoTutor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Tutor;

/**
 *
 * @author José Processa as requisições e respostas da página index.xhtml
 */
@Named
@ViewScoped
public class NovoTutorControle implements Serializable {
    
    private Tutor tutor;
    private DaoTutor dao;

    @PostConstruct
    public void iniciar() {
        tutor = new Tutor();
        dao = new DaoTutor();
    }
    
    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void salvar(){
        dao.inserir(tutor);
    }
}