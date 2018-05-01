/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;

/**
 *
 * @author mosla
 */
public class Profile extends Layout {

    private SpanLabel nomprenom, mail, numtel, cin, sexe, role, adresse, ville, codePostal;
    private EncodedImage enc;
    private URLImage uRLImage;
    private Button btn;

    public Profile() {
        nomprenom = new SpanLabel(MyApplication.user.getNom() + " " + MyApplication.user.getPrenom());
        nomprenom.setTextBlockAlign(Component.CENTER);
        mail = new SpanLabel("E-mail : " + MyApplication.user.getMail());
        mail.setTextBlockAlign(Component.LEFT);
        numtel = new SpanLabel("Tél. : " + MyApplication.user.getNumTel());
        numtel.setTextBlockAlign(Component.LEFT);
        cin = new SpanLabel("CIN : " + MyApplication.user.getCin());
        cin.setTextBlockAlign(Component.LEFT);
        sexe = new SpanLabel("Genre : " + MyApplication.user.getSexe());
        sexe.setTextBlockAlign(Component.LEFT);
        role = new SpanLabel("Rôle : " + MyApplication.user.getRole());
        role.setTextBlockAlign(Component.LEFT);
        adresse = new SpanLabel("Adresse : " + MyApplication.user.getAdresse().getAdresse());
        adresse.setTextBlockAlign(Component.LEFT);
        ville = new SpanLabel("Gouvernorat : " + MyApplication.user.getAdresse().getVille());
        ville.setTextBlockAlign(Component.LEFT);
        codePostal = new SpanLabel("Code postal : " + MyApplication.user.getAdresse().getCodePostal());
        codePostal.setTextBlockAlign(Component.LEFT);

        btn = new Button("Modifier mon profil");

        btn.addActionListener((e) -> {
            updateProfile up = new updateProfile();
            up.getF().show();
        });

        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, MyApplication.user.getPhoto(), Layout.URL + MyApplication.user.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        toolbar.add(BorderLayout.CENTER, new Label("Profile"));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.add(imgV);
        content.add(nomprenom);
        content.add(mail);
        content.add(cin);
        content.add(numtel);
        content.add(sexe);
        content.add(role);
        content.add(adresse);
        content.add(codePostal);
        content.add(ville);
        content.add(btn);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    }

}
