/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.soukelmdina.entite.Produit;
import com.soukelmdina.entite.Rating;
import com.soukelmdina.entite.Routes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TAOUFIK
 */
public class serviceRating {

    public serviceRating() {
    }
    
    public Rating[] getRatings(int id) {
        ArrayList<Rating> ratingslist = new ArrayList<>();
        final Rating[] bs;

        ConnectionRequest con = new ConnectionRequest();
        Routes routes = new Routes();
        con.setUrl(routes.getBaseURL()+""+routes.getEnvironnement()+""+routes.getListeRatings()+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
               // System.out.println(".actionPerformed() : "+json);
                try {

                    
                    JSONParser j = new JSONParser();

                    Map<String, Object> ratings = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) ratings.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println("id : : "+Math.round(Float.parseFloat(obj.get("id").toString())));
                        Rating rating = new Rating();
                        rating.setId( Math.round(Float.parseFloat(obj.get("id").toString())));
                        rating.setDescription(obj.get("description").toString());
                        rating.setNom(obj.get("nom").toString());
                        rating.setEtoiles( Math.round(Float.parseFloat(obj.get("etoiles").toString())));
                        
                        //
                        System.out.println("rating : " + rating.toString() + " size : " + ratingslist.size());
                        ratingslist.add(rating);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone

        bs = new Rating[ratingslist.size()];

        int iteration = 0;
        for (Rating rating : ratingslist) {
            bs[iteration] = rating;
            iteration++;
        }
        return bs;
    }
    
    public void addAvis(Produit produit,int iduser,Rating rating) {
        Routes routes = new Routes();
        String filestack = routes.getBaseURL()+routes.getEnvironnement()+routes.getAddavis();
        //system.err.println("upload "+ filestack);
        MultipartRequest request = new MultipartRequest() {
            
        };
        request.setUrl(filestack);
        request.addArgument("description", rating.getDescription());
        request.addArgument("idproduit", ""+produit.getId());
        request.addArgument("iduser", ""+iduser);
        request.addArgument("etoiles", ""+rating.getEtoiles());
        //system.err.println("URLL "+ request.getUrl());
        NetworkManager.getInstance().addToQueueAndWait(request);
}
    
}
