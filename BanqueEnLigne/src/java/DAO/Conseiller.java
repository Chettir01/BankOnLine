/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Julien
 */
@Entity
public class Conseiller  {

    public List<Message> getListemessage() {
        return listemessage;
    }

    public void setListemessage(List<Message> listemessage) {
        this.listemessage = listemessage;
    }

    public List<Compte> getListecompte() {
        return listecompte;
    }

    public void setListecompte(List<Compte> listecompte) {
        this.listecompte = listecompte;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String login;
    @Column
    private String mdp;
    @Column
    private String nom;
    @Column
    private String prenom;
    
    @OneToMany(mappedBy = "conseiller")
    private List<Message> listemessage=new ArrayList<Message>();
    @JsonIgnore
    @OneToMany(mappedBy = "conseillercompte")
    private List<Compte> listecompte=new ArrayList<Compte>();

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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conseiller)) {
            return false;
        }
        Conseiller other = (Conseiller) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Conseiller[ id=" + id + " ]";
    }

}
