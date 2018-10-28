/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Julien
 */
@Repository
public class CompteDAOImpl implements CompteDAO {

        @PersistenceContext(unitName = "BanqueEnLignePU")
    private EntityManager em;
    
    @Override
    public void save(Compte h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Compte h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Compte h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compte find(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compte> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public List<Compte> findByClient(Client client) {
           Query q = em.createQuery("SELECT c "
                + "FROM Compte c "
                + "WHERE c.clientcompte =?1 "
                );
       q.setParameter(1, client);
        System.out.println(q.getResultList().size());
        if (!q.getResultList().isEmpty()) {
           return  q.getResultList();
        } else {
            return null;
        }
    }
    
}
