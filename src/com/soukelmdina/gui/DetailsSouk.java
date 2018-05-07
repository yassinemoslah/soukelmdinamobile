/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Souk;
import java.util.ArrayList;

/**
 *
 * @author mosla
 */
public class DetailsSouk extends Layout {

    private SpanLabel description, gouvernorat;
    private Label libelle;
    EncodedImage enc;
    URLImage uRLImage;

    public DetailsSouk() {
    }

    public DetailsSouk(Souk s, ArrayList<Souk> listeSouks) {
        toolbar.add(BorderLayout.CENTER, new Label("Détails du Souk"));
        Label back = new Label("Retour");
        toolbar.add(BorderLayout.EAST, back);
        back.addPointerPressedListener((e)->{
            ListeSouks liste = new ListeSouks(listeSouks);
            liste.getF().show();
        });
        
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("250x250.png"), false);
        uRLImage = URLImage.createToStorage(enc, s.getPhoto(), Layout.URL + s.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        libelle = new Label(s.getLibelle());
        libelle.setUIID("PinkLabel");
        description = new SpanLabel(s.getDescription());
        gouvernorat = new SpanLabel(s.getGouvernorat());
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.add(new Label(" "));
        f.add(imgV);
        f.add(libelle);
        f.add(gouvernorat);
        f.add(description);
    }

}
