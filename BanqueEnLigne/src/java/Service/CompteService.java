/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Client;
import DAO.Compte;
import DAO.Conseiller;
import java.util.List;

/**
 *
 * @author Julien
 */
public interface CompteService {

    public void add(Compte c);

    public void remove(Compte c);

    public void update(Compte h);

    public List<Compte> findByClient(Client client);

    public Compte findById(long id);

    public Compte findByIBAN(String IBAN);

    public List<Compte> findByConseiller(Conseiller c);

    public List<Compte> findNonvalide();
    public List<Compte> findByClientvalide();
    public List<Compte> findAll();
    public boolean alreadyexist(Client c);

}
