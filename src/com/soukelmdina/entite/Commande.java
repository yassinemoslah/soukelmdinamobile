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
public class Commande {
    private int id ;
    private double totalPrix;
    private String dateLivraison;
    private String cinAchetur;
    
    
    public Commande(int id, double totalPrix, String dateLivraison, String cinAchetur) {
        this.id = id;
        this.totalPrix = totalPrix;
        this.dateLivraison = dateLivraison;
        this.cinAchetur = cinAchetur;
      
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
        return "Commande{" + "id=" + id + ", totalPrix=" + totalPrix + ", dateLivraison=" + dateLivraison + ", cinAchetur=" + cinAchetur + '}';
    }

   

   
    
    
}
