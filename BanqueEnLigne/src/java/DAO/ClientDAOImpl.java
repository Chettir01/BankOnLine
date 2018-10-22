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

    @Override
    public boolean authentification(String login, String mdp) {
       // Query q = em.createNativeQuery("SELECT * FROM Client p WHERE p.login ='juju' AND p.mdp ='juju'");
        Query q = em.createQuery("SELECT c "
                + "FROM Client c "
                + "WHERE c.login =?1 "
                + "AND c.mdp =?2 "
                + "AND (TYPE(c) =Client OR TYPE(c) =Professionel OR TYPE(c) = Particulier)");
       q.setParameter(1, login);
        q.setParameter(2, mdp);

        System.err.println(q.toString());
         System.err.println(login);
          System.err.println(mdp);
        if (!q.getResultList().isEmpty()) {
        System.err.println("true");
            return true;
        } else {
                    System.err.println("false");
            return false;
        }

    }
}
