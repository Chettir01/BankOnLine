/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Julien
 */
public enum ResponseJSON {
    Session("Session out"),
    Success("Success"),
    InformationIncomplete("Information manquante"),
    NotFound("Not found");
    private String name = "";

    //Constructeur
    ResponseJSON(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
