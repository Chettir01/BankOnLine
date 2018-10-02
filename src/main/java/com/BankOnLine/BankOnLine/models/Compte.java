package com.BankOnLine.BankOnLine.models;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nada
 */
@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long numCompte;
    private float solde;
    @Column(unique = true)
    private long idPerson;
    private String iban;
    private long typeCompte;

    public Compte(){}

    public Compte(long numCompte, float solde, long idPerson, String iban, long typeCompte) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.idPerson = idPerson;
        this.iban = iban;
        this.typeCompte = typeCompte;
    }


    public long getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(long typeCompte) {
        this.typeCompte = typeCompte;
    }

    public long getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(long numCompte) {
        this.numCompte = numCompte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public long getId() {
        return id;
    }

    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

}
