/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

/**
 *
 * @author Amal mabri
 */
public class CafeResto {

    private int id;
    private String libelle;
    private String description;
    private String numtel;
    private String photo;
    private int idSouk;
    private int idprprio;
    private int accept;

    public CafeResto() {
    }

   
    public void setAccept(int accept) {
        this.accept = accept;
    }

    public int getAccept() {
        return accept;
    }

    public CafeResto(int id, String libelle, String description, String numtel, String photo, int idSouk, int cinProprio, int accept) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.numtel = numtel;
        this.photo = photo;
        this.idSouk = idSouk;
        this.idprprio = cinProprio;
        this.accept = accept;
    }

   
   

    public CafeResto(String libelle, String description, String numtel, String photo, int idSouk, int cinProprio) {
        this.libelle = libelle;
        this.description = description;
        this.numtel = numtel;
        this.idSouk = idSouk;
        this.idprprio = cinProprio;
        this.photo = photo;
    }

    public CafeResto(int id, String libelle, String description, String numtel, String photo, int idSouk, int cinProprio) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.numtel = numtel;
        this.photo = photo;
        this.idSouk = idSouk;
        this.idprprio = cinProprio;
    }

    
    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public String getNumtel() {
        return numtel;
    }

    public int getIdSouk() {
        return idSouk;
    }


    public String getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public void setIdSouk(int idSouk) {
        this.idSouk = idSouk;
    }

    public int getIdprprio() {
        return idprprio;
    }

  

    public void setIdprprio(int idprprio) {
        this.idprprio = idprprio;
    }

  
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "CafeResto{" + "id=" + id + ", libelle=" + libelle + ", description=" + description + ", numtel=" + numtel + ", idSouk=" + idSouk + ", cinProprio=" + idprprio + ", photo=" + photo + '}';
    }
    
    
}
