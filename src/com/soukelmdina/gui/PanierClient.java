/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.entite.CommandeProduit;
import com.soukelmdina.service.ServiceCafeResto;
import java.util.ArrayList;

/**
 *
 * @author Amal Mabrouk
 */
public class PanierClient extends Layout {

    EncodedImage enc;
    URLImage uRLImage;

    public PanierClient() {

        toolbar.add(BorderLayout.CENTER, new Label("Panier"));

        Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png"));

        f.setTitle("Panier");
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));

        content.setLayout(BoxLayout.y());

        for (CommandeProduit ee : MyApplication.listeCommandep) {
            content.add(addItem(ee));
            content.add(addItem1());

        }

    }

    public Container addItem(CommandeProduit c) {
        //Label lbimage= new Label(MyApplication.theme.getImage("round.png"));

        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        System.out.println(c.getPhoto() + "taswiraaaa");
        uRLImage = URLImage.createToStorage(enc, c.getPhoto(), Layout.URL + c.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        Label prix = new Label("Prix unitaire:" + String.valueOf(c.getIdproduit()));
        Label qte = new Label("La quantité:" + String.valueOf(c.getQte()));

        // SpanLabel lblnumtel = new SpanLabel("numéro: " + c.getNumtel());
        Label ll = new Label("");
        Label lll = new Label("");
        Label llllll = new Label("");
        Label lllll = new Label("");
        Label llll = new Label("");
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        //Container cnt3 = new Container(BoxLayout.x());

        cnt2.setScrollableY(true);
        cnt1.add(prix);
        cnt1.add(qte);
        cnt1.add(llll);
       
        

        cnt2.add(imgV);

        cnt2.add(cnt1);

    //    cnt2.setLeadComponent(prix);

        return cnt2;
    }

    public Container addItem1() {
        //Label lbimage= new Label(MyApplication.theme.getImage("round.png"));
        Label lll = new Label("");
        Label llll = new Label("");

        Label ll = new Label("");
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt3 = new Container(BoxLayout.x());

        cnt1.add(ll);
        cnt1.add(llll);

        cnt1.add(lll);

        //  cnt2.add(ll);
        // cnt3.add(cnt2);
        return cnt1;
    }

}
