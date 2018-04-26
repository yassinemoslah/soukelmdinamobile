/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author TAOUFIK
 */
public class Categorie {
    private int id ;
    private String libelle ;
    private Timestamp datCreation ;

    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public Categorie(int id, String libelle, Timestamp datCreation) {
        this.id = id;
        this.libelle = libelle;
        this.datCreation = datCreation;
    }

    public Timestamp getDatCreation() {
        return datCreation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDatCreation(Timestamp datCreation) {
        this.datCreation = datCreation;
    }

    
    
    public Categorie() {
    }
    
 
    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }

    
       
    
}


