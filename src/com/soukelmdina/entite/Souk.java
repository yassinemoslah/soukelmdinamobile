
package com.soukelmdina.entite;

/**
 *
 * @author moslah yassine
 */
public class Souk {

    private int id;
    private String libelle;
    private String gouvernorat;
    private CoordonneesGPS coordonnees;
    private String photo;
    private String description;

    public Souk() {
    }

    public Souk(int id, String libelle, String gouvernorat, CoordonneesGPS coordonnees, String photo, String description) {
        this.id = id;
        this.libelle = libelle;
        this.gouvernorat = gouvernorat;
        this.coordonnees = coordonnees;
        this.photo = photo;
        this.description = description;
    }
    
     public Souk(String libelle, String gouvernorat, CoordonneesGPS coordonnees, String photo, String description) {
        this.libelle = libelle;
        this.gouvernorat = gouvernorat;
        this.coordonnees = coordonnees;
        this.photo = photo;
        this.description = description;
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

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public CoordonneesGPS getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(CoordonneesGPS coordonnees) {
        this.coordonnees = coordonnees;
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

    @Override
    public String toString() {
        return "id :"+id+"Libelle : "+libelle+", Gouvernorat : "+gouvernorat+", Coordonnées GPS : "+coordonnees.getLatitude()+", "+coordonnees.getLongitude()+", Description : "+description;
    }    
}
