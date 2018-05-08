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
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.entite.Produit;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.gui.Layout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amal Mabrouk
 */
public class ServiceCafeResto {

    String reponse = "nophoto";

    public ArrayList<CafeResto> getListCafeResto() {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ArrayList<CafeResto> listCafe = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/AllCafe");
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    CafeResto cafe = new CafeResto();
                    float id = Float.parseFloat(obj.get("id").toString());
                    float accept = Float.parseFloat(obj.get("accept").toString());

                    cafe.setId((int) id);
                    cafe.setDescription(obj.get("description").toString());
                    cafe.setNumtel(obj.get("numtel").toString());
                    cafe.setPhoto(obj.get("photo").toString());
                    cafe.setLibelle(obj.get("libelle").toString());
                    cafe.setAccept((int) accept);

                    listCafe.add(cafe);

                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCafe;
    }

    public ArrayList<CafeResto> getListCafeRestoV(int user) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ArrayList<CafeResto> listCafe = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/AllCafeV/" + user);
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    CafeResto cafe = new CafeResto();
                    float id = Float.parseFloat(obj.get("id").toString());
                    float accept = Float.parseFloat(obj.get("accept").toString());

                    cafe.setId((int) id);
                    cafe.setDescription(obj.get("description").toString());
                    cafe.setNumtel(obj.get("numtel").toString());
                    cafe.setPhoto(obj.get("photo").toString());
                    cafe.setLibelle(obj.get("libelle").toString());
                    cafe.setAccept((int) accept);

                    listCafe.add(cafe);

                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCafe;
    }

    public ArrayList<CafeResto> getListCafeRestoVAtt(int user) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ArrayList<CafeResto> listCafe = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/AllCafeVA/" + user);
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    CafeResto cafe = new CafeResto();
                    float id = Float.parseFloat(obj.get("id").toString());
                    float accept = Float.parseFloat(obj.get("accept").toString());

                    cafe.setId((int) id);
                    cafe.setDescription(obj.get("description").toString());
                    cafe.setNumtel(obj.get("numtel").toString());
                    cafe.setPhoto(obj.get("photo").toString());
                    cafe.setLibelle(obj.get("libelle").toString());
                    cafe.setAccept((int) accept);

                    listCafe.add(cafe);

                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCafe;
    }

    public void AjouterCafe(CafeResto c, byte[] bytesdata) {
        ConnectionRequest con = new ConnectionRequest();
        MultipartRequest requete = new MultipartRequest();
        requete.setUrl(Layout.URL + "/server.php");
        requete.setPost(true);
        requete.addData("photo", bytesdata, "image/jpeg");
        NetworkManager.getInstance().addToQueue(requete);
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();

        requete.addResponseListener((e) -> {
            reponse = new String(requete.getResponseData());

            String Url = Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/AjouterCafe/" + c.getLibelle() + "/" + c.getDescription() + "/" + c.getNumtel() + "/" + c.getAccept() + "/" + c.getIdSouk() + "/" + c.getIdprprio() + "/" + reponse;
            con.setUrl(Url);

            NetworkManager.getInstance().addToQueueAndWait(con);

        });

        System.out.println("tt");

        con.addResponseListener(e -> {
            ip.dispose();
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
    }

    public void ModifierCafe(CafeResto c, byte[] bytesdata) {
        ConnectionRequest con = new ConnectionRequest();
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        if (!c.getPhoto().equals("nophoto")) {
            MultipartRequest requete = new MultipartRequest();
            requete.setUrl(Layout.URL + "/server.php");
            requete.setPost(true);
            requete.addData("photo", bytesdata, "image/jpeg");
            NetworkManager.getInstance().addToQueue(requete);
            requete.addResponseListener((e) -> {

                reponse = new String(requete.getResponseData());

                String Url = Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/ModifierCafe/" + c.getId() + "/" + c.getLibelle() + "/" + c.getDescription() + "/" + c.getNumtel() + "/" + c.getAccept() + "/" + c.getIdSouk() + "/" + c.getIdprprio() + "/" + reponse;
                con.setUrl(Url);
                NetworkManager.getInstance().addToQueueAndWait(con);

            });
            System.out.println("tt");

            con.addResponseListener(e -> {
                ip.dispose();
                String str = new String(con.getResponseData());
                System.out.println(str);
            });
        } else {
            String Url = Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/ModifierCafe/" + c.getId() + "/" + c.getLibelle() + "/" + c.getDescription() + "/" + c.getNumtel() + "/" + c.getAccept() + "/" + c.getIdSouk() + "/" + c.getIdprprio() + "/" + reponse;
            con.setUrl(Url);
            NetworkManager.getInstance().addToQueueAndWait(con);
            con.addResponseListener((ev) -> {
                ip.dispose();
            });

        }
    }

    public void SupprimerCafe(CafeResto c) {
        ConnectionRequest con = new ConnectionRequest();
        System.out.println("hedha id m service ya3ni url +" + c.getIdprprio());
        String Url = Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/SupprimerCafe/" + c.getId();
        con.setUrl(Url);
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        System.out.println("tt");

        con.addResponseListener(e -> {
            ip.dispose();
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<Souk> getnomssouks() {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ArrayList<Souk> listsoukes = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/souks/all");
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> espaces = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) espaces.get("root");
                for (Map<String, Object> obj : list) {
                    Souk s = new Souk();
                    //double prix = Float.parseFloat(obj.get("prix").toString());
                    float id = Float.parseFloat(obj.get("id").toString());
                    s.setId((int) id);
                    s.setLibelle(obj.get("libelle").toString());

                    listsoukes.add(s);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listsoukes.size() == 0) {
            return null;
        }
        return listsoukes;
    }

    public ArrayList<Produit> getListProduit() {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ArrayList<Produit> listCafe = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/AllCafe");
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    Produit cafe = new Produit();
                    float id = Float.parseFloat(obj.get("id").toString());
                    float quantite = Float.parseFloat(obj.get("quantite").toString());

                    cafe.setId((int) id);
                    cafe.setDescription(obj.get("description").toString());
                    cafe.setLibelle(obj.get("libelle").toString());
                    cafe.setQuantite((int) quantite);

                    listCafe.add(cafe);

                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCafe;
    }
}
