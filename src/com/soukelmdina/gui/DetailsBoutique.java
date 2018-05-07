/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique1;
import com.soukelmdina.service.ServiceBoutique;

/**
 *
 * @author lina9
 */
public class DetailsBoutique extends Layout{

    private SpanLabel des, emplacement, emplacement2;
    Button b ;
    EncodedImage enc;
    
    URLImage uRLImage;
    private Resources theme;

    public DetailsBoutique(Boutique1 e) {
        ServiceBoutique ses = new ServiceBoutique();
        String l = ses.findSoukById(e.getId());
        String d = ses.findSoukById2(e.getId());
        f.setTitle(e.getLibelle());
        System.out.println(l);
        des = new SpanLabel(e.getDescription());
        emplacement = new SpanLabel(l);
        emplacement2 = new SpanLabel(d);
        Style ss = UIManager.getInstance().getComponentStyle("MultiLine1");
    FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, ss);
        enc = EncodedImage.createFromImage(p.scaled(p.getWidth() * 3, p.getHeight() * 3), false);
        uRLImage = URLImage.createToStorage(enc, e.getLibelle(), "http://localhost" + e.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        b = new Button("Modifier");       
        toolbar.add(BorderLayout.CENTER, new Label("Toutes les Boutiques"));
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        content.add(imgV);
        content.add(des);        
        content.add(emplacement);
        content.add(emplacement2);
        content.add(b);
        
        b.addActionListener((m) -> {
            ModifBoutique mb = new ModifBoutique(e);
            mb.getF().show();
        });
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    

}
