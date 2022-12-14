package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Tutor;
import modelo.Usuario;

/**
 *
 * @author José
 */
@Named
@ViewScoped
public class GerenciarAnimalControle implements Serializable {
    private Dao<Tutor> daoTutor;
    private List<Tutor> listaTutores;
    private Animal animal;
    private Dao<Animal> dao;
    private List<Animal> lista;
    private Animal animalSelecionado;

    public Animal getAnimalSelecionado() {
        return animalSelecionado;
    }

    public void setAnimalSelecionado(Animal animalSelecionado) {
        this.animalSelecionado = animalSelecionado;
    }
    
    @PostConstruct
    public void iniciar() {
        daoTutor = new Dao(Tutor.class);
        listaTutores = daoTutor.listarTodos();
        animal = new Animal();
        dao = new Dao (Animal.class);
        setLista(dao.listarTodos()); 
    } 
    
    public List<Tutor> getListaTutores() {
        return listaTutores;
    }

    public void setListaTutores(List<Tutor> listaTutores) {
        this.listaTutores = listaTutores;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public void salvar(){
        dao.inserir(animal);
    }
    public List<Animal> getLista() {
        return lista;
    }
    
    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }
    
    public void excluir(Animal excluido) {
        dao.excluir(excluido.getCodigo());
        lista = dao.listarTodos();
    }
    
    public void prepararVizualisar(Animal selecionado){
        animalSelecionado = selecionado;
    }
}