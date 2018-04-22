/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

/**
 *
 * @author Moslah Yassine
 */
public class Utilisateur {

    private int id;
    private String cin;
    private String mail;
    private String password;
    private String nom;
    private String prenom;
    private String dateInscription;
    private String numTel;
    private String sexe;
    private String photo;
    private double solde;
    private String role;
    private Adresse adresse;
    private String token;
    private int etat;

    public Utilisateur() {
    }

    public Utilisateur(int id, String cin, String mail, String password, String nom, String prenom, String numTel, String sexe, String photo, double solde, String role, Adresse adresse, String token, int etat) {
        this.id = id;
        this.cin = cin;
        this.mail = mail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.sexe = sexe;
        this.photo = photo;
        this.solde = solde;
        this.role = role;
        this.adresse = adresse;
        this.token = token;
        this.etat = etat;
    }

    public Utilisateur(int id,String cin, String mail, String password, String nom, String prenom, String dateInscription, String numTel, String sexe, String photo, double solde, String role, Adresse adresse, String token, int etat) {
        this.id=id;
        this.cin = cin;
        this.mail = mail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.numTel = numTel;
        this.sexe = sexe;
        this.photo = photo;
        this.solde = solde;
        this.role = role;
        this.adresse = adresse;
        this.token = token;
        this.etat = etat;
    }
    
    public Utilisateur(String cin, String mail, String password, String nom, String prenom, String dateInscription, String numTel, String sexe, String photo, double solde, String role, Adresse adresse, String token, int etat) {
        this.cin = cin;
        this.mail = mail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.numTel = numTel;
        this.sexe = sexe;
        this.photo = photo;
        this.solde = solde;
        this.role = role;
        this.adresse = adresse;
        this.token = token;
        this.etat = etat;
    }

    public Utilisateur(String cin, String mail, String password, String nom, String prenom, String numTel, String sexe, String photo, double solde, String role, Adresse adresse, String token, int etat) {
        this.cin = cin;
        this.mail = mail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.sexe = sexe;
        this.photo = photo;
        this.solde = solde;
        this.role = role;
        this.adresse = adresse;
        this.token = token;
        this.etat = etat;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "cin=" + cin + ", mail=" + mail + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", dateInscription=" + dateInscription + ", numTel=" + numTel + ", sexe=" + sexe + ", photo=" + photo + ", solde=" + solde + ", role=" + role + ", adresse=" + adresse + '}';
    }

}
