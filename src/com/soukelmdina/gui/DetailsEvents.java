/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Evenement;
import com.soukelmdina.service.Example;
import com.soukelmdina.service.ServiceEvenement;
import com.soukelmdina.service.ServiceUtilisateur;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class DetailsEvents extends Layout {

    private SpanLabel des, emplacement, s;
    EncodedImage enc;
    URLImage uRLImage;
    Button btn;

    public DetailsEvents(Evenement e) {
        ServiceEvenement se = new ServiceEvenement();
        ArrayList<Evenement> le = new ArrayList<>();
        le = se.getEvents();
        toolbar.add(BorderLayout.CENTER, new Label("Modifier mon profil"));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        des = new SpanLabel();
        emplacement = new SpanLabel(e.getLibelle());
        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, e.getPhoto(), Layout.URL + e.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.add(imgV);
        content.add(e.getDescription());
        // content.add("Date " + e.getDate() );
        content.add("De :" + e.getHeureDebut());
        content.add("De :" + e.getHeureFin());
        content.add("Nombre de tickets disponibles : " + e.getNbreTickets());
        content.add("Prix ticket :" + e.getPrixTicket());
        content.add("Lieu :" + e.getLieu());
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        btn = new Button("Réserver Tickets");
        content.add(btn);
        btn.addActionListener(z -> {
            ServiceEvenement es = new ServiceEvenement();
            System.out.println(e);
            if (e.getNbreTickets() == 0) {
                Dialog.show("Sold OUT", "Plus de tickets", "ok", "cancel");
                ;

            } else {
                e.setNbreTickets(e.getNbreTickets() - 1);
                e.setCaisse(e.getCaisse() + e.getPrixTicket());
                System.out.println(e);
                es.updateevent(e);
                Dialog.show("Confirmation ticket", "Votre ticket a été réservé vous recevrez un sms de confirmation", "ok", "cancel");

                HomeEvents hm = new HomeEvents();
                hm.getF().show();
<<<<<<< HEAD
                //SmsSender ss = new SmsSender();
                Example ex = new Example();
=======
>>>>>>> 5888cd07c0efc721124cb76856678b8d8f3b9086
                
            }

        }
        );
    }

}
