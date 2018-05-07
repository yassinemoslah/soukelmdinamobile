/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

/**
 *
 * @author lina9
 */
public class Souk1 {
    int id;
    String libelle;
    String gouvernorat;
    String photo;
    String description;

    public Souk1() {
    }

    public Souk1(int id, String libelle, String gouvernorat, String photo, String description) {
        this.id = id;
        this.libelle = libelle;
        this.gouvernorat = gouvernorat;
        this.photo = photo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Souk{" + "id=" + id + ", libelle=" + libelle + ", gouvernorat=" + gouvernorat + ", photo=" + photo + ", description=" + description + '}';
    }
    
    
    
}
