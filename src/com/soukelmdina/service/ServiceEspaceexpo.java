/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.gui.Layout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.soukelmdina.entite.Espace_exposition;


/**
 *
 * @author marye
 */
public class ServiceEspaceexpo {
     public ArrayList<Espace_exposition>  getespace() {
        ArrayList<Espace_exposition> listespaces = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/tasks/all");
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> espaces = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) espaces.get("root");
                    for (Map<String, Object> obj : list) {
                    Espace_exposition es = new Espace_exposition();
                    //double prix = Float.parseFloat(obj.get("prix").toString());
                    es.setLibelle(obj.get("libelle").toString());
                    es.setPhoto(obj.get("photo").toString());
                    es.setDescription(obj.get("description").toString());
                    es.setNumTel("24211538");
                    es.setIdsouk(0);
                    es.setCategorie("autre");
                    es.setCin("15000987");
                    es.setLargeur(0);
                    es.setLargeur(0);
                    es.setPrix(0);
                    es.setEtat(obj.get("etat").toString());
                                 
                                       
                        listespaces.add(es);
                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listespaces.size()==0)
            return null;
        return listespaces;
    }
}
