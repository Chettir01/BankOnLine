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
public class ProfessionelDAOImpl implements ProfessionelDAO {

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
    public void save(Professionel h) {
        h = em.merge(h);
        em.persist(h);
    }

    @Transactional
    @Override
    public void update(Professionel h) {
        em.merge(h);
    }

    @Transactional
    @Override
    public void delete(Professionel h) {
        h = em.merge(h);
        em.remove(h);
    }

    @Transactional
    @Override
    public Professionel find(long id) {
        return em.find(Professionel.class, id);
    }

    @Transactional
    @Override
    public boolean authentification(String login, String mdp) {
        Query q = em.createQuery("SELECT * FROM Professionel WHERE login= ? AND mdp= ?").setParameter(1, login).setParameter(2, mdp);
        if (!q.getResultList().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional(readOnly = true)

    @Override
    public List<Professionel> findAll() {
        Query q = em.createQuery("SELECT * FROM Professionel");
        return q.getResultList();
    }

    @Transactional(readOnly = true)

    @Override
    public List<Professionel> findByName(String nom) {
        Query q = em.createQuery("SELECT * FROM Professionel WHERE nom= ?").setParameter(1, nom);
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Professionel findByLogin(String login) {
        Query q = em.createQuery("SELECT p FROM Professionel p WHERE p.login = ?1");
        q.setParameter(1, login);
        if (!q.getResultList().isEmpty()) {
            return (Professionel) q.getResultList().get(0);
        } else {
            return null;
        }
    }

}
