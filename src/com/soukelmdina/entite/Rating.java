/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

/**
 *
 * @author TAOUFIK
 */
public class Rating {
    
    private int id;
    
    private String nom;
    
    private String description;
    
    private int etoiles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    @Override
    public String toString() {
        return "nom "+ this.nom +" desc "+ this.description +" etoiles "+ this.etoiles;
    }
    
}
