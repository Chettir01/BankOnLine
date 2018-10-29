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
public class TypeOrdreDAOImpl implements TypeOrdreDAO {

    @PersistenceContext(unitName = "BanqueEnLignePU")
    private EntityManager em;

    @Override
    public void save(TypeOrdre h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TypeOrdre h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TypeOrdre h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = true)
    @Override
    public TypeOrdre findById(long id) {
                Query q = em.createQuery("SELECT b"
                + " FROM TypeOrdre b "
                + " WHERE b.id=?1");
        q.setParameter(1, id);
        return (TypeOrdre) q.getResultList().get(0);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TypeOrdre> findAll() {
        Query q = em.createQuery("SELECT t"
                + " FROM TypeOrdre t ");
        return q.getResultList();
    }

}
