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
import javax.persistence.OneToMany;

/**
 *
 * @author Julien
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=STRING,length = 20)
@DiscriminatorValue("CLIENT")
public class Client {

    @Id
    @GeneratedValue
    private long IDClient;

    @Column
    private String login;
    
    @OneToMany(mappedBy = "client")
    List<Compte> listecompte=new ArrayList<Compte>();

    @Column
    private String mdp;

    @Column
    private String adresse;

    @Column
    private String tel;
    
    @Column
    private long conseiler;
    
    public long getIDClient() {
        return IDClient;
    }

    public void setIDClient(long IDClient) {
        this.IDClient = IDClient;
    }

    public long getConseiler() {
        return conseiler;
    }

    public void setConseiler(long conseiler) {
        this.conseiler = conseiler;
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
