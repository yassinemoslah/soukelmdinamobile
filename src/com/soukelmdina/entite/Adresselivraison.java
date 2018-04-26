
package com.soukelmdina.entite;
public class Adresselivraison {
    
private int idCommande; 
private String adresse; 
private int codePostal; 
private String ville;

    public Adresselivraison(int idCommande, String adresse, int codePostal, String ville) {
        this.idCommande = idCommande;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Adresselivraison(String adresse, int codePostal, String ville) {
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Adresselivraison() {
    }

    public int getIdCommande() {
        return idCommande;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresselivraison{" + "idCommande=" + idCommande + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + '}';
    }

    
    
    
}
