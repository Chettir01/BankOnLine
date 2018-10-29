/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Julien
 */
@Entity
public class Bourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nom;

    @Column
    private int prix;
    
    @Column
    private Date datelimite;

    public Date getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(Date datelimite) {
        this.datelimite = datelimite;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @OneToMany(mappedBy = "bourse")
    private List<OrdreBourse> listebourse = new ArrayList<OrdreBourse>();

    public List<OrdreBourse> getListebourse() {
        return listebourse;
    }

    public void setListebourse(List<OrdreBourse> listebourse) {
        this.listebourse = listebourse;
    }

    /*
    @JoinTable(
 name="OrdreBourse",
 joinColumns=@JoinColumn(name="id_Bourse"),
 inverseJoinColumns=@JoinColumn(name="id_Personne")
 )
 @ManyToMany*/
    public void setNom(String aNom) {
        this.nom = aNom;
    }

    public String getNom() {
        return this.nom;
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
        if (!(object instanceof Bourse)) {
            return false;
        }
        Bourse other = (Bourse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Bourse[ id=" + id + " ]";
    }

}
