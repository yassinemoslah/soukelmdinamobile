/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;

/**
 *
 * @author mosla
 */
public class Profile extends Layout {
    private SpanLabel nomprenom, mail, numtel, cin, sexe, role;
    EncodedImage enc;
    URLImage uRLImage;

    public Profile() {
        nomprenom = new SpanLabel(user.getNom()+" "+user.getPrenom());
        nomprenom.setTextBlockAlign(Component.CENTER);
        mail = new SpanLabel("E-mail : "+user.getMail());
        numtel = new SpanLabel("Tél. : "+user.getNumTel());
        cin = new SpanLabel("CIN : "+user.getCin());
        sexe = new SpanLabel("Genre : "+user.getSexe());
        role = new SpanLabel("Role : "+user.getRole());
        
        enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage=URLImage.createToStorage(enc, user.getPhoto(), Layout.URL+user.getPhoto(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
        
        f.setTitle("Profile");
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.add(imgV);
        f.add(nomprenom);
        f.add(mail);
        f.add(cin);
        f.add(numtel);
        f.add(sexe);
        f.add(role);
    }
    
}
