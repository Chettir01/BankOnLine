/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Professionel;

/**
 *
 * @author Julien
 */
public interface ProfessionelService {

    public void add(Professionel p);

    public void update(Professionel h);

    public void remove(String nom);

    public boolean auth(String login, String mdp);

    public String getNomsMessages();

    public Professionel find(long id);
    
    public Professionel findByLogin(String login);
}
