/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.service.ServiceCafeResto;
import com.soukelmdina.service.ServiceSouk;
import java.util.ArrayList;

/**
 *
 * @author mosla
 */
public class ListeSouks extends Layout {

    EncodedImage enc;
    URLImage uRLImage;
    ArrayList<Souk> listeSouks;
    
    public ListeSouks() {
        toolbar.add(BorderLayout.CENTER, new Label("Liste des Souks"));

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));

        content.setLayout(BoxLayout.y());

        ServiceSouk ss = new ServiceSouk();
        listeSouks = ss.getListSouks();

        for (Souk ee : listeSouks) {
            content.add(addItem(ee, listeSouks));
            content.add(addItem1());

        }
    }
    
    public ListeSouks(ArrayList<Souk> listeSouk) {
        toolbar.add(BorderLayout.CENTER, new Label("Liste des Souks"));

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));

        content.setLayout(BoxLayout.y());


        for (Souk ee : listeSouk) {
            content.add(addItem(ee, listeSouk));
            content.add(addItem1());

        }
    }

    public Container addItem(Souk s, ArrayList<Souk> list ) {

        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, s.getPhoto(), Layout.URL + s.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        SpanLabel lbtexte = new SpanLabel(String.valueOf(s.getId()));
        Label libelle = new Label(s.getLibelle());

        libelle.addPointerPressedListener((act) -> {
            DetailsSouk ds = new DetailsSouk(s,  list);
            ds.getF().show();
        });
        Label ll = new Label("");
        Label lll = new Label("");
        Label llllll = new Label("");
        Label lllll = new Label("");
        Label llll = new Label("");
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        cnt1.add(ll);
        cnt1.add(lll);
        cnt1.add(llll);
        cnt1.add(lllll);
        cnt1.add(llllll);

        cnt1.add(libelle);
        cnt2.add(imgV);
        cnt2.add(cnt1);

        cnt2.setLeadComponent(libelle);

        return cnt2;
    }

    public Container addItem1() {
        Label lll = new Label("");
        Label llll = new Label("");
        Label ll = new Label("");
        Container cnt1 = new Container(BoxLayout.y());
        cnt1.add(ll);
        cnt1.add(llll);
        cnt1.add(lll);
        return cnt1;
    }

}
