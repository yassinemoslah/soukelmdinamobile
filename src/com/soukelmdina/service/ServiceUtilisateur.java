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
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Adresse;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.gui.Layout;
import com.soukelmdina.gui.Profile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author mosla
 */
public class ServiceUtilisateur {

    String reponse = "nophoto";

    public Utilisateur getUser(String login, String password) {
        ArrayList<Utilisateur> listUtilisateurs = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/getUtilisateur/" + login + "/" + password);
        con.addResponseListener(e -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> utilisateurs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) utilisateurs.get("root");
                for (Map<String, Object> obj : list) {
                    Utilisateur user = new Utilisateur();
                    Adresse adresse = new Adresse();

                    float codepostal = Float.parseFloat(obj.get("codepostal").toString());
                    adresse.setCodePostal((int) codepostal);
                    adresse.setAdresse(obj.get("adresse").toString());
                    adresse.setVille(obj.get("ville").toString());

                    float id = Float.parseFloat(obj.get("id").toString());
                    float solde = Float.parseFloat(obj.get("solde").toString());
                    float etat = Float.parseFloat(obj.get("etat").toString());
                    user.setAdresse(adresse);
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
        if (listUtilisateurs.size() == 0) {
            return null;
        }
        return listUtilisateurs.get(0);
    }

    public void updateUser(String photo, String nom, String prenom, String sexe, String numtel, String adresse, String gouvernorat, String codepostal, byte[] bytesdata) {
        ConnectionRequest con = new ConnectionRequest();
        if (!photo.equals("nophoto")) {
            MultipartRequest requete = new MultipartRequest();
            requete.setUrl(Layout.URL + "/server.php");
            requete.setPost(true);
            requete.addData("photo", bytesdata, "image/jpeg");
            NetworkManager.getInstance().addToQueue(requete);
            requete.addResponseListener((e) -> {
                reponse = new String(requete.getResponseData());
                con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/updateUtilisateur/" + reponse + "/" + nom + "/" + prenom + "/" + sexe + "/" + numtel + "/" + adresse + "/" + gouvernorat + "/" + codepostal + "/" + String.valueOf(MyApplication.user.getId()));
                NetworkManager.getInstance().addToQueueAndWait(con);
                try {
                    MyApplication.db.execute("update user set photo='/soukelmdina/assets/img/mobile/" + reponse + "', nom='" + nom + "', prenom='" + prenom + "', sexe='" + sexe + "', numtel='" + numtel + "', adresse='" + adresse + "', ville='" + gouvernorat + "', codepostal='" + codepostal + "';");
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                MyApplication.user.setPhoto("/soukelmdina/assets/img/mobile/" + reponse);
                Profile p = new Profile();
                p.getF().show();

            });
        } else {
            con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/updateUtilisateur/" + reponse + "/" + nom + "/" + prenom + "/" + sexe + "/" + numtel + "/" + adresse + "/" + gouvernorat + "/" + codepostal + "/" + String.valueOf(MyApplication.user.getId()));
            NetworkManager.getInstance().addToQueueAndWait(con);
            try {
                MyApplication.db.execute("update user set nom='" + nom + "', prenom='" + prenom + "', sexe='" + sexe + "', numtel='" + numtel + "', adresse='" + adresse + "', ville='" + gouvernorat + "', codepostal='" + codepostal + "';");
            } catch (IOException ex) {
                System.out.println(ex);
            }
            Profile p = new Profile();
            p.getF().show();
        }

        MyApplication.user.setNom(nom);
        MyApplication.user.setPrenom(prenom);
        MyApplication.user.setSexe(sexe);
        MyApplication.user.setNumTel(numtel);
        MyApplication.user.getAdresse().setAdresse(adresse);
        MyApplication.user.getAdresse().setVille(gouvernorat);
        MyApplication.user.getAdresse().setCodePostal(Integer.parseInt(codepostal));

    }
}
