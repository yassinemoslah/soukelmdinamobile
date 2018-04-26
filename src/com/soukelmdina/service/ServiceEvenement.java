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
import com.soukelmdina.entite.Evenement;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.gui.Layout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class ServiceEvenement {

    public ArrayList<Evenement>  getEvents() {
        ArrayList<Evenement> listevents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/AllEvents");
        con.addResponseListener(e -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> evenements = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) evenements.get("root");
                for (Map<String, Object> obj : list) {
                    Evenement event = new Evenement();
                    float id = Float.parseFloat(obj.get("id").toString());
                    float nbreTickets = Float.parseFloat(obj.get("nbreTickets").toString());
                    double prixTicket = Double.parseDouble(obj.get("prixTicket").toString());
                    double caisse = Double.parseDouble(obj.get("caisse").toString());
                    event.setId((int) id);
                    event.setLibelle(obj.get("libelle").toString());
                    event.setDescription(obj.get("description").toString());
                    //event.setDate(obj.get("date"));
                    event.setHeureDebut(obj.get("HeureDebut").toString());
                    event.setHeureFin(obj.get("HeureFin").toString());
                    event.setNbreTickets((int) nbreTickets);
                    event.setPrixTicket(prixTicket);
                    event.setCaisse(caisse);
                    event.setLieu(obj.get("lieu").toString());
                    event.setPhoto(obj.get("photo").toString());
                    listevents.add(event);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listevents.size() == 0) {
            return null;
        }
        return listevents;
    }
}
