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
public class ConseillerDAOImpl implements ConseillerDAO {

    @PersistenceContext(unitName = "BanqueEnLignePU")
    private EntityManager em;

    @Override
    public void save(Conseiller h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Conseiller h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Conseiller h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = true)
    @Override
    public Conseiller find(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Transactional(readOnly = true)
    @Override
    public Conseiller authentification(String login, String mdp) {
        Query q = em.createQuery("SELECT c "
                + "FROM Conseiller c "
                + "WHERE c.login =?1 "
                + "AND c.mdp =?2 "
        );
        q.setParameter(1, login);
        q.setParameter(2, mdp);
        if (!q.getResultList().isEmpty()) {
            System.out.println("trouver");
            return (Conseiller) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Conseiller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conseiller> findByName(String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
