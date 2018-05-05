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
public class Produit {
    private int id;
    private String libelle;
    private String photo;
    private String description;
    private int quantite;
    private float prix;
    private int idboutique;
    private int idcategorie;
    private int idcommande;
    private String date;

    public Produit(int id, String libelle, String photo, String description, int quantite, float prix, int idboutique, int idcategorie, int idcommande, String date) {
        this.id = id;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.idboutique = idboutique;
        this.idcategorie = idcategorie;
        this.idcommande = idcommande;
        this.date = date;
    }

    public Produit() {
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getIdboutique() {
        return idboutique;
    }

    public void setIdboutique(int idboutique) {
        this.idboutique = idboutique;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "id : " + this.id + "libele : " + this.libelle + " description : " + 
                this.description + " prix : " + this.prix;
    }

}
