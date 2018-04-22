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
import com.soukelmdina.entite.Task;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.gui.Layout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mosla
 */
public class ServiceUtilisateur {
    public Utilisateur getUser(String login, String password) {
        ArrayList<Utilisateur> listUtilisateurs = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/getUtilisateur/"+login+"/"+password);
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> utilisateurs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) utilisateurs.get("root");
                    for (Map<String, Object> obj : list) {
                        Utilisateur user = new Utilisateur();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float solde = Float.parseFloat(obj.get("solde").toString());
                        float etat = Float.parseFloat(obj.get("etat").toString());
                        user.setId((int) id);
                        user.setMail(obj.get("email").toString());
                        user.setPassword(obj.get("password").toString());
                        user.setToken(obj.get("token").toString());
                        user.setNumTel(obj.get("numtel").toString());
                        user.setNom(obj.get("nom").toString());
                        user.setPrenom(obj.get("prenom").toString());
                        user.setSexe(obj.get("sexe").toString());
                        user.setRole(obj.get("role").toString());
                        user.setCin(obj.get("cin").toString());
                        user.setPhoto(obj.get("photo").toString());
                        user.setSolde(solde);
                        user.setEtat((int) etat);
                        listUtilisateurs.add(user);
                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listUtilisateurs.size()==0)
            return null;
        return listUtilisateurs.get(0);
    }
}
