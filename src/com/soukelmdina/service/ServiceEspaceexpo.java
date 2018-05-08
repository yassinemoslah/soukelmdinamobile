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
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.gui.Layout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.soukelmdina.entite.Espace_exposition;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.gui.Profile;
import com.soukelmdina.gui.espacevendeur;

/**
 *
 * @author marye
 */
public class ServiceEspaceexpo {

    String reponse = "nophoto";

    public ArrayList<Espace_exposition> getespace() {
        ArrayList<Espace_exposition> listespaces = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/tasks/all");
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> espaces = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) espaces.get("root");
                for (Map<String, Object> obj : list) {
                    Espace_exposition es = new Espace_exposition();
                    float id = Float.parseFloat(obj.get("id").toString());
                    String idsouk = obj.get("idsouk").toString();
                    System.err.println(idsouk);
                    String soukk = idsouk.substring(0, 7);
                    String idsoukk = soukk.substring(4, 7);
                    //String[] découpé =idsouk.split(",");
                    //System.out.println(découpé[0]);
                    double prix = Float.parseFloat(obj.get("prixdelocation").toString());

                    double longue = Float.parseFloat(obj.get("superficieLongeur").toString());
                    double larg = Float.parseFloat(obj.get("superficieLargeur").toString());

                    es.setId((int) id);
                    es.setLibelle(obj.get("libelle").toString());
                    es.setPhoto(obj.get("photo").toString());
                    String NUMtel = String.valueOf(obj.get("numtel").toString());
                    es.setNumTel(NUMtel);
                    es.setDescription(obj.get("description").toString());
                    //es.setNumTel("24211538");
                    es.setIdsouk((int) Float.parseFloat(idsoukk));
                    es.setCategorie("autre");
                    es.setCin("15000987");
                    es.setLargeur(larg);
                    es.setLongeur(longue);
                    es.setPrix(prix);
                    es.setEtat(obj.get("etat").toString());
                    System.err.println("***********" + es.getIdsouk());

                    listespaces.add(es);
                }
            } catch (IOException ex) {
            }

        });
          NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listespaces.size() == 0) {
            return null;
        }
        return listespaces;
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

    public Souk getsouk(int id) {
        ArrayList<Souk> listsouks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/soukes/" + id);
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> utilisateurs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                Souk s = new Souk();
                String idd = utilisateurs.get("id").toString();
                float idds = Float.parseFloat(idd);
                s.setId((int) idds);
                s.setLibelle(utilisateurs.get("libelle").toString());
                listsouks.add(s);

            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listsouks.size() == 0) {
            return null;
        }
        return listsouks.get(0);
    }

    public ArrayList<Espace_exposition> getespacevandeur(String cin) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ArrayList<Espace_exposition> listespaces = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/espacevendeur/" + cin);
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> espaces = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) espaces.get("root");
                for (Map<String, Object> obj : list) {
                    Espace_exposition es = new Espace_exposition();
                    float id = Float.parseFloat(obj.get("id").toString());

                    String idsouk = obj.get("idsouk").toString();
                    System.err.println(idsouk);
                    String soukk = idsouk.substring(0, 7);
                    String idsoukk = soukk.substring(4, 7);
                    //String[] découpé =idsouk.split(",");
                    //System.out.println(découpé[0]);
                    double prix = Float.parseFloat(obj.get("prixdelocation").toString());

                    double longue = Float.parseFloat(obj.get("superficieLongeur").toString());
                    double larg = Float.parseFloat(obj.get("superficieLargeur").toString());

                    es.setId((int) id);
                    es.setLibelle(obj.get("libelle").toString());
                    es.setPhoto(obj.get("photo").toString());
                    String NUMtel = String.valueOf(obj.get("numtel").toString());
                    es.setNumTel(NUMtel);
                    es.setDescription(obj.get("description").toString());
                    //es.setNumTel("24211538");
                    es.setIdsouk((int) Float.parseFloat(idsoukk));
                    es.setCategorie("autre");
                    es.setCin("15000987");
                    es.setLargeur(larg);
                    es.setLongeur(longue);
                    es.setPrix(prix);
                    es.setEtat(obj.get("etat").toString());
                    System.err.println("***********" + es.getIdsouk());

                    listespaces.add(es);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listespaces.size() == 0) {
            return null;
        }
        return listespaces;
    }

    public void supprimerespace(int idESPACE) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/supprimerespacevendeur/" + idESPACE);
        NetworkManager.getInstance().addToQueueAndWait(con);
        con.addResponseListener((e)->{
        ip.dispose();
        });
    }

    public void updateespace(String photo, String nom, String des, String numtel, double longue, double larg, double prix, int idespace, byte[] bytesdata) {
        ConnectionRequest con = new ConnectionRequest();
        if (!photo.equals("nophoto")) {
            MultipartRequest requete = new MultipartRequest();
            requete.setUrl(Layout.URL + "/server.php");
            requete.setPost(true);
            requete.addData("photo", bytesdata, "image/jpeg");
            NetworkManager.getInstance().addToQueue(requete);
            requete.addResponseListener((e) -> {
                reponse = new String(requete.getResponseData());
                con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/modespace/" + reponse + "/" + nom + "/" + des + "/" + numtel + "/" + String.valueOf(longue) + "/" + String.valueOf(larg) + "/" + String.valueOf(prix) + "/" + String.valueOf(idespace));
                NetworkManager.getInstance().addToQueueAndWait(con);
                espacevendeur p = new espacevendeur();
                p.getF().show();

            });
        } else {
            con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/modespace/" + reponse + "/" + nom + "/" + des + "/" + numtel + "/" + String.valueOf(longue) + "/" + String.valueOf(larg) + "/" + String.valueOf(prix) + "/" + String.valueOf(idespace));
            NetworkManager.getInstance().addToQueueAndWait(con);
            espacevendeur p = new espacevendeur();
            p.getF().show();
        }

    }

    public void createespace(String photo, String nom, String des, String numtel, double longue, double larg, double prix, int idsouk, String cat, byte[] bytesdata) {
        ConnectionRequest con = new ConnectionRequest();
        MultipartRequest requete = new MultipartRequest();
        System.out.println("********MARYOUMAAAAAAAA***********");
        requete.setUrl(Layout.URL + "/server.php");
        requete.setPost(true);
        requete.addData("photo", bytesdata, "image/jpeg");
        NetworkManager.getInstance().addToQueue(requete);
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        requete.addResponseListener((e) -> {
        reponse = new String(requete.getResponseData());
        System.out.println("*********AMAL*"+reponse);
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/ajespace/" + reponse + "/" + nom + "/" + des + "/" + numtel + "/" + String.valueOf(longue) + "/" + String.valueOf(larg) + "/" + String.valueOf(prix) + "/" + String.valueOf(idsouk) + "/" + MyApplication.user.getCin() + "/" + cat);
        NetworkManager.getInstance().addToQueueAndWait(con);});
        
         con.addResponseListener(e -> {
             ip.dispose();
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        espacevendeur p = new espacevendeur();
        p.getF().show(); 
        
       
        
        
        
    }

    public Espace_exposition louerespace1(int idESPACE, String date1) {
        ArrayList<Espace_exposition> listrep = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/ajoutdate/" + String.valueOf(idESPACE) + "/" + date1 + "/" + String.valueOf(MyApplication.user.getSolde() + "/" + String.valueOf(MyApplication.user.getCin())));
        System.out.println(MyApplication.user.getSolde());
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> utilisateurs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                Espace_exposition s = new Espace_exposition();

                s.setLibelle(utilisateurs.get("libelle").toString());
                listrep.add(s);

            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listrep.size() == 0) {
            return null;
        }
        return listrep.get(0);

    }

    public Espace_exposition louerespace2(int idESPACE, String date1, String date2) {
        ArrayList<Espace_exposition> listrep = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/ajoutdeuxdate/" + String.valueOf(idESPACE) + "/" + date1 + "/" + date2 + "/" + String.valueOf(MyApplication.user.getSolde() + "/" + String.valueOf(MyApplication.user.getCin())));
        System.out.println(MyApplication.user.getSolde());
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> utilisateurs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                Espace_exposition s = new Espace_exposition();

                s.setLibelle(utilisateurs.get("libelle").toString());
                listrep.add(s);

            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con); // asynchrone
        if (listrep.size() == 0) {
            return null;
        }
        return listrep.get(0);

    }

}
