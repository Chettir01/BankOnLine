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
public class Compte {
    
    public Compte(){
        
    }
    @ManyToOne
    @JoinColumn(name="Type")
    private TypeCompte type;

    public TypeCompte getT() {
        return type;
    }

    public void setT(TypeCompte t) {
        this.type = t;
    }

    public long getID_compte() {
        return ID_compte;
    }

    public void setID_compte(long ID_compte) {
        this.ID_compte = ID_compte;
    }
    
    
    @ManyToOne
    @JoinColumn(name="Client")
    private Client client;
    
    @OneToMany(mappedBy = "compte")
    private List<OrdreBourse> listeordre=new ArrayList<OrdreBourse>();

    public List<OrdreBourse> getListeordre() {
        return listeordre;
    }

    public void setListeordre(List<OrdreBourse> listeordre) {
        this.listeordre = listeordre;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Virement> getListevirement() {
        return listevirement;
    }

    public void setListevirement(List<Virement> listevirement) {
        this.listevirement = listevirement;
    }
    
    @OneToMany(mappedBy="compte")
    List<Virement> listevirement= new ArrayList<Virement>();
        
    @Id
    @GeneratedValue
	private long ID_compte;
    
    @Column
	private int numcompte;
    
    @Column
	private int solde;
    
    @Column
	private String iban;
    
    
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column
	private Date dateCreation;
    
    public Compte(long ID_compte, int numcompte, int solde, String iban, int typeCompte) {
        this.ID_compte = ID_compte;
        this.numcompte = numcompte;
        this.solde = solde;
        this.iban = iban;
    }

	public int getNumcompte() {
		return this.numcompte;
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
