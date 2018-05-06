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
import com.soukelmdina.entite.Categorie;
import com.soukelmdina.entite.Routes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TAOUFIK
 */
public class ServiceCategorie {
    public Categorie[] getCtegories() {
        ArrayList<Categorie> categorieslist = new ArrayList<>();
        final Categorie[] bs;

        ConnectionRequest con = new ConnectionRequest();
        Routes routes = new Routes();
        con.setUrl(routes.getBaseURL()+""+routes.getEnvironnement()+""+routes.getListeCategories());
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                System.out.println(".actionPerformed() : "+json);
                try {

                    JSONParser j = new JSONParser();

                    Map<String, Object> categories = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) categories.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println("id : : "+Math.round(Float.parseFloat(obj.get("id").toString())));
                        Categorie categorie = new Categorie();
                        categorie.setId( Math.round(Float.parseFloat(obj.get("id").toString())));
                        categorie.setLibelle(obj.get("libelle").toString());
                        
                        //
                        System.out.println("categorie : " + categorie.toString() + " size : " + categorieslist.size());
                        categorieslist.add(categorie);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone

        bs = new Categorie[categorieslist.size()];

        int iteration = 0;
        for (Categorie categorie : categorieslist) {
            bs[iteration] = categorie;
            iteration++;
        }
        return bs;
    }
}
