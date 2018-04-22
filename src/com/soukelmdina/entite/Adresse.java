/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

/**
 *
 * @author mosla
 */
public class Adresse {
    private String cin; 
    private String adresse; 
    private int codePostal; 
    private String ville;

    public Adresse() {
    }

    public Adresse(String cin, String adresse, int codePostal, String ville) {
        this.cin = cin;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    
    public Adresse(String adresse, int codePostal, String ville) {
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" + "cin=" + cin + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + '}';
    }
    
    
    
}
