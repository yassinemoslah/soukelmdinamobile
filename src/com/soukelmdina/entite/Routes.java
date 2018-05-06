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
public class Routes {
    
    private static String baseURL = "http://192.168.43.231/soukelmdinaweb/web";
    
     private static String environnement = "/app_dev.php";
    
    private static String photoProduits = "http://192.168.43.231/soukelmdina/assets/img/produits";
    
    private static String listeProduits = "/app/api/listeproduits";
    
    private static String produitById = "/app/api/item/produit?id=";
    
    private static String listeCategories = "/app/api/listecategories";
    
    private static String listeRatings = "/app/api/produit/avis?id=";
    
    private static String listeReduiteBoutiques = "/app/api/listereduiteboutiques";
    
    private static String listeProduitsByBoutique = "/app/api/listeproduitbyboutiques?id=";
    
    private static String newProduit = "/app/api/new/produit";
    
    private static String updateProduit = "/app/api/update/produit";
    
    private static String addavis = "/app/api/new/avis";
    
    private static String updatePhotoProduit = "/app/api/update/photo/produit";
    
    private static String listeReclamationsProduit = "/app/api/liste/reclamations/produit?id=";
    
    private static String addreclamation = "/app/api/new/reclamation";
    
    private static String lastProduct = "/app/api/lastproduct";
    
    private static String dernierProduct = "/app/api/lastproduct";
    
    private static String listeProduitsVendeur = "/app/api/produits/vendeur?id=";

    public static String getBaseURL() {
        return baseURL;
    }

    public static void setBaseURL(String baseURL) {
        Routes.baseURL = baseURL;
    }

    public static String getEnvironnement() {
        return environnement;
    }

    public static void setEnvironnement(String environnement) {
        Routes.environnement = environnement;
    }

    public static String getPhotoProduits() {
        return photoProduits;
    }

    public static void setPhotoProduits(String photoProduits) {
        Routes.photoProduits = photoProduits;
    }

    public static String getListeProduits() {
        return listeProduits;
    }

    public static void setListeProduits(String listeProduits) {
        Routes.listeProduits = listeProduits;
    }

    public static String getProduitById() {
        return produitById;
    }

    public static void setProduitById(String produitById) {
        Routes.produitById = produitById;
    }

    public static String getListeCategories() {
        return listeCategories;
    }

    public static void setListeCategories(String listeCategories) {
        Routes.listeCategories = listeCategories;
    }

    public static String getListeRatings() {
        return listeRatings;
    }

    public static void setListeRatings(String listeRatings) {
        Routes.listeRatings = listeRatings;
    }

    public static String getListeReduiteBoutiques() {
        return listeReduiteBoutiques;
    }

    public static void setListeReduiteBoutiques(String listeReduiteBoutiques) {
        Routes.listeReduiteBoutiques = listeReduiteBoutiques;
    }

    public static String getListeProduitsByBoutique() {
        return listeProduitsByBoutique;
    }

    public static void setListeProduitsByBoutique(String listeProduitsByBoutique) {
        Routes.listeProduitsByBoutique = listeProduitsByBoutique;
    }

    public static String getNewProduit() {
        return newProduit;
    }

    public static void setNewProduit(String newProduit) {
        Routes.newProduit = newProduit;
    }

    public static String getAddavis() {
        return addavis;
    }

    public static void setAddavis(String addavis) {
        Routes.addavis = addavis;
    }

    public static String getUpdateProduit() {
        return updateProduit;
    }

    public static void setUpdateProduit(String updateProduit) {
        Routes.updateProduit = updateProduit;
    }

    public static String getUpdatePhotoProduit() {
        return updatePhotoProduit;
    }

    public static void setUpdatePhotoProduit(String updatePhotoProduit) {
        Routes.updatePhotoProduit = updatePhotoProduit;
    }

    public static String getListeReclamationsProduit() {
        return listeReclamationsProduit;
    }

    public static void setListeReclamationsProduit(String listeReclamationsProduit) {
        Routes.listeReclamationsProduit = listeReclamationsProduit;
    }

    public static String getAddreclamation() {
        return addreclamation;
    }

    public static void setAddreclamation(String addreclamation) {
        Routes.addreclamation = addreclamation;
    }

    public static String getListeProduitsVendeur() {
        return listeProduitsVendeur;
    }

    public static void setListeProduitsVendeur(String listeProduitsVendeur) {
        Routes.listeProduitsVendeur = listeProduitsVendeur;
    }

    public static String getDernierProduct() {
        return dernierProduct;
    }

    public static void setDernierProduct(String dernierProduct) {
        Routes.dernierProduct = dernierProduct;
    }
    
    
}
