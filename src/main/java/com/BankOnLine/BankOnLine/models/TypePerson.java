package com.BankOnLine.BankOnLine.models;


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
public class TypePerson {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String typePerson;

    public TypePerson(){}

    public TypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public long getId() {
        return id;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }


}
