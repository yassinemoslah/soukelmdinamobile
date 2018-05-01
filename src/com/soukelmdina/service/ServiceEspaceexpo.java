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
import com.soukelmdina.entite.Souk;


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
                    float id = Float.parseFloat(obj.get("id").toString());
                    String idsouk =obj.get("idsouk").toString();
                    System.err.println(idsouk);
                    String soukk=idsouk.substring(0, 7);
                    String idsoukk=soukk.substring(4, 7);
                   //String[] découpé =idsouk.split(",");
                    //System.out.println(découpé[0]);
                    double prix = Float.parseFloat(obj.get("prixdelocation").toString());
                    
                    double longue = Float.parseFloat(obj.get("superficieLongeur").toString());
                    double larg = Float.parseFloat(obj.get("superficieLargeur").toString());
                    
                    es.setId((int) id);
                    es.setLibelle(obj.get("libelle").toString());
                    es.setPhoto(obj.get("photo").toString());
                    String NUMtel=String.valueOf(obj.get("numtel").toString());
                    es.setNumTel(NUMtel);
                    es.setDescription(obj.get("description").toString());
                    //es.setNumTel("24211538");
                    es.setIdsouk((int)Float.parseFloat(idsoukk));
                    es.setCategorie("autre");
                    es.setCin("15000987");
                    es.setLargeur(larg);
                    es.setLongeur(longue);
                    es.setPrix(prix);
                    es.setEtat(obj.get("etat").toString());
                        System.err.println("***********"+es.getIdsouk());
                                 
                                       
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
     
      public ArrayList<Souk>  getnomssouks() {
        ArrayList<Souk> listsoukes = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/souks/all");
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> espaces = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) espaces.get("root");
                    for (Map<String, Object> obj : list) {
                    Souk s = new Souk();
                    //double prix = Float.parseFloat(obj.get("prix").toString());
                    float id = Float.parseFloat(obj.get("id").toString());
                    s.setId((int)id);
                    s.setLibelle(obj.get("libelle").toString());
                    
                                 
                                       
                        listsoukes.add(s);
                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listsoukes.size()==0)
            return null;
        return listsoukes;
    }
     
    public Souk  getsouk(int id) {
         ArrayList<Souk> listsouks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/souk/"+id);
      con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
    Map<String, Object> utilisateurs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
     Souk s = new Souk();
     String idd=utilisateurs.get("id").toString();
     float idds = Float.parseFloat(idd);
     s.setId((int)idds);
     s.setLibelle(utilisateurs.get("libelle").toString());
    listsouks.add(s);
                    
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listsouks.size()==0)
            return null;
        return listsouks.get(0);
    }
     
     
  public ArrayList<Espace_exposition>  getespacevandeur(String cin) {
        ArrayList<Espace_exposition> listespaces = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/espacevendeur/"+cin);
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> espaces = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) espaces.get("root");
                    for (Map<String, Object> obj : list) {
                    Espace_exposition es = new Espace_exposition();
                    float id = Float.parseFloat(obj.get("id").toString());
                    String idsouk =obj.get("idsouk").toString();
                    System.err.println(idsouk);
                    String soukk=idsouk.substring(0, 7);
                    String idsoukk=soukk.substring(4, 7);
                   //String[] découpé =idsouk.split(",");
                    //System.out.println(découpé[0]);
                    double prix = Float.parseFloat(obj.get("prixdelocation").toString());
                    
                    double longue = Float.parseFloat(obj.get("superficieLongeur").toString());
                    double larg = Float.parseFloat(obj.get("superficieLargeur").toString());
                    
                    es.setId((int) id);
                    es.setLibelle(obj.get("libelle").toString());
                    es.setPhoto(obj.get("photo").toString());
                    String NUMtel=String.valueOf(obj.get("numtel").toString());
                    es.setNumTel(NUMtel);
                    es.setDescription(obj.get("description").toString());
                    //es.setNumTel("24211538");
                    es.setIdsouk((int)Float.parseFloat(idsoukk));
                    es.setCategorie("autre");
                    es.setCin("15000987");
                    es.setLargeur(larg);
                    es.setLongeur(longue);
                    es.setPrix(prix);
                    es.setEtat(obj.get("etat").toString());
                    System.err.println("***********"+es.getIdsouk());
                                 
                                       
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
