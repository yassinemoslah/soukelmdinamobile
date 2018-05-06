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
import com.codename1.util.Callback;
import com.soukelmdina.entite.Boutique;
import com.soukelmdina.entite.Categorie;
import com.soukelmdina.entite.Produit;
import com.soukelmdina.entite.Routes;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TAOUFIK
 */
public class serviceProduit {

    public serviceProduit() {
    }

    public Produit[] getProduits() {
        ArrayList<Produit> produitslist = new ArrayList<>();
        final Produit[] bs;

        Routes routes = new Routes();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(routes.getBaseURL()+routes.getEnvironnement()+routes.getListeProduits());
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                try {

                    JSONParser j = new JSONParser();

                    Map<String, Object> produits = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println("id : : "+Math.round(Float.parseFloat(obj.get("id").toString())));
                        Produit produit = new Produit();
                        produit.setId( Math.round(Float.parseFloat(obj.get("id").toString())));
                        produit.setLibelle(obj.get("libelle").toString());
                        produit.setPhoto(obj.get("photo").toString());
                        produit.setDescription(obj.get("description").toString());
                        produit.setPrix(Float.parseFloat(obj.get("prix").toString()));
                        
                        //
                        System.out.println("produit : " + produit.toString() + " size : " + produitslist.size());
                        produitslist.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone

        bs = new Produit[produitslist.size()];

        int i = 0;
        for (Produit produit : produitslist) {
            bs[i] = produit;
            i++;
        }
        return bs;
    }
    
    public Produit getProduitById(int id) {
        ArrayList<Produit> produitslist = new ArrayList<>();
        final Produit[] bs;

        Routes routes = new Routes();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(routes.getBaseURL()+routes.getEnvironnement()+routes.getProduitById()+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                //System.out.println(".actionPerformed() : "+json);
                try {

                    JSONParser j = new JSONParser();

                    Map<String, Object> produits = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println("id : : "+Math.round(Float.parseFloat(obj.get("id").toString())));
                        Produit produit = new Produit();
                        produit.setId( Math.round(Float.parseFloat(obj.get("id").toString())));
                        produit.setLibelle(obj.get("libelle").toString());
                        produit.setPhoto(obj.get("photo").toString());
                        produit.setDescription(obj.get("description").toString());
                        produit.setPrix(Float.parseFloat(obj.get("prix").toString()));
                        produit.setQuantite(Math.round(Float.parseFloat(obj.get("quantite").toString())));
                        produit.setIdboutique(Math.round(Float.parseFloat(obj.get("idboutique").toString())));
                        produit.setIdcategorie(Math.round(Float.parseFloat(obj.get("idcategorie").toString())));
                        Categorie categorie = new Categorie();
                        categorie.setId(Math.round(Float.parseFloat(obj.get("idcategorie").toString())));
                        categorie.setLibelle(obj.get("libellecateg").toString());
                        produit.setCategorie(categorie);
                        
                        //
                        System.out.println("produit : " + produit.toString() + " size : " + produitslist.size());
                        produitslist.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone


        Produit p = new Produit();
        for (Produit produit : produitslist) {
            p = produit;
        }
        return p;
    }
    
    public Produit[] getProduitsBoutique(Boutique boutique) {
        ArrayList<Produit> produitslist = new ArrayList<>();
        final Produit[] bs;

        ConnectionRequest con = new ConnectionRequest();
        Routes routes = new Routes();
        con.setUrl(routes.getBaseURL()+routes.getEnvironnement()+routes.getListeProduitsByBoutique()+boutique.getId());
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                System.out.println(".actionPerformed() : "+json);
                try {

                    JSONParser j = new JSONParser();

                    Map<String, Object> produits = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println("id : : "+Math.round(Float.parseFloat(obj.get("id").toString())));
                        Produit produit = new Produit();
                        produit.setId( Math.round(Float.parseFloat(obj.get("id").toString())));
                        produit.setLibelle(obj.get("libelle").toString());
                        produit.setPhoto(obj.get("photo").toString());
                        produit.setDescription(obj.get("description").toString());
                        produit.setPrix(Float.parseFloat(obj.get("prix").toString()));
                        produit.setQuantite(Math.round(Float.parseFloat(obj.get("quantite").toString())));
                        produit.setIdboutique(Math.round(Float.parseFloat(obj.get("idboutique").toString())));
                        produit.setIdcategorie(Math.round(Float.parseFloat(obj.get("idcategorie").toString())));
                        Categorie categorie = new Categorie();
                        categorie.setId(Math.round(Float.parseFloat(obj.get("idcategorie").toString())));
                        categorie.setLibelle(obj.get("libellecateg").toString());
                        produit.setCategorie(categorie);
                        
                        //
                        System.out.println("produit : " + produit.toString() + " size : " + produitslist.size());
                        produitslist.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone

        bs = new Produit[produitslist.size()];

        int iteration = 0;
        for (Produit produit : produitslist) {
            bs[iteration] = produit;
            iteration++;
        }
        return bs;
    }
    
    public void ajouterProduit(String picture, Produit produit) {
    if(picture!=null){
        try {
            Routes routes = new Routes();
            String filestack = routes.getBaseURL()+routes.getEnvironnement()+routes.getNewProduit();
            
            MultipartRequest request = new MultipartRequest() {
                
            };
            request.setUrl(filestack);
            request.addData("fileUpload", picture, "image/jpeg");
            request.addArgument("libelle", produit.getLibelle());
            request.addArgument("description", produit.getDescription());
            request.addArgument("quantite", ""+produit.getQuantite());
            request.addArgument("prix", ""+produit.getPrix());
            request.addArgument("idboutique", ""+produit.getIdboutique());
            request.addArgument("idcategorie", ""+produit.getIdcategorie());
            request.setFilename("fileUpload", "image.jpg");
            //system.err.println("URLL "+ request.getUrl());
            NetworkManager.getInstance().addToQueueAndWait(request);
        } catch (IOException ex) {
            //system.err.println(ex);
        }
    }
}
    
    public void modifierProduit(String picture, Produit produit, String changedphoto) {
            Routes routes = new Routes();
            String filestack = routes.getBaseURL()+routes.getEnvironnement()+routes.getUpdateProduit();
            //system.err.println("upload "+ filestack);
            MultipartRequest request = new MultipartRequest() {
                
            };
            request.setUrl(filestack);
            request.addArgument("id", ""+produit.getId());
            request.addArgument("libelle", produit.getLibelle());
            request.addArgument("description", produit.getDescription());
            request.addArgument("quantite", ""+produit.getQuantite());
            request.addArgument("prix", ""+produit.getPrix());
            request.addArgument("idboutique", ""+produit.getIdboutique());
            request.addArgument("idcategorie", ""+produit.getIdcategorie());
            request.setFilename("fileUpload", "image.jpg");
            request.addArgument("changedphoto", changedphoto);
        try {
            request.addData("fileUpload", picture, "image/jpeg");
        } catch (IOException ex) {
            
        }
            //system.err.println("URLL "+ request.getUrl());
            NetworkManager.getInstance().addToQueueAndWait(request);
    }
    
    public void changephotoproduitSend(String picture, Produit produit) {
    if(picture!=null){
        try {
            Routes routes = new Routes();
            String filestack = routes.getBaseURL()+routes.getEnvironnement()+routes.getUpdatePhotoProduit();
            //system.err.println("upload "+ filestack);
            MultipartRequest request = new MultipartRequest() {
                protected void readResponse(InputStream input) throws IOException  {
                    final Callback<String> resultURL = null;
                JSONParser jp = new JSONParser();
              Map<String, Object> result = jp.parseJSON(new InputStreamReader(input, "UTF-8"));
              String id = (String)result.get("id");
                    System.out.println(".readResponse() iddd "+id);
            }
            };
            request.setUrl(filestack);
            request.addData("fileUpload", picture, "image/jpeg");
            request.addArgument("id", ""+produit.getId());
            request.setFilename("fileUpload", "image.jpg");
            //system.err.println("URLL "+ request.getUrl());
            NetworkManager.getInstance().addToQueueAndWait(request);
        } catch (IOException ex) {
            //system.err.println(ex);
        }
    }
}
    
    public Produit[] getProduitsVendeur(int user) {
        ArrayList<Produit> produitslist = new ArrayList<>();
        final Produit[] bs;

        ConnectionRequest con = new ConnectionRequest();
        Routes routes = new Routes();
        con.setUrl(routes.getBaseURL()+routes.getEnvironnement()+routes.getListeProduitsByBoutique()+user);
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                System.out.println(".actionPerformed() : "+json);
                try {

                    JSONParser j = new JSONParser();

                    Map<String, Object> produits = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println("id : : "+Math.round(Float.parseFloat(obj.get("id").toString())));
                        Produit produit = new Produit();
                        produit.setId( Math.round(Float.parseFloat(obj.get("id").toString())));
                        
                        //
                        System.out.println("produit : " + produit.toString() + " size : " + produitslist.size());
                        produitslist.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone

        bs = new Produit[produitslist.size()];

        int iteration = 0;
        for (Produit produit : produitslist) {
            bs[iteration] = produit;
            iteration++;
        }
        return bs;
    }
    
    //dernier product 
    public Produit dernierProduct() {
        ArrayList<Produit> produitslist = new ArrayList<>();
        final Produit[] bs;

        Routes routes = new Routes();
        ConnectionRequest con = new ConnectionRequest();
        System.out.println(routes.getBaseURL()+routes.getEnvironnement()+routes.getDernierProduct());
        con.setUrl(routes.getBaseURL()+routes.getEnvironnement()+routes.getDernierProduct());
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                try {

                    JSONParser j = new JSONParser();

                    Map<String, Object> produits = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println("id : : "+Math.round(Float.parseFloat(obj.get("id").toString())));
                        Produit produit = new Produit();
                        produit.setId( Math.round(Float.parseFloat(obj.get("id").toString())));
                        produit.setLibelle(obj.get("libelle").toString());
                        produit.setPhoto(obj.get("photo").toString());
                        produit.setDescription(obj.get("description").toString());
                        produit.setPrix(Float.parseFloat(obj.get("prix").toString()));
                        
                        //
                        System.out.println("produit : " + produit.toString() + " size : " + produitslist.size());
                        produitslist.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone


        Produit p = new Produit();
        for (Produit produit : produitslist) {
            p = produit;
        }
        return p;
    }
}
