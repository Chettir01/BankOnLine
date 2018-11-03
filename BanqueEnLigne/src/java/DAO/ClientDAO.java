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
public interface ClientDAO {
      public void save(Client h);
 public void update(Client h);
 public void delete(Client h);
 public Client find(long id);
 public boolean findByLogin(String login);
 public Client authentification(String login,String mdp);
 public List<Client> findAll();
 public List<Client> findByName( String nom,String prenom);
}
