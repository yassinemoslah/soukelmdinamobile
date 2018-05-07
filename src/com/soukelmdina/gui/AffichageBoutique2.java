/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;


import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.soukelmdina.entite.Boutique1;
import com.soukelmdina.service.ServiceBoutique;
import com.soukelmdina.app.MyApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;

/**
 *
 * @author lina9
 */
public class AffichageBoutique2 extends Layout{

    Style s = UIManager.getInstance().getComponentStyle("MultiLine1");
    //Form f = new Form("Toutes les boutiques");
    SpanLabel lb;   
    String url = "http://localhost/soukelmdina/assets/img/boutique/3ac8566c12188a5858d51c9f3a142e44.png";
    

    public AffichageBoutique2() {
        
        toolbar.add(BorderLayout.CENTER, new Label("Toutes les Boutiques"));
        
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));

        
        List<Boutique1> li = new ArrayList<>();
        ServiceBoutique serviceb = new ServiceBoutique();
        //String ss = serviceb.chartss();
        //System.out.println(ss);
        ArrayList<Boutique1> lis = serviceb.getList2();
        for (int j = 0; j < lis.size() - 1; j++) {
            li.add(lis.get(j));
        }

        for (Boutique1 ee : li) {
            f.add(addItem(ee));
        }
                
        
        f.getToolbar().addCommandToSideMenu("Mes Boutiques", null,
             (ev)->{BoutiqueParVendeur home = new BoutiqueParVendeur(); home.getF().show();});
        
        
        f.getToolbar().addCommandToSideMenu("Ajouter", null,
             (ev)->{AjoutBoutique home = new AjoutBoutique(); home.getF().show();
                });                              
        
        f.getToolbar().addCommandToSideMenu("Stat", null,
             (ev)->{ChoixStat home = new ChoixStat(); home.getF().show();});
        
    }

    Style ss = UIManager.getInstance().getComponentStyle("MultiLine1");
    FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, ss);
    EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 3, p.getHeight() * 3), false);
    Image roundMask = Image.createImage(placeholder.getWidth(), placeholder.getHeight());
    URLImage.ImageAdapter ada = URLImage.createMaskAdapter(roundMask);

    public Container addItem(Boutique1 e) {
        //Label lbimage= new Label(theme.getImage("round.png"));
        url = "http://localhost" + e.getPhoto();
        System.out.println(url + "\n");
        //fileNameInStorage
        Image i = URLImage.createToStorage(placeholder, e.getLibelle(), url, ada);

        //Label lbtexte = new Label(String.valueOf(e.getId()));
        SpanLabel btn = new SpanLabel("Libelle " + e.getLibelle());
        //btn.addActionListener((act)->{System.out.println(e);});
        btn.addPointerReleasedListener((act) -> {
            DetailsBoutique2 db = new DetailsBoutique2(e);
            db.getF().show();
        });
        /*btn.addPointerPressedListener((act)->{Interface2 int2 = new Interface2(e, f.getTitle());
        int2.getF().show();
        });*/
        Container cnt1 = new Container(BoxLayout.y());
        //cnt1.add(lbtexte);
        cnt1.add(btn);
        Container cnt2 = new Container(BoxLayout.x());
        //Container cnt2= BorderLayout.center(cnt1);
        //cnt2.add(BorderLayout.EAST, lbimage);
        cnt2.add(i);
        cnt2.add(cnt1);
        cnt2.setLeadComponent(btn);

        return cnt2;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
