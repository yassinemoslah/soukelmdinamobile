/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Calendar;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Espace_exposition;
import com.soukelmdina.entite.Souk;
import static com.soukelmdina.gui.Layout.user;
import com.soukelmdina.service.ServiceEspaceexpo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marye
 */
public class detailespace extends Layout {
   private SpanLabel des,emplacement;
    EncodedImage enc;
    URLImage uRLImage;
   
    
   public detailespace(String s0,String s1,String s2,String s3,double s4,int idsouk,double larg,double longue){
  ServiceEspaceexpo ses=new ServiceEspaceexpo();
        Souk s=ses.getsouk(idsouk);
   f.setTitle(s0);
   des = new SpanLabel(s1);
   emplacement=new SpanLabel(s.getLibelle());
   enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
   uRLImage=URLImage.createToStorage(enc,s2, Layout.URL+s2,URLImage.RESIZE_SCALE_TO_FILL);
   ImageViewer imgV=new ImageViewer(uRLImage);
   Calendar cal=new Calendar();
   Calendar cal1=new Calendar();
   f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
   f.add(imgV);
   f.add(des);
   f.add("N° Tel :"+s3);
   f.add("longeur de l espace :"+longue);
   f.add("largeur de lespace :"+larg);
   f.add("prix de lespace :"+s4);
   f.add(emplacement);
   f.add(cal);
   f.add(cal1);
   }
    
    
    
    
    
    
}
