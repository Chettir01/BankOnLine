package com.BankOnLine.BankOnLine.models;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String login;
    private String mdp;
    private Date dateNaissance;
    private String adresse;
    private String tel;
    private long typePerson;

    public Person(){}

    public Person(String nom, String prenom, String login, String mdp, Date dateNaissance, String adresse, String tel, long typePerson) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.typePerson = typePerson;
    }

    public long getId() {
        return id;
    }

    public long getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(long typePerson) {
        this.typePerson = typePerson;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}

