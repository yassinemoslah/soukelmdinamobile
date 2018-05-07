/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ToastBar;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author sana
 */
public class HomeForm extends Layout {

    public HomeForm() {
        //f.setLayout(new BorderLayout());

        toolbar.add(BorderLayout.CENTER, new Label("Accueil"));
        Label lbl = new Label("Welcome to Souk El Mdina");
<<<<<<< HEAD
        
Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png")); 
 
 overflowMenu.addPointerPressedListener((e) -> {f.getToolbar().getMenuBar().showMenu();
 });
  toolbar.add(BorderLayout.EAST, overflowMenu);

  f.getToolbar().addCommandToOverflowMenu("Play video souk", null,(ev)->{
               
      
         try {
//             final Form hi = new Form("", new BorderLayout());
                    Media video = MediaManager.createMedia("file:/C:/Users/marye/Desktop/Medina.mp4", true);
//                    hi.setLayout(new BorderLayout());

                content.setLayout(new BorderLayout());
                content.add(BorderLayout.NORTH,lbl);
                content.add(BorderLayout.SOUTH,new MediaPlayer(video));
//                  
                content.revalidate();
                video.setTime(80500);
                video.play();
                } catch(IOException err) {
                   
                }
                });
        
  
=======

        content.add(lbl);
>>>>>>> 74783e2ea353b7c3aefd20075725584242c5ce1c
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_3.jpg"));

    }

}
