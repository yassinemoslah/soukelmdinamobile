/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import java.util.ArrayList;
import java.util.List;
import com.soukelmdina.entite.Espace_exposition;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.service.ServiceEspaceexpo;

/**
 *
 * @author marye
 */
public class espaceexpohome extends Layout {
    EncodedImage enc;
    URLImage uRLImage;

    public espaceexpohome() {
      
       f.setTitle("Nos espaces d'expositions");
       f.setLayout(BoxLayout.y());
       List<Espace_exposition> li = new ArrayList<>();
       ServiceEspaceexpo ses=new ServiceEspaceexpo();
       li=ses.getespace();
       
        if (li==null){ System.err.println("rien a afficher");;}
        else{
        for (Espace_exposition ee:li){
           
<<<<<<< HEAD
           content.add(addItem(ee));
            content.add(addItem1());
=======
            f.add(addItem(ee));
>>>>>>> 74783e2ea353b7c3aefd20075725584242c5ce1c
       }
    }}
    public Container addItem(Espace_exposition e){
        
        Image screenshot = Image.createImage(160, 160);
        enc = EncodedImage.createFromImage(screenshot, false);
        uRLImage=URLImage.createToStorage(enc, e.getPhoto(), Layout.URL+e.getPhoto(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
        //Label lbimage= new Label(MyApplication.theme.getImage("round.png"));
        Label btn= new Label(e.getLibelle());
         Label btn1= new Label(String.valueOf(e.getPrix())+" DT/J");
         Label lab1= new Label("");
         Label lab2= new Label("");
        //btn.addActionListener((act)->{System.out.println(e);});
         
        btn.addPointerPressedListener((act)->{detailespace int2 = new detailespace(e.getLibelle(),e.getDescription(),e.getPhoto(),e.getNumTel(),e.getPrix(),e.getIdsouk(),e.getLongeur(),e.getLargeur());
        int2.getF().show();
        });
        Container  cnt1 = new Container(BoxLayout.y());
        
            cnt1.add(lab1);
        cnt1.add(lab2);
    
        cnt1.add(btn);
         cnt1.add(btn1);
        Container cnt2= new Container(BoxLayout.x());
        //Container cnt2= BorderLayout.center(cnt1);
        //cnt2.add(BorderLayout.EAST, lbimage);
        cnt2.add(imgV);
        cnt2.add(cnt1);
        cnt2.setLeadComponent(btn);
        return cnt2;
    }
        
        
        
        
          public Container addItem1() {
        //Label lbimage= new Label(MyApplication.theme.getImage("round.png"));
        Label lll = new Label("");
        Label llll = new Label("");
        Label ll = new Label("");
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt3 = new Container(BoxLayout.x());

        cnt1.add(ll);
        cnt1.add(llll);

        cnt1.add(lll);

        //  cnt2.add(ll);
        // cnt3.add(cnt2);
        return cnt1;
    }
        
        
        
        
        
        
        
    
    
    
}
