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

    @Override
    public void save(Professionel h) {
        h = em.merge(h);
        em.persist(h);
    }

    @Override
    public void update(Professionel h) {
        em.merge(h);
    }

    @Override
    public void delete(Professionel h) {
        h = em.merge(h);
        em.remove(h);
    }

    @Override
    public Professionel find(long id) {
        return em.find(Professionel.class, id);
    }

    @Override
    public boolean authentification(String login, String mdp) {
        Query q = em.createQuery("SELECT * FROM Professionel WHERE login= ? AND mdp= ?").setParameter(1, login).setParameter(2, mdp);
        if (!q.getResultList().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Professionel> findAll() {
        Query q = em.createQuery("SELECT * FROM Professionel");
        return q.getResultList();
    }

    @Override
    public List<Professionel> findByName(String nom) {
        Query q = em.createQuery("SELECT * FROM Professionel WHERE nom= ?").setParameter(1, nom);
        return q.getResultList();
    }

}
