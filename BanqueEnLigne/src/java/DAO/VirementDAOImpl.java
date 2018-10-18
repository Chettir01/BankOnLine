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

/**
 *
 * @author Julien
 */
public class VirementDAOImpl implements VirementDAO {

    @PersistenceContext(unitName = "BanqueEnLignePU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Virement h) {
        h = em.merge(h);
        em.persist(h);
    }

    @Override
    public void update(Virement h) {
        em.merge(h);
    }

    @Override
    public void delete(Virement h) {
        h = em.merge(h);
        em.remove(h);
    }

    @Override
    public Virement find(long id) {
        return em.find(Virement.class, id);
    }



    @Override
    public List<Virement> findAll() {
        Query q = em.createQuery("SELECT * FROM Virement");
        return q.getResultList();
    }

    @Override
    public List<Virement> findByPerson(long id) {
       Query q = em.createQuery("SELECT * FROM Virement");
        return q.getResultList();    }


}
