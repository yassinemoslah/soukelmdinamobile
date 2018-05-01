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
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Espace_exposition;
import com.soukelmdina.entite.Evenement;
import com.soukelmdina.service.ServiceEspaceexpo;
import com.soukelmdina.service.ServiceEvenement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class HomeEvents extends Layout {

    EncodedImage enc;
    URLImage uRLImage;

    public HomeEvents() {

        f.setTitle("Les évenements");
        f.setLayout(BoxLayout.y());
        List<Evenement> li = new ArrayList<>();
        ServiceEvenement se = new ServiceEvenement();
        li = se.getEvents();

        for (Evenement ee : li) {

            f.add(addItem(ee));
        }

    }

    public Container addItem(Evenement e) {
      enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage=URLImage.createToStorage(enc, e.getPhoto(), Layout.URL+e.getPhoto(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
        Label lbimage = new Label(MyApplication.theme.getImage("round.png"));
        Label lblib = new Label(e.getLibelle());
        //btn.addActionListener((act)->{System.out.println(e);});
        lblib.addPointerPressedListener((act) -> {
            DetailsEvents intdesc = new DetailsEvents();
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