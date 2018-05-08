/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.entite.Commande;
import com.soukelmdina.gui.Layout;

/**
 *
 * @author Amal Mabrouk
 */
public class ServiceCommande {

    public void ajoutCommande(Commande c) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ConnectionRequest con = new ConnectionRequest();
        String Url = Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/ajoutCommande/" + MyApplication.user.getId() + "/" + c.getTotalPrix();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener(e -> {
            ip.dispose();
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println("tt1");

    }

    public void ModifierQte(int qte, int id) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ConnectionRequest con = new ConnectionRequest();
        String Url = Layout.URL + "/soukelmdinaweb/web/app_dev.php/app/ModifierQte/" + id + "/" + qte;
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener(e -> {
            ip.dispose();
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println("tt1");

    }

}
