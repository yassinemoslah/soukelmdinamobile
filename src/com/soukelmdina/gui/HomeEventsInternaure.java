/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Evenement;
import com.soukelmdina.service.ServiceEvenement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class HomeEventsInternaure extends Layout {
     EncodedImage enc;
    URLImage uRLImage;

    public HomeEventsInternaure() {

        toolbar.add(BorderLayout.CENTER, new Label("Modifier mon profil"));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        List<Evenement> li = new ArrayList<>();
        ServiceEvenement se = new ServiceEvenement();
        li = se.getEvents();

        for (Evenement ee : li) {

            content.add(addItem(ee));
        }
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    }

    public Container addItem(Evenement e) {
        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, e.getPhoto(), Layout.URL + e.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        Label lbimage = new Label(MyApplication.theme.getImage("round.png"));
        Label lblib = new Label(e.getLibelle());
        //btn.addActionListener((act)->{System.out.println(e);});
        lblib.addPointerPressedListener((act) -> {
            DetailEventsInternaute intdesc = new DetailEventsInternaute(e);
            intdesc.getF().show();
        });
        Container cnt1 = new Container(BoxLayout.y());

        cnt1.add(lblib);
        Container cnt2 = new Container(BoxLayout.x());
        //Container cnt2= BorderLayout.center(cnt1);
        //cnt2.add(BorderLayout.EAST, lbimage);
        cnt2.add(imgV);
        cnt2.add(cnt1);
        cnt2.setLeadComponent(lblib);
        return cnt2;
    }
}
