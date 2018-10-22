/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Julien
 */
@Entity
public class OrdreBourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_Compte;
	private long id_Bourse;
	private int date_creation;
	private boolean achat;
	private int quantite;
	private int dateLimite;
	private long type;
	private int prixVente;
        
    @ManyToOne
    @JoinColumn(name="compte")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "boure")
    private Bourse bourse;
    
    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public long getId_Compte() {
        return id_Compte;
    }

    public void setId_Compte(long id_Compte) {
        this.id_Compte = id_Compte;
    }


	public void setId_Bourse(long id_Bourse) {
		this.id_Bourse = id_Bourse;
	}

	public long getId_Bourse() {
		return this.id_Bourse;
	}

	public void setDate_creation(int date_creation) {
		this.date_creation = date_creation;
	}

	public int getDate_creation() {
		return this.date_creation;
	}

	public void setAchat(boolean achat) {
		this.achat = achat;
	}

	public boolean isAchat() {
		return this.achat;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setDateLimite(int dateLimite) {
		this.dateLimite = dateLimite;
	}

	public int getDateLimite() {
		return this.dateLimite;
	}

	public void setType(long type) {
		this.type = type;
	}

	public long getType() {
		return this.type;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getPrixVente() {
		return this.prixVente;
	}


        
    
}
