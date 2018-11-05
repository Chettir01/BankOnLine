/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Julien
 */
public interface CompteDAO {

    public void save(Compte h);

    public List<Compte> findNonvalide();

    public void update(Compte h);

    public void delete(Compte h);

    public Compte find(long id);

    public List<Compte> findAll();

    public List<Compte> findByClient(Client client);

    public Compte findById(long id);

    public Compte findByIBAN(String IBAN);

    public List<Compte> findByConseiller(Conseiller c);
    public List<Compte> findByClientvalide(Client c);
    public boolean alreadyexist(Client c);
}
