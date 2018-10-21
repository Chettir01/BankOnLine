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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Julien
 */
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
    public List<Client> findByName( String nom,String prenom) {
        Query q = em.createQuery("SELECT * FROM particulier WHERE nom= ? AND prenom= ?").setParameter(1, nom).setParameter(2, prenom);
        return q.getResultList();

    }

    @Override
    public boolean authentification(String login, String mdp) {
              //Query q = em.createNativeQuery("SELECT * FROM PARTICULIER p WHERE p.LOGIN = ? AND p.MDP = ?");
              Query q = em.createQuery("SELECT p FROM Client p WHERE p.login = ?1 AND p.mdp = ?2");
              q.setParameter(1,login);
              q.setParameter(2,mdp);
               System.err.println("true");
             if(!q.getResultList().isEmpty()){
                
                  return true;
             }else{
                 return false;
             }
       
    }
}
