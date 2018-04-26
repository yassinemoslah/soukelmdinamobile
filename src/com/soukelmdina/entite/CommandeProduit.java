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

    private int idcommande;
    private int idproduit;
    private int qte;
    private int stat;
    private Produit p;
    private Boutique b;

    public CommandeProduit(int id, int idproduit, Boutique b, int stat) {//added
        this.idcommande = id;
        this.idproduit = idproduit;
        this.b = b;
        this.stat = stat;
    }

    public CommandeProduit(int idcommande, int idproduit, Produit p, int stat) {//added
        this.idcommande = idcommande;
        this.idproduit = idproduit;
        this.p = p;
        this.stat = stat;
    }

    public CommandeProduit() {
    }

    public CommandeProduit(int idcommande, int idproduit, int qte) {
        this.idcommande = idcommande;
        this.idproduit = idproduit;
        this.qte = qte;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public int getQte() {
        return qte;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
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

    @Override
    public String toString() {
        return "CommandeProduit{" + "idcommande=" + idcommande + ", idproduit=" + idproduit + ", qte=" + qte + '}';
    }

}
