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
public class OrdreBourseDAOImpl implements OrdreBourseDAO {

        @PersistenceContext(unitName = "BanqueEnLignePU")
    private EntityManager em;
    @Override
    public void save(OrdreBourse h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(OrdreBourse h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(OrdreBourse h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrdreBourse find(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdreBourse> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public List<OrdreBourse> findByCompte(Compte c) {
        Query q = em.createQuery("SELECT o"
                + " FROM OrdreBourse o "
                + "WHERE o.compte=?1");
        q.setParameter(1, c);
        return q.getResultList();
    }
    
}
