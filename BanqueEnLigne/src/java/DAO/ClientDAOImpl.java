/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Julien
 */
@Repository
public class ClientDAOImpl implements ClientDAO {

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
    public void save(Client h) {
        h = em.merge(h);
        em.persist(h);

    }

    @Transactional
    @Override
    public void update(Client h) {
        em.merge(h);
    }

    @Transactional
    @Override
    public void delete(Client h) {
        h = em.merge(h);
        em.remove(h);

    }

    @Transactional(readOnly = true)
    @Override
    public Client find(long id) {
        return em.find(Client.class, id);

    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> findAll() {
        Query q = em.createQuery("SELECT h FROM HelloEntity h");
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> findByName(String nom, String prenom) {
        Query q = em.createQuery("SELECT * FROM particulier WHERE nom= ? AND prenom= ?").setParameter(1, nom).setParameter(2, prenom);
        return q.getResultList();

    }

    @Transactional
    @Override
    public Client authentification(String login, String mdp) {

        Query q = em.createQuery("SELECT c "
                + "FROM Client c "
                + "WHERE c.login =?1 "
                + "AND c.mdp =?2 "
                );
       q.setParameter(1, login);
        q.setParameter(2, mdp);
        if (!q.getResultList().isEmpty()) {
           return (Professionel) q.getResultList().get(0);
        } else {
            return null;
        }

    }

    @Override
    public boolean findByLogin(String login) {
        Query q = em.createQuery("SELECT c "
                + "FROM Client c "
                + "WHERE c.login =?1 ");
       q.setParameter(1, login);
        if (!q.getResultList().isEmpty()) {
           return true;
        } else {
            return false;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Client findByLoginobject(String login) {
       Query q = em.createQuery("SELECT c "
                + "FROM Client c "
                + "WHERE c.login =?1 ");
       q.setParameter(1, login);
        if (!q.getResultList().isEmpty()) {
           return (Client) q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
