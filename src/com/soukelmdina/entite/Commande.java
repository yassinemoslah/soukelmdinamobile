/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

import java.sql.Date;

/**
 *
 * @author Amal mabri
 */
public class Commande {
    private int id ;
    private double totalPrix;
    private String dateLivraison;
    private String cinAchetur;
    private Adresselivraison adl;
    
    public Commande(int id, double totalPrix, String dateLivraison, String cinAchetur) {
        this.id = id;
        this.totalPrix = totalPrix;
        this.dateLivraison = dateLivraison;
        this.cinAchetur = cinAchetur;
      
    }

    public void setAdl(Adresselivraison adl) {
        this.adl = adl;
    }

    public Adresselivraison getAdl() {
        return adl;
    }

    public Commande(int id, double totalPrix, String dateLivraison, String cinAchetur, Adresselivraison adl) {
        this.id = id;
        this.totalPrix = totalPrix;
        this.dateLivraison = dateLivraison;
        this.cinAchetur = cinAchetur;
        this.adl = adl;
    }

    public Commande(int id, double totalPrix, String cinAchetur, Adresselivraison adl) {
        this.id = id;
        this.totalPrix = totalPrix;
        this.cinAchetur = cinAchetur;
        this.adl = adl;
    }

    public Commande(double totalPrix, String cinAchetur, Adresselivraison adl) {
        this.totalPrix = totalPrix;
        this.cinAchetur = cinAchetur;
        this.adl = adl;
    }

 



    public Commande(double totalPrix, String cinAchetur) {
        this.totalPrix = totalPrix;
        this.cinAchetur = cinAchetur;
    }

    public Commande(int id, double totalPrix, String cinAchetur) {
        this.id=id;
        this.totalPrix = totalPrix;
        this.cinAchetur = cinAchetur;
    }
    public Commande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public double getTotalPrix() {
        return totalPrix;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public String getCinAchetur() {
        return cinAchetur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalPrix(double totalPrix) {
        this.totalPrix = totalPrix;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void setCinAchetur(String cinAchetur) {
        this.cinAchetur = cinAchetur;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", totalPrix=" + totalPrix + ", dateLivraison=" + dateLivraison + ", cinAchetur=" + cinAchetur + ", adl=" + adl + '}';
    }

   
    
    
}
