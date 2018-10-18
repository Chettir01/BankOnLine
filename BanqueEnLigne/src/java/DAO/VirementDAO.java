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
public interface VirementDAO {
          public void save(Virement h);
 public void update(Virement h);
 public void delete(Virement h);
 public Virement find(long id);
 public List<Virement> findAll();
 public List<Virement> findByPerson( long id);
}
