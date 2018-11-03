/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Julien
 */
@Entity
public class Compte {

    public Compte() {

    }
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeCompte type;

    @JoinTable(
            name = "Compte_client",
            joinColumns = @JoinColumn(name = "id_compte"),
            inverseJoinColumns = @JoinColumn(name = "id_client")
    )
    @ManyToMany
    private List<Client> listeclientcompte = new ArrayList<Client>();
    
    @Column
    boolean valide;

    public Conseiller getConseiller() {
        return conseillercompte;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseillercompte = conseiller;
    }

    @ManyToOne
    @JoinColumn(name = "conseillercompte")
    private Conseiller conseillercompte;

    @OneToMany(mappedBy = "compte")
    private List<OrdreBourse> listeordre = new ArrayList<OrdreBourse>();

    public TypeCompte getTypecompte() {
        return type;
    }

    public void setTypecompte(TypeCompte type) {
        this.type = type;
    }

    public long getID_compte() {
        return ID_compte;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    public List<Client> getListeclientcompte() {
        return listeclientcompte;
    }

    public void setListeclientcompte(List<Client> listeclientcompte) {
        this.listeclientcompte = listeclientcompte;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Conseiller getConseillercompte() {
        return conseillercompte;
    }

    public void setConseillercompte(Conseiller conseillercompte) {
        this.conseillercompte = conseillercompte;
    }

    public void setID_compte(long ID_compte) {
        this.ID_compte = ID_compte;
    }

    public List<OrdreBourse> getListeordre() {
        return listeordre;
    }

    public void setListeordre(List<OrdreBourse> listeordre) {
        this.listeordre = listeordre;
    }

    public List<Virement> getListevirement() {
        return listevirement;
    }

    public void setListevirement(List<Virement> listevirement) {
        this.listevirement = listevirement;
    }

    @OneToMany(mappedBy = "compte")
    List<Virement> listevirement = new ArrayList<Virement>();

    @Id
    @GeneratedValue
    private long ID_compte;


    @Column
    private int solde;

    @Column(unique = true)
    private String iban;

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column
    private Date dateCreation;

    public Compte( int solde, String iban, TypeCompte typeCompte) {
        this.solde = solde;
        this.iban = iban;
        this.type=typeCompte;
        this.valide=false;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getSolde() {
        return this.solde;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return this.iban;
    }

}
