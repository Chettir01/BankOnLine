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
public class ParticulierDAOimpl implements ParticulierDAO {

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
    public void save(Particulier h) {
        h = em.merge(h);
        em.persist(h);

    }

    @Transactional
    @Override
    public void update(Particulier h) {
        em.merge(h);
    }

    @Transactional
    @Override
    public void delete(Particulier h) {
        h = em.merge(h);
        em.remove(h);

    }

    @Transactional(readOnly = true)
    @Override
    public Particulier find(long id) {
        return em.find(Particulier.class, id);

    }

    @Transactional(readOnly = true)
    @Override
    public List<Particulier> findAll() {
        Query q = em.createQuery("SELECT h FROM HelloEntity h");
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Particulier> findByName(String nom, String prenom) {
        Query q = em.createQuery("SELECT * FROM particulier WHERE nom= ? AND prenom= ?").setParameter(1, nom).setParameter(2, prenom);
        return q.getResultList();

    }

    @Override
    public boolean authentification(String login, String mdp) {
        //Query q = em.createNativeQuery("SELECT * FROM PARTICULIER p WHERE p.LOGIN = ? AND p.MDP = ?");
        Query q = em.createQuery("SELECT p FROM Particulier p WHERE p.login = ?1 AND p.mdp = ?2");
        q.setParameter(1, login);
        q.setParameter(2, mdp);
        System.err.println("true");
        if (!q.getResultList().isEmpty()) {

            return true;
        } else {
            return false;
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Particulier findBylogin(String login) {
        Query q = em.createQuery("SELECT p FROM Particulier p WHERE p.login = ?1");
        q.setParameter(1, login);
        if (!q.getResultList().isEmpty()) {

            return (Particulier) q.getResultList().get(0);
        } else {
            return null;
        }
    }

}
