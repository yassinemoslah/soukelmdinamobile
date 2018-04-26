/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

/**
 *
 * @author Amal Mabrouk
 */
public class msg {
    int id ;
    String nom;
    String num;

    public msg() {
    }

    public msg(int id, String nom,String num) {
        this.id = id;
        this.nom = nom;
        this.num=num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
