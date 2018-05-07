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
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
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

    private SpanLabel mail, numtel, cin, sexe, role, adresse, ville, codePostal;
    private Label nomprenom;
    private EncodedImage enc;
    private URLImage uRLImage;
    private Button btn, btn1;

    public Profile() {
        nomprenom = new Label(MyApplication.user.getNom() + " " + MyApplication.user.getPrenom());
        nomprenom.setUIID("PinkLabel");
        mail = new SpanLabel(MyApplication.user.getMail());
        mail.setTextBlockAlign(Component.CENTER);

        numtel = new SpanLabel(MyApplication.user.getNumTel());
        numtel.setIcon(MyApplication.theme.getImage("phone.png"));
        cin = new SpanLabel(MyApplication.user.getCin());
        cin.setIcon(MyApplication.theme.getImage("cin.png"));
        cin.setTextBlockAlign(Component.RIGHT);
        Container cnt1 = new Container(new BorderLayout());
        cnt1.add(BorderLayout.EAST, cin);
        cnt1.add(BorderLayout.WEST, numtel);

        sexe = new SpanLabel(MyApplication.user.getSexe());
        sexe.setIcon(MyApplication.theme.getImage("genre.png"));
        role = new SpanLabel(MyApplication.user.getRole());
        role.setIcon(MyApplication.theme.getImage("role.png"));

        Container cnt2 = new Container(new BorderLayout());
        cnt2.add(BorderLayout.EAST, sexe);
        cnt2.add(BorderLayout.WEST, role);

        adresse = new SpanLabel(MyApplication.user.getAdresse().getAdresse() + ", " + MyApplication.user.getAdresse().getVille() + ", " + MyApplication.user.getAdresse().getCodePostal());
        adresse.setIcon(MyApplication.theme.getImage("marker.png"));

        btn = new Button("Modifier mon profile");
        btn1 = new Button("Modifier mon mot de passe");

        btn.addActionListener((e) -> {
            updateProfile up = new updateProfile();
            up.getF().show();
        });

        btn1.addActionListener((e) -> {
            updatePassword upwd = new updatePassword();
            upwd.getF().show();
        });
Image screenshot = Image.createImage(150,150);
        enc = EncodedImage.createFromImage(screenshot, false);
        uRLImage = URLImage.createToStorage(enc, MyApplication.user.getPhoto(), Layout.URL + MyApplication.user.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);

        toolbar.add(BorderLayout.CENTER, new Label("Profile"));
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.add(new Label(" "));
        f.add(imgV);
        f.add(nomprenom);
        f.add(mail);
        f.add(new Label(" "));
        f.add(cnt1);
        f.add(new Label(" "));
        f.add(cnt2);
        f.add(new Label(" "));
        f.add(adresse);
        f.add(new Label(" "));
        f.add(btn);
        f.add(btn1);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    }

}
