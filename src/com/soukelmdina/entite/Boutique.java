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
public class Boutique {
    private int id;
    private String nomBoutique;
    private String descriptionBoutique;

    public Boutique() {
    }
    
    

    public Boutique(int id, String nomBoutique, String descriptionBoutique) {
        this.id = id;
        this.nomBoutique = nomBoutique;
        this.descriptionBoutique = descriptionBoutique;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomBoutique() {
        return nomBoutique;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    public String getDescriptionBoutique() {
        return descriptionBoutique;
    }

    public void setDescriptionBoutique(String descriptionBoutique) {
        this.descriptionBoutique = descriptionBoutique;
    }

    
    
    @Override
    public String toString() {
        return "Boutique{" + "id=" + id + ", nomBoutique=" + nomBoutique + ", descriptionBoutique=" + descriptionBoutique +'}';
    }
}
