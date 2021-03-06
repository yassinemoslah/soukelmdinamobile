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
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Adresse;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.gui.Layout;
import com.soukelmdina.gui.Profile;
import com.soukelmdina.gui.confirmationAccount;
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
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
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
            ip.dispose();

        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listUtilisateurs.size() == 0) {
            return null;
        }
        return listUtilisateurs.get(0);
    }

    public void updateUser(String photo, String nom, String prenom, String sexe, String numtel, String adresse, String gouvernorat, String codepostal, byte[] bytesdata) {
        MyApplication.user.setNom(nom);
        MyApplication.user.setPrenom(prenom);
        MyApplication.user.setSexe(sexe);
        MyApplication.user.setNumTel(numtel);
        MyApplication.user.getAdresse().setAdresse(adresse);
        MyApplication.user.getAdresse().setVille(gouvernorat);
        MyApplication.user.getAdresse().setCodePostal(Integer.parseInt(codepostal));
        ConnectionRequest con = new ConnectionRequest();
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
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
                con.addResponseListener((ev) -> {
                    ip.dispose();
                });
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
            con.addResponseListener((ev) -> {
                ip.dispose();
            });
            try {
                MyApplication.db.execute("update user set nom='" + nom + "', prenom='" + prenom + "', sexe='" + sexe + "', numtel='" + numtel + "', adresse='" + adresse + "', ville='" + gouvernorat + "', codepostal='" + codepostal + "';");
            } catch (IOException ex) {
                System.out.println(ex);
            }
            Profile p = new Profile();
            p.getF().show();
        }

    }

    public void addUser(String email, String cin, String password, String role, String photo, String nom, String prenom, String sexe, String numtel, String adresse, String gouvernorat, String codepostal, byte[] bytesdata) {
        ConnectionRequest con = new ConnectionRequest();
        MultipartRequest requete = new MultipartRequest();
        requete.setUrl(Layout.URL + "/server.php");
        requete.setPost(true);
        requete.addData("photo", bytesdata, "image/jpeg");
        NetworkManager.getInstance().addToQueue(requete);
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();

        requete.addResponseListener((e) -> {
            reponse = new String(requete.getResponseData());
            con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/addUtilisateur/" + email + "/" + cin + "/" + password + "/" + role + "/" + reponse + "/" + nom + "/" + prenom + "/" + sexe + "/" + numtel + "/" + adresse + "/" + gouvernorat + "/" + codepostal);
            NetworkManager.getInstance().addToQueueAndWait(con);

        });

        con.addResponseListener((ev) -> {
            String rep = new String(con.getResponseData());
            System.out.println(rep);
            if (rep.equals("cin")) {
                ip.dispose();
                Dialog.show("Vérifier votre cin", "CIN existant", "OK", null);
            } else if (rep.equals("email")) {
                ip.dispose();
                Dialog.show("Vérifier votre e-mail", "E-mail existant", "OK", null);
            } else {
                ip.dispose();
                confirmationAccount p = new confirmationAccount(email);
                p.getF().show();
            }
        });
    }

    public void confirmUser(String email) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/confirmUser/" + email);
        NetworkManager.getInstance().addToQueueAndWait(con);
        con.addResponseListener((ev) -> {
            ip.dispose();
        });

    }

    public void sendKey(String email) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/sendRecupKey/" + email);
        NetworkManager.getInstance().addToQueueAndWait(con);
        con.addResponseListener((ev) -> {
            ip.dispose();
        });
    }

    public void updatePassword(String password) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/updatePassword/" + password + "/" + String.valueOf(MyApplication.user.getId()));
        NetworkManager.getInstance().addToQueueAndWait(con);
        con.addResponseListener((ev) -> {
            ip.dispose();
        });
    }

}
