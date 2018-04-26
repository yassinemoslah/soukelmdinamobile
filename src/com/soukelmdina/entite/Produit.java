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

    private int idProduit;
    private String libelle;
    private String photo;
    private String description;
    private int quantite;
    private double prix;
    private float tauxPromotion;
    private int idBoutique;
    private Categorie categorie;
    private Boutique boutique;

    public Produit() {

    }

    public Produit(int idProduit, String libelle) {
        this.idProduit = idProduit;
        this.libelle = libelle;
    }

    
    public Produit(String libelle, String photo, String description, int quantite, int idBoutique, Categorie categorie) {
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.idBoutique = idBoutique;
        this.categorie = categorie;
    }

    public Produit(String libelle, String photo, int quantite, double prix, Categorie categorie, Boutique boutique) {
        this.libelle = libelle;
        this.photo = photo;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
        this.boutique = boutique;
    }

    public Produit(int idProduit, String libelle, String photo, String description, int quantite, double prix, Categorie categorie) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit(int idProduit, String libelle, String photo, String description, int quantite, double prix, float tauxPromotion, Categorie categorie) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.tauxPromotion = tauxPromotion;
        this.categorie = categorie;
    }

    public Produit(int idProduit, String libelle, String photo, String description, int quantite, double prix, float tauxPromotion, Categorie categorie, Boutique boutique) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.tauxPromotion = tauxPromotion;
        this.categorie = categorie;
        this.boutique = boutique;
    }

    public Produit(int idProduit, String libelle, String photo, String description, int quantite, double prix, float tauxPromotion, int idBoutique, Categorie categorie) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.tauxPromotion = tauxPromotion;
        this.idBoutique = idBoutique;
        this.categorie = categorie;

    }

    public Produit(String libelle, String photo, String description, int quantite, double prix, float tauxPromotion, int idBoutique, Categorie categorie) {
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.tauxPromotion = tauxPromotion;
        this.idBoutique = idBoutique;
        this.categorie = categorie;
    }

    public Produit(int idProduit, String libelle, String photo, String description, int quantite, double prix) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Produit(String libelle, String photo, String description, int quantite, double prix, int idBoutique, Categorie categorie) {
        this.libelle = libelle;
        this.photo = photo;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.idBoutique = idBoutique;
        this.categorie = categorie;
    }

    public Boutique getBoutique() {
        return boutique;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategories(Categorie Categories) {
        this.categorie = Categories;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getPhoto() {
        return photo;
    }

    public int getIdBoutique() {
        return idBoutique;
    }

    public String getLibelle() {
        return libelle;
    }

    public float getTauxPromotion() {
        return tauxPromotion;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setIdBoutique(int idBoutique) {
        this.idBoutique = idBoutique;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setTauxPromotion(float tauxPromotion) {
        this.tauxPromotion = tauxPromotion;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", libelle=" + libelle + ", photo=" + photo + ", description=" + description + ", quantite=" + quantite + ", prix=" + prix + ", tauxPromotion=" + tauxPromotion + ", categorie=" + categorie + '}';
    }

}
