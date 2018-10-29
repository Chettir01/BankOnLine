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
public interface TypeCompteDAO {
          public void save(TypeCompte h);
 public void update(TypeCompte h);
 public void delete(TypeCompte h);
 public TypeCompte find(long id);
 public boolean authentification(String login,String mdp);
 public List<TypeCompte> findAll();
 public List<TypeCompte> findByName( String nom);
}
