/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.entite;

import java.util.Date;



/**
 *
 * @author lina9
 */
public class abonnement {
    
    int id;
    int idB;
    int idU;
    Date date;

    public abonnement(int id, int idB, int idU, Date date) {
        this.id = id;
        this.idB = idB;
        this.idU = idU;
        this.date = date;
    }

    @Override
    public String toString() {
        return "abonnement{" + "id=" + id + ", idB=" + idB + ", idU=" + idU + ", date=" + date + '}';
    }

    public abonnement() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
