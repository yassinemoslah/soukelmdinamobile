/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.service.ServiceEspaceexpo;
import java.io.IOException;

/**
 *
 * @author marye
 */
public class detailvendeur extends Layout {
   private SpanLabel des,emplacement, numtel,longes,larges,prixesp;
    EncodedImage enc;
    URLImage uRLImage;
   
    
   public detailvendeur(int idespace,String s0,String s1,String s2,String s3,double s4,int idsouk,double larg,double longue){
   ServiceEspaceexpo ses=new ServiceEspaceexpo();
  Souk s=ses.getsouk(idsouk);
   des = new SpanLabel(s1);
        numtel=new SpanLabel("N° Tel :"+s3);
        longes=new SpanLabel("longeur de l' éspace :"+longue);
        larges=new SpanLabel("largeur de l'éspace :"+larg);
        prixesp=new SpanLabel("prix de l'éspace :"+s4);
        emplacement=new SpanLabel(s.getLibelle());
          Border border = Border.createLineBorder(1,0xfe6565/*Color.RED.hashCode()*/);
      emplacement=new SpanLabel(s.getLibelle());
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
  
  
  
  
  
  
  
  
  
  Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png")); 
  toolbar.add(BorderLayout.CENTER, new Label(s0));

  overflowMenu.addPointerPressedListener((e) -> {f.getToolbar().getMenuBar().showMenu();});
  toolbar.add(BorderLayout.EAST, overflowMenu);
  f.getToolbar().addCommandToOverflowMenu("Modifier", null,(ev)->{
        ServiceEspaceexpo se=new ServiceEspaceexpo();
     
       updateespace es=new updateespace(idespace,s0,s1,s2,s3,s4,larg,longue);
                es.getF().show();
        
                });
   f.getToolbar().addCommandToOverflowMenu("supprimer", null,(ActionEvent ev)->{
       System.out.println(idespace);
       ServiceEspaceexpo se=new ServiceEspaceexpo();
       se.supprimerespace(idespace);
       Dialog.show("Alerte","espace supprimé avec succés", "cancel", "ok");
       espacevendeur es=new espacevendeur();
        es.getF().show();
       
                });

  
  
      Image screenshot = Image.createImage(200, 200);
        enc = EncodedImage.createFromImage(screenshot, false);
   uRLImage=URLImage.createToStorage(enc,s2, Layout.URL+s2,URLImage.RESIZE_SCALE_TO_FILL);
   ImageViewer imgV=new ImageViewer(uRLImage);
   content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
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
   }
}
