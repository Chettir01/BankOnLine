/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Compte;
import DAO.TypeOrdre;
import java.util.List;

/**
 *
 * @author Julien
 */
public interface TypeOrdreService {
            public void add(String iban,Compte compte,float somme);

    public void remove(String nom);

    public boolean auth(String login, String mdp);

    public String getNomsMessages();
    public TypeOrdre findById(long Id);
    
     public List<TypeOrdre> findAll();
}
