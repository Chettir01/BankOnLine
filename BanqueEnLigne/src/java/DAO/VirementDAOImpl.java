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
public class VirementDAOImpl implements VirementDAO {

    @PersistenceContext(unitName = "BanqueEnLignePU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public void save(Virement h) {
        h = em.merge(h);
        em.persist(h);
    }

    @Transactional
    @Override
    public void update(Virement h) {
        em.merge(h);
    }

    @Transactional
    @Override
    public void delete(Virement h) {
        h = em.merge(h);
        em.remove(h);
    }

    @Transactional(readOnly = true)
    @Override
    public Virement find(long id) {
        return em.find(Virement.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Virement> findAll() {
        Query q = em.createQuery("SELECT * FROM Virement");
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Virement> findByCompte(Compte c) {
        Query q = em.createQuery("SELECT v"
                + " FROM Virement v "
                + "WHERE v.compte=?1");
        q.setParameter(1, c);
        return q.getResultList();
    }

}
