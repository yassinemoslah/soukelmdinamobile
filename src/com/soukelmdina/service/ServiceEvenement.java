/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
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
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ArrayList<Evenement> listevents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/AllEvents");
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> evenements = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) evenements.get("root");
                for (Map<String, Object> obj : list) {
                    Evenement event = new Evenement();
                    float id = Float.parseFloat(obj.get("id").toString());
                   float nbreTickets = Float.parseFloat(obj.get("nbretickets").toString());
                   //double caisse = Double.parseDouble(obj.get("caisse").toString());
                    event.setId((int) id);
                    event.setLibelle(obj.get("libelle").toString());
                    event.setDescription(obj.get("description").toString());
                    //event.setDate(obj.get("date"));
                    event.setHeureDebut(obj.get("heuredebut").toString());
                    event.setHeureFin(obj.get("heurefin").toString());
                    event.setNbreTickets((int) nbreTickets);
                    event.setPrixTicket(15.0);
                    event.setCaisse(5000.0);
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
    public void updateevent(Evenement e) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ConnectionRequest con = new ConnectionRequest();
       
            con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/updateevent/" + e.getNbreTickets() + "/" + e.getCaisse() + "/" +e.getPrixTicket() + "/" + e.getId());
            NetworkManager.getInstance().addToQueueAndWait(con);
            con.addResponseListener((ev)->{
            ip.dispose();
            });
           
        }

    }
    

