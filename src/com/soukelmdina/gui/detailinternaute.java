/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Calendar;
import com.codename1.ui.Component;
import com.codename1.ui.EncodedImage;
<<<<<<< HEAD
import com.codename1.ui.Image;
import com.codename1.ui.Label;
=======
>>>>>>> 74783e2ea353b7c3aefd20075725584242c5ce1c
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.service.ServiceEspaceexpo;

/**
 *
 * @author marye
 */
public class detailinternaute extends Layout {
   private SpanLabel des,emplacement, numtel,longes,larges,prixesp;
    EncodedImage enc;
    URLImage uRLImage;
   
    
   public detailinternaute(String s0,String s1,String s2,String s3,double s4,int idsouk,double larg,double longue){
  ServiceEspaceexpo ses=new ServiceEspaceexpo();
<<<<<<< HEAD
  Souk s=ses.getsouk(idsouk);
  toolbar.add(BorderLayout.CENTER, new Label(s0));
  content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
   
  
  
    des = new SpanLabel(s1);
          des = new SpanLabel(s1);
        numtel=new SpanLabel("N° Tel :"+s3);
        longes=new SpanLabel("longeur de l' éspace :"+longue);
        larges=new SpanLabel("largeur de l'éspace :"+larg);
        prixesp=new SpanLabel("prix de l'éspace :"+s4);
        emplacement=new SpanLabel(s.getLibelle());
     Border border = Border.createLineBorder(1,0xfe6565/*Color.RED.hashCode()*/);
     
         des.getAllStyles().setAlignment(Component.LEFT);
        des.getAllStyles().setBorder(border);
        numtel.getAllStyles().setAlignment(Component.LEFT);
        numtel.getAllStyles().setBorder(border);
        longes.getAllStyles().setAlignment(Component.LEFT);
        longes.getAllStyles().setBorder(border);
        larges.getAllStyles().setAlignment(Component.LEFT);
        larges.getAllStyles().setBorder(border);
        prixesp.getAllStyles().setAlignment(Component.LEFT);
        prixesp.getAllStyles().setBorder(border);
        emplacement.getAllStyles().setAlignment(Component.LEFT);
        emplacement.getAllStyles().setBorder(border);
            Label l = new Label("");
        Label l1 = new Label("");

        Label l2 = new Label("");
  
   
      Image screenshot = Image.createImage(200, 200);
        enc = EncodedImage.createFromImage(screenshot, false);
   uRLImage=URLImage.createToStorage(enc,s2, Layout.URL+s2,URLImage.RESIZE_SCALE_TO_FILL);
   ImageViewer imgV=new ImageViewer(uRLImage);
   content.add(imgV);
    content.add(l);
    content.add(l2);
   content.add(des);
    content.add(l1);
   content.add(numtel);
   
   content.add(longes);
   
   content.add(larges);
   content.add(prixesp);
   content.add(emplacement);
  
   f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
=======
        Souk s=ses.getsouk(idsouk);
   f.setTitle(s0);
   des = new SpanLabel(s1);
   emplacement=new SpanLabel(s.getLibelle());
   enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
   uRLImage=URLImage.createToStorage(enc,s2, Layout.URL+s2,URLImage.RESIZE_SCALE_TO_FILL);
   ImageViewer imgV=new ImageViewer(uRLImage);
   
   f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
   f.add(imgV);
   f.add(des);
   f.add("N° Tel :"+s3);
   f.add("longeur de l espace :"+longue);
   f.add("largeur de lespace :"+larg);
   f.add("prix de lespace :"+s4);
   f.add(emplacement);
>>>>>>> 74783e2ea353b7c3aefd20075725584242c5ce1c
   }
   }
    
    
    