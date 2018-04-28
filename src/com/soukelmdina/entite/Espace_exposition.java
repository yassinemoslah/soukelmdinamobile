package com.soukelmdina.entite;



    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
   

    /**
     *
     * @author marye
     */
    public class Espace_exposition {

        private int id;
        private String libelle;
        private String photo;
        private String description;
        private String numTel;
        private int idsouk;
        private String cin;
        private String categorie;
        private double longeur;
        private double largeur;
        private double prix;
        private String etat;
        private String cinlocataire;

        public void setCinlocataire(String cinlocataire) {
            this.cinlocataire = cinlocataire;
        }

        public Espace_exposition(int idsouk, String categorie) {
            this.idsouk = idsouk;
            this.categorie = categorie;
        }

        public String getCinlocataire() {
            return cinlocataire;
        }

        public Espace_exposition(String libelle, String photo, String description, String numTel, int idsouk, String cin, String categorie, double longeur, double largeur, double prix, String etat, String cinlocataire) {
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
            this.idsouk = idsouk;
            this.cin = cin;
            this.categorie = categorie;
            this.longeur = longeur;
            this.largeur = largeur;
            this.prix = prix;
            this.etat = etat;
            this.cinlocataire = cinlocataire;
        }

        public void setCategorie(String categorie) {
            this.categorie = categorie;
        }

        public void setLongeur(double longeur) {
            this.longeur = longeur;
        }

        public void setLargeur(double largeur) {
            this.largeur = largeur;
        }

        /*
     *** author Marzouk Maryem
         */
        public void setPrix(double prix) {
            this.prix = prix;
        }

        public double getPrix() {
            return prix;
        }

        public void setEtat(String etat) {
            this.etat = etat;
        }

        public String getEtat() {
            return etat;
        }

        public Espace_exposition(String libelle, String photo, String description, String numTel, int idsouk, String cin, String categorie, double longeur, double largeur, double prix, String etat) {
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
            this.idsouk = idsouk;
            this.cin = cin;
            this.categorie = categorie;
            this.longeur = longeur;
            this.largeur = largeur;
            this.prix = prix;
            this.etat = etat;
        }

        public Espace_exposition(int id, String libelle, String photo, String description, String numTel, int idsouk, String cin, String categorie, double longeur, double largeur, double prix, String etat) {
            this.id = id;
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
            this.idsouk = idsouk;
            this.cin = cin;
            this.categorie = categorie;
            this.longeur = longeur;
            this.largeur = largeur;
            this.prix = prix;
            this.etat = etat;
        }

        public Espace_exposition(int id, String libelle, String photo, String description, String numTel, int idsouk, String cin, String categorie, double longeur, double largeur, double prix) {
            this.id = id;
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
            this.idsouk = idsouk;
            this.cin = cin;
            this.categorie = categorie;
            this.longeur = longeur;
            this.largeur = largeur;
            this.prix = prix;
        }

        public Espace_exposition() {
        }

        public String getCategorie() {
            return categorie;
        }

        public double getLongeur() {
            return longeur;
        }

        public double getLargeur() {
            return largeur;
        }

        public Espace_exposition(int id, String libelle, String photo, String description, String numTel, int idsouk, String cin, String categorie, double longeur, double largeur) {
            this.id = id;
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
            this.idsouk = idsouk;
            this.cin = cin;
            this.categorie = categorie;
            this.longeur = longeur;
            this.largeur = largeur;
        }

        public Espace_exposition(int id, String libelle, String photo, String description, String numTel, int idsouk, String cin) {
            this.id = id;
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
            this.idsouk = idsouk;
            this.cin = cin;
        }

        public Espace_exposition(int id, String libelle, String photo, String description, String numTel) {
            this.id = id;
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
        }

        public Espace_exposition(String libelle, String photo, String description, String numTel, int idsouk, String cin, String categorie, double longeur, double largeur, double prix) {
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
            this.idsouk = idsouk;
            this.cin = cin;
            this.categorie = categorie;
            this.longeur = longeur;
            this.largeur = largeur;
            this.prix = prix;
        }

        public Espace_exposition(String libelle, String photo, String description, int idsouk, String cin, String categorie, double longeur, double largeur, double prix) {
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.idsouk = idsouk;
            this.cin = cin;
            this.categorie = categorie;
            this.longeur = longeur;
            this.largeur = largeur;
            this.prix = prix;
        }

        public Espace_exposition(String libelle, String photo, String description, String numTel) {
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
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

        @Override
        public String toString() {
            return "Espace_exposition{" + "id=" + id + ", libelle=" + libelle + ", photo=" + photo + ", description=" + description + ", numTel=" + numTel + ", idsouk=" + idsouk + ", cin=" + cin + ", categorie=" + categorie + ", longeur=" + longeur + ", largeur=" + largeur + ", prix=" + prix + ", etat=" + etat + '}';
        }

        public Espace_exposition(String libelle, String photo, String description, String numTel, int idsouk, String cin) {
            this.libelle = libelle;
            this.photo = photo;
            this.description = description;
            this.numTel = numTel;
            this.idsouk = idsouk;
            this.cin = cin;
        }

        public int getIdsouk() {
            return idsouk;
        }

        public String getCin() {
            return cin;
        }

        public void setIdsouk(int idsouk) {
            this.idsouk = idsouk;
        }

        public void setCin(String cin) {
            this.cin = cin;
        }

    }
    
