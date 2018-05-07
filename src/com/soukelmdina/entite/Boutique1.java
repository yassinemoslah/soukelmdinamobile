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
public class Boutique1 {
    
    int id;
    String libelle;
    String photo;
    String description;
    String numTel;
    double caisse;
    int accept;
    int idSouk;
    String cinproprio;
    int idProprio;
    int nbL;
    int nbD;

    public Boutique1() {
    }

    public Boutique1(int id, String libelle, String photo, String description, String numTel, double caisse, int accept, int idSouk, String cinproprio, int idProprio, int nbL, int nbD) {
        this.id = id;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.numTel = numTel;
        this.caisse = caisse;
        this.accept = accept;
        this.idSouk = idSouk;
        this.cinproprio = cinproprio;
        this.idProprio = idProprio;
        this.nbL = nbL;
        this.nbD = nbD;
    }

    public Boutique1(String libelle, String description, String numtel, int n, String s) {
        this.libelle = libelle;
        this.description=description;
        this.numTel=numtel;
        this.idSouk=n;
        this.photo=s;
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

    public int getAccept() {
        return accept;
    }

    public int getIdSouk() {
        return idSouk;
    }

    public String getCinproprio() {
        return cinproprio;
    }

    public int getIdProprio() {
        return idProprio;
    }

    public int getNbL() {
        return nbL;
    }

    public int getNbD() {
        return nbD;
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

    public void setAccept(int accept) {
        this.accept = accept;
    }

    public void setIdSouk(int idSouk) {
        this.idSouk = idSouk;
    }

    public void setCinproprio(String cinproprio) {
        this.cinproprio = cinproprio;
    }

    public void setIdProprio(int idProprio) {
        this.idProprio = idProprio;
    }

    public void setNbL(int nbL) {
        this.nbL = nbL;
    }

    public void setNbD(int nbD) {
        this.nbD = nbD;
    }

    @Override
    public String toString() {
        return "Boutique{" + "id=" + id + ", libelle=" + libelle + ", photo=" + photo + ", description=" + description + ", numTel=" + numTel + ", caisse=" + caisse + ", accept=" + accept + ", idSouk=" + idSouk + ", cinproprio=" + cinproprio + ", idProprio=" + idProprio + ", nbL=" + nbL + ", nbD=" + nbD + '}';
    }
    
    
    
}
