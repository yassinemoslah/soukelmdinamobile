/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.admob.AdMobManager;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Espace_exposition;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.service.ServiceEspaceexpo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marye
 */
public class detailespace extends Layout {
   private SpanLabel des,emplacement;
    EncodedImage enc;
    URLImage uRLImage;
   private Button btn;
   private AdMobManager admob;
    
   public detailespace(int ides,String s0,String s1,String s2,String s3,double s4,int idsouk,double larg,double longue){
  ServiceEspaceexpo ses=new ServiceEspaceexpo();
        Souk s=ses.getsouk(idsouk);
  toolbar.add(BorderLayout.CENTER, new Label(s0));
  content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
       
   des = new SpanLabel(s1);
   emplacement=new SpanLabel(s.getLibelle());
   enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
   uRLImage=URLImage.createToStorage(enc,s2, Layout.URL+s2,URLImage.RESIZE_SCALE_TO_FILL);
   ImageViewer imgV=new ImageViewer(uRLImage);
//   Calendar c=new Calendar();
// Date d = new Date();
Picker datePicker1 = new Picker();
datePicker1.setDate(null);
Picker datePicker2 = new Picker();
datePicker2.setDate(null);
 //c.setMultipleSelectionEnabled(true);
  
             
 admob = new AdMobManager("ca-app-pub-1385000487471701/2768727905");

btn = new Button("Modifier");

        btn.addActionListener(
                (e) -> {
              admob.loadAndShow();
              
                   Date datedebut=(Date) datePicker1.getValue();
                   Date datefin=(Date) datePicker2.getValue();
                  

                  if (datedebut==null && datefin==null)
                  { System.out.println("vide");
                  
                  Dialog.show("Alerte", "SVP Remplir au moin une date pour louer un espace ", "cancel", "ok");
                  
                  }
                  else  if(datedebut==null)
                 {
                Dialog.show("Alerte", "la 1er date est obligatoire ", "cancel", "ok");
                  
                 }
                  else {
                 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                 String StringDate1=df.format(datedebut);
                
                                
                 if (datefin==null)
                   {
                       
                       ServiceEspaceexpo es=new ServiceEspaceexpo();
                        Espace_exposition esp= new Espace_exposition();
                       esp=es.louerespace1(ides,StringDate1);
                        Dialog.show("Alerte", esp.getLibelle(), "cancel", "ok");
                       System.out.println(esp.getLibelle());
                 System.out.println("date 2 est vide");
                 }
                 else{
                  String StringDate2=df.format(datefin);
                  ServiceEspaceexpo es=new ServiceEspaceexpo();
                        Espace_exposition esp= new Espace_exposition();
                       esp=es.louerespace2(ides,StringDate1,StringDate2);
                       
                       Dialog.show("Alerte", esp.getLibelle(), "cancel", "ok");
                  System.out.println("les 2 date sont remplis");
                 
                 }
                  
                  
                  
                  }
                }     );
  
   content.add(imgV);
   content.add(des);
   content.add("N° Tel :"+s3);
   content.add("longeur de l espace :"+longue);
   content.add("largeur de lespace :"+larg);
   content.add("prix de lespace :"+s4);
   content.add(emplacement);
   content.add(datePicker1);
   content.add(datePicker2);
      content.add(btn);
   f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
   }
    
    
    
    
    
    
}
