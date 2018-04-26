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
public class Boutique {
    private int id;
    private String libelle;
    private String photo;
    private String description;
    private String numTel;
    private double caisse;
    private int id_souk;
    private String cin;
    private int accept;

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    public Boutique(int id, String libelle, String photo, String description, String numTel, double caisse, int id_souk, String cin) {
        this.id = id;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.numTel = numTel;
        this.caisse = caisse;
        this.id_souk = id_souk;
        this.cin = cin;
    }
    public Boutique(String libelle) {//added
        this.libelle=libelle;
    }
    public Boutique(int id, String libelle, String photo, String description, String numTel, double caisse, int id_souk, String cin, int accept) {
        this.id = id;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.numTel = numTel;
        this.caisse = caisse;
        this.id_souk = id_souk;
        this.cin = cin;
        this.accept=accept;
    }

    public Boutique(String libelle, String photo, String description, String numTel, double caisse, int id_souk, String cin, int accept) {
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.numTel = numTel;
        this.caisse = caisse;
        this.id_souk = id_souk;
        this.cin = cin;
        this.accept=accept;
    }
    
    public Boutique() {
    }

    public Boutique(int id, String libelle, String description, String numTel, int id_souk) {
       this.id = id;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.numTel = numTel;
        this.caisse = caisse;
        this.id_souk = id_souk;
    }

    public Boutique(int i, String lol, String yes, String yy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Boutique(String libelle, String img) {
        this.libelle = libelle;
        this.photo = img;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getNumTel() {
        return numTel;
    }

    public double getCaisse() {
        return caisse;
    }

    public int getId_souk() {
        return id_souk;
    }

    public String getCin() {
        return cin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setCaisse(double caisse) {
        this.caisse = caisse;
    }

    public void setId_souk(int id_souk) {
        this.id_souk = id_souk;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Override
    public String toString() {
        return "Boutique{" + "id=" + id + ", libelle=" + libelle + ", photo=" + photo + ", description=" + description + ", numTel=" + numTel + ", caisse=" + caisse + ", id_souk=" + id_souk + ", cin=" + cin + '}';
    }

}
