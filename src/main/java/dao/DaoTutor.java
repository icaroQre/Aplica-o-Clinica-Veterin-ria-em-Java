
package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import util.JpaUtil;
import modelo.Tutor;

/**
 *
 * @author José 
 * Métodos adicionais específicos de Usuario que não existem na classe genérica Dao.java
 */

public class DaoTutor implements Serializable{
    EntityManager manager;
    
    public boolean jaExiste(String nome) {
        Tutor temp = null;
        boolean existe = false; 
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT u FROM Usuario u WHERE u.login = :login";
        TypedQuery<Tutor> query = manager.createQuery(sql, Tutor.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
            existe = true; 
        } catch (Exception e) {  
            temp = null; 
        } finally {
            manager.close();
        }
        return existe;
    }
    
    public void inserir(Tutor u) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(u);
        tx.commit();
    }
    
}