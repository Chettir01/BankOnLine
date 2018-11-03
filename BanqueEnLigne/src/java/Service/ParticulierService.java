/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Particulier;
import DAO.Professionel;

/**
 *
 * @author Julien
 */
public interface ParticulierService {
    public void add(String nom, String prenom);
    public void add(Particulier p);
    public void remove(String nom);
    public void update(Particulier h);
    public Particulier findById(long id);
    public boolean auth(String login,String mdp);
    public String getNomsMessages();
}
