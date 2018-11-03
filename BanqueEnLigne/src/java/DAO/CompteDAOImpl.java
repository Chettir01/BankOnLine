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
public class CompteDAOImpl implements CompteDAO {

    @PersistenceContext(unitName = "BanqueEnLignePU")
    private EntityManager em;

    @Transactional
    @Override
    public void save(Compte h) {
        h = em.merge(h);
        em.persist(h);
    }

    @Transactional
    @Override
    public void update(Compte h) {
        em.merge(h);
    }

    @Transactional
    @Override
    public void delete(Compte h) {
        h = em.merge(h);
        em.remove(h);
    }

    @Override
    public Compte find(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compte> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public List<Compte> findByClient(Client client) {
        Query q = em.createQuery("SELECT  l FROM Client c LEFT JOIN c.listecompte l "
                + "WHERE c = ?1"
        );
        q.setParameter(1, client);
        System.out.println(q.getResultList().size());
        if (!q.getResultList().isEmpty()) {
            return q.getResultList();
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public List<Compte> findNonvalide() {
        Query q = em.createQuery("SELECT  c FROM Compte c "
                + "WHERE c.valide = ?1"
        );
        q.setParameter(1, false);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList();
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public Compte findById(long id) {
        Query q = em.createQuery("SELECT c "
                + "FROM Compte c "
                + "WHERE c.ID_compte =?1 "
        );
        q.setParameter(1, id);
        return (Compte) q.getResultList().get(0);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Compte> findByConseiller(Conseiller c) {
        Query q = em.createQuery("SELECT c "
                + "FROM Compte c "
                + "WHERE c.conseillercompte =?1 "
        );
        q.setParameter(1, c);
        if (!q.getResultList().isEmpty()) {
            System.out.println("trouver");
            return (List<Compte>) q.getResultList();
        } else {
            System.out.println("pas trouver");
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Compte findByIBAN(String IBAN) {
        Query q = em.createQuery("SELECT c "
                + "FROM Compte c "
                + "WHERE c.iban =?1 "
        );
        q.setParameter(1, IBAN);
        if (!q.getResultList().isEmpty()) {
            return (Compte) q.getResultList().get(0);
        } else {
            return null;
        }
    }

}
