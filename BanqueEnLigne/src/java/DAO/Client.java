/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.sql.Date;
import static java.sql.JDBCType.BOOLEAN;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Julien
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = STRING, length = 20)
@DiscriminatorValue("CLIENT")
public class Client {

    @Id
    @GeneratedValue
    private long IDClient;

    @Column
    private String login;

    @Column
    private String mdp;

    @Column
    private String adresse;

    @Column
    private String tel;
    
    public Client(){
       
    }

    public Client(long IDClient, String login, String mdp, String adresse, String tel) {
        this.IDClient = IDClient;
        this.login = login;
        this.mdp = mdp;
        this.adresse = adresse;
        this.tel = tel;
    }
    
 
    @OneToMany(mappedBy = "clientnotification")
    private List<Notification> listenotifications = new ArrayList<Notification>();


    @OneToMany(mappedBy = "clientcompte")
    private List<Compte> listecompte = new ArrayList<Compte>();

    @OneToMany(mappedBy = "clientmessage")
    private List<Message> listemessage = new ArrayList<Message>();

    @ManyToOne
    @JoinColumn(name = "conseiller")
    private Conseiller conseillerClient;

    public Conseiller getConseillerClient() {
        return conseillerClient;
    }

    public void setConseillerClient(Conseiller conseillerClient) {
        this.conseillerClient = conseillerClient;
    }

    public long getIDClient() {
        return IDClient;
    }

    public List<Compte> getListecompte() {
        return listecompte;
    }

    public void setListecompte(List<Compte> listecompte) {
        this.listecompte = listecompte;
    }

    public List<Message> getListemessage() {
        return listemessage;
    }

    public void setListemessage(List<Message> listemessage) {
        this.listemessage = listemessage;
    }

    public void setIDClient(long IDClient) {
        this.IDClient = IDClient;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return this.mdp;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return this.tel;
    }

}
