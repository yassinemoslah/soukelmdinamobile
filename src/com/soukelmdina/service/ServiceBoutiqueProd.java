/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.soukelmdina.entite.Boutique;
import com.soukelmdina.entite.Routes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TAOUFIK
 */
public class ServiceBoutiqueProd {
    
    public Boutique[] getboutiques() {
        //system.err.println("heeeere");
        ArrayList<Boutique> boutiqueslist = new ArrayList<>();
        final Boutique[] bs;

        ConnectionRequest con = new ConnectionRequest();
        Routes routes = new Routes();
        con.setUrl(routes.getBaseURL()+routes.getEnvironnement()+routes.getListeReduiteBoutiques());
        //system.err.println(routes.getBaseURL()+routes.getEnvironnement()+routes.getListeReduiteBoutiques()); 
       con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                System.out.println(".actionPerformed() : "+json);
                try {

                    JSONParser j = new JSONParser();

                    Map<String, Object> boutiques = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) boutiques.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println(Math.round(Float.parseFloat(obj.get("id").toString())) + " " + obj.get("libelle").toString());
                        Boutique boutique = new Boutique(Math.round(Float.parseFloat(obj.get("id").toString())), obj.get("libelle").toString(),obj.get("description").toString());
                        
                        
                        
                        
                        System.out.println("boutique : " + boutique.toString() + " size : " + boutiqueslist.size());
                        boutiqueslist.add(boutique);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone

        bs = new Boutique[boutiqueslist.size()];

        int iteration = 0;
        for (Boutique boutique : boutiqueslist) {
            bs[iteration] = boutique;
            iteration++;
        }
        return bs;
    }
}
