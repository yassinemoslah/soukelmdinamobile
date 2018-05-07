/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Espace_exposition;
import com.soukelmdina.service.ServiceEspaceexpo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marye
 */
public class espacevendeur extends Layout{
 EncodedImage enc;
 URLImage uRLImage;
 
  List<Espace_exposition> li = new ArrayList<>();
 public espacevendeur() {
  ServiceEspaceexpo ses=new ServiceEspaceexpo();
   Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png")); 
  toolbar.add(BorderLayout.CENTER, new Label("Mes Espaces"));
 overflowMenu.addPointerPressedListener((e) -> {f.getToolbar().getMenuBar().showMenu();
 });
  toolbar.add(BorderLayout.EAST, overflowMenu);
  f.getToolbar().addCommandToOverflowMenu("Déposez annonce", null,(ev)->{
               ServiceEspaceexpo se=new ServiceEspaceexpo();
               createespace es=new createespace();
               es.getF().show();
               
        
                });
 li=ses.getespacevandeur(MyApplication.user.getCin());
 if (li==null){ System.err.println("rien a afficher");;}
 else{
 for (Espace_exposition ee:li){
           
            
        content.add(addItem(ee));
        }
           }
    f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
 
 
 
 }
    public Container addItem(Espace_exposition e){
    enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
    uRLImage=URLImage.createToStorage(enc, e.getPhoto(), Layout.URL+e.getPhoto(),URLImage.RESIZE_SCALE_TO_FILL);
    ImageViewer imgV=new ImageViewer(uRLImage);
        //Label lbimage= new Label(MyApplication.theme.getImage("round.png"));
    Label btn= new Label(e.getLibelle());
        //btn.addActionListener((act)->{System.out.println(e);});
         
    btn.addPointerPressedListener((act)->{detailvendeur int2 = new detailvendeur(e.getId(),e.getLibelle(),e.getDescription(),e.getPhoto(),e.getNumTel(),e.getPrix(),e.getIdsouk(),e.getLongeur(),e.getLargeur());
    int2.getF().show();
       });
    Container  cnt1 = new Container(BoxLayout.y());
       
    cnt1.add(btn);
    Container cnt2= new Container(BoxLayout.x());
        //Container cnt2= BorderLayout.center(cnt1);
        //cnt2.add(BorderLayout.EAST, lbimage);
    cnt2.add(imgV);
    cnt2.add(cnt1);
    cnt2.setLeadComponent(btn);
    return cnt2;
    }
        
        
}
