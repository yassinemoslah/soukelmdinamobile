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
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.entite.CoordonneesGPS;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.gui.Layout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mosla
 */
public class ServiceSouk {

    public ArrayList<Souk> getListSouks() {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ArrayList<Souk> listSouks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/getAllSouks");
        con.addResponseListener(e -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    Souk souk = new Souk();
                    float id = Float.parseFloat(obj.get("id").toString());
                    float latitude = Float.parseFloat(obj.get("latitude").toString());
                    float longitude = Float.parseFloat(obj.get("longitude").toString());
                    
                    souk.setId((int) id);
                    souk.setLibelle(obj.get("libelle").toString());
                    souk.setGouvernorat(obj.get("gouvernorat").toString());
                    souk.setPhoto(obj.get("photo").toString());
                    souk.setDescription(obj.get("description").toString());
                    CoordonneesGPS cgps = new CoordonneesGPS(latitude, longitude);
                    souk.setCoordonnees(cgps);
                    listSouks.add(souk);

                }
            } catch (IOException ex) {
            }
             ip.dispose();
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listSouks;
    }
}
