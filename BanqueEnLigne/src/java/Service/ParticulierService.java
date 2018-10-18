/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Julien
 */
public interface ParticulierService {
    public void add(String nom, String prenom);
    public void remove(String nom);
    public boolean auth(String login,String mdp);
    public String getNomsMessages();
}
