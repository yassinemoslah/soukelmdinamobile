/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
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
   f.setTitle(s0);
   des = new SpanLabel(s1);
   emplacement=new SpanLabel(s.getLibelle());
   enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
   uRLImage=URLImage.createToStorage(enc,s2, Layout.URL+s2,URLImage.RESIZE_SCALE_TO_FILL);
   ImageViewer imgV=new ImageViewer(uRLImage);
   f.getToolbar().addCommandToOverflowMenu("Modifier", null,(ev)->{System.out.println("maryoummmmmmmmmmmmaaaaaaaaaaaaaa"); 
                });
   f.getToolbar().addCommandToOverflowMenu("supprimer", null,(ActionEvent ev)->{
       System.out.println(idespace);
       ServiceEspaceexpo se=new ServiceEspaceexpo();
       se.supprimerespace(idespace);
       espacevendeur es=new espacevendeur();
        es.getF().show();
       
                });
   f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
   f.add(imgV);
   f.add(des);
   f.add("N° Tel :"+s3);
   f.add("longeur de l espace :"+longue);
   f.add("largeur de lespace :"+larg);
   f.add("prix de lespace :"+s4);
   f.add(emplacement);
   }
}
