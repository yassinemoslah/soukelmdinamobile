/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;



import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Mahfoudhi Dorra
 */
public class Evenement {
    

    private int id;
    private String libelle;
    private String description;
    private Date date; 
    private String HeureDebut;
    private String HeureFin;
    private int nbreTickets;
    private Double prixTicket;
    private Double caisse;
    private String lieu;
    private String photo;
    private int idsouk;

    public Evenement(int id, String libelle, String description, Date date, String HeureDebut, String HeureFin, int nbreTickets, Double prixTicket, Double caisse, String lieu, String photo, int idsouk) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.date = date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.nbreTickets = nbreTickets;
        this.prixTicket = prixTicket;
        this.caisse = caisse;
        this.lieu = lieu;
        this.photo = photo;
        this.idsouk = idsouk;
    }

    public Evenement(int id, String libelle, String description, Date date, String HeureDebut, String HeureFin, int nbreTickets, Double prixTicket, Double caisse, String lieu, int idsouk) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.date = date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.nbreTickets = nbreTickets;
        this.prixTicket = prixTicket;
        this.caisse = caisse;
        this.lieu = lieu;
        this.idsouk = idsouk;
    }

    public Evenement(String libelle, String description, String HeureDebut, String HeureFin, int nbreTickets, Double prixTicket, Double caisse, String lieu, String photo) {
        this.libelle = libelle;
        this.description = description;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.nbreTickets = nbreTickets;
        this.prixTicket = prixTicket;
        this.caisse = caisse;
        this.lieu = lieu;
        this.photo = photo;
    }

    public Evenement(String libelle, String description, Date date, String HeureDebut, String HeureFin, int nbreTickets, Double prixTicket, String lieu, String photo, int idsouk) {
        this.libelle = libelle;
        this.description = description;
        this.date = date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.nbreTickets = nbreTickets;
        this.prixTicket = prixTicket;
        this.lieu = lieu;
        this.photo = photo;
        this.idsouk = idsouk;
    }

    
    

   
    
    

    public Evenement() {
    }

    public Evenement(String libelle, String description, Date date, String HeureDebut, String HeureFin, int nbreTickets, Double prixTicket, Double caisse, String lieu, int idsouk) {
        this.libelle = libelle;
        this.description = description;
        this.date = date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.nbreTickets = nbreTickets;
        this.prixTicket = prixTicket;
        this.caisse = caisse;
        this.lieu = lieu;
        this.idsouk = idsouk;
    }

    public Evenement(String libelle, String description, Date date, String HeureDebut, String HeureFin, int nbreTickets, Double prixTicket, Double caisse, String lieu, String photo, int idsouk) {
        this.libelle = libelle;
        this.description = description;
        this.date = date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.nbreTickets = nbreTickets;
        this.prixTicket = prixTicket;
        this.caisse = caisse;
        this.lieu = lieu;
        this.photo = photo;
        this.idsouk = idsouk;
    }

    public Evenement(int id, String libelle, String description, Date date, String HeureDebut, String HeureFin, int nbreTickets, Double prixTicket, Double caisse, String lieu, String photo) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.date = date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.nbreTickets = nbreTickets;
        this.prixTicket = prixTicket;
        this.caisse = caisse;
        this.lieu = lieu;
        this.photo = photo;
    }

    public Evenement(String libelle, String description, Date date, String HeureDebut, String HeureFin, int nbreTickets, Double prixTicket, Double caisse, String lieu, String photo) {
        this.libelle = libelle;
        this.description = description;
        this.date = date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.nbreTickets = nbreTickets;
        this.prixTicket = prixTicket;
        this.caisse = caisse;
        this.lieu = lieu;
        this.photo = photo;
    }

    public Evenement(String text, String text0, Date sqlDate, String text1, String text2, int parseInt, double parseDouble, String text3,int id, String text4) {
         this.libelle = text;
        this.description = text0;
        this.date = sqlDate;
        this.HeureDebut = text1;
        this.HeureFin = text2;
        this.nbreTickets = parseInt;
        this.prixTicket = parseDouble;
        this.lieu = text3;
        this.photo = text4;
        this.id=id;
    }

    
    

   
        

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getHeureDebut() {
        return HeureDebut;
    }

    public String getHeureFin() {
        return HeureFin;
    }

    public Double getPrixTicket() {
        return prixTicket;
    }

    

    public int getNbreTickets() {
        return nbreTickets;
    }

    public Double getCaisse() {
        return caisse;
    }

    public String getLieu() {
        return lieu;
    }

    public String getPhoto() {
        return photo;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeureDebut(String HeureDebut) {
        this.HeureDebut = HeureDebut;
    }

    public void setHeureFin(String HeureFin) {
        this.HeureFin = HeureFin;
    }

    public void setPrixTicket(Double prixTicket) {
        this.prixTicket = prixTicket;
    }

    

    public void setNbreTickets(int nbreTickets) {
        this.nbreTickets = nbreTickets;
    }

    public void setCaisse(Double caisse) {
        this.caisse = caisse;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", libelle=" + libelle + ", description=" + description + ", date=" + date + ", HeureDebut=" + HeureDebut + ", HeureFin=" + HeureFin + ", nbreTickets=" + nbreTickets + ", prixTicket=" + prixTicket + ", caisse=" + caisse + ", lieu=" + lieu + ", photo=" + photo + ", idsouk=" + idsouk + '}';
    }

    

    public int getIdsouk() {
        return idsouk;
    }

    public void setIdsouk(int idsouk) {
        this.idsouk = idsouk;
    }

   

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
