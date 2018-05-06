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
public class CommandeProduit {

  
    private int idproduit;
    private int qte;
    private String photo;
    private double prix;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    public void setPrix(float prix) {
        this.prix = prix;
    }
    private Produit p;
    private Boutique b;

    public CommandeProduit(int id, int idproduit, Boutique b, int stat) {//added
      
        this.idproduit = idproduit;
        this.b = b;
    }

    public CommandeProduit(int idcommande, int idproduit, Produit p, int stat) {//added
      
        this.idproduit = idproduit;
        this.p = p;
    }

    public CommandeProduit() {
    }

    public CommandeProduit(int idcommande, int idproduit, int qte) {
      
        this.idproduit = idproduit;
        this.qte = qte;
    }

    
    public int getIdproduit() {
        return idproduit;
    }

    public int getQte() {
        return qte;
    }




    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public Boutique getB() {
        return b;
    }

    public void setB(Boutique b) {
        this.b = b;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "CommandeProduit{" + "idproduit=" + idproduit + ", qte=" + qte + ", photo=" + photo + ", prix=" + prix + ", p=" + p + ", b=" + b + '}';
    }

 

}
