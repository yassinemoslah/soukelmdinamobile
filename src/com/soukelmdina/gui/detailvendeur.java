/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.service.ServiceEspaceexpo;
import java.io.IOException;

/**
 *
 * @author marye
 */
public class detailvendeur extends Layout {
   private SpanLabel des,emplacement;
    EncodedImage enc;
    URLImage uRLImage;
   
    
   public detailvendeur(int idespace,String s0,String s1,String s2,String s3,double s4,int idsouk,double larg,double longue){
   ServiceEspaceexpo ses=new ServiceEspaceexpo();
  Souk s=ses.getsouk(idsouk);
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
   des = new SpanLabel(s1);
   emplacement=new SpanLabel(s.getLibelle());
   enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
   uRLImage=URLImage.createToStorage(enc,s2, Layout.URL+s2,URLImage.RESIZE_SCALE_TO_FILL);
   ImageViewer imgV=new ImageViewer(uRLImage);
   content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
   content.add(imgV);
   content.add(des);
   content.add("N° Tel :"+s3);
   content.add("longeur de l espace :"+longue);
   content.add("largeur de lespace :"+larg);
   content.add("prix de lespace :"+s4);
   content.add(emplacement);
    f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
   }
}
