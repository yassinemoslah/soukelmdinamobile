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
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import static com.soukelmdina.gui.Layout.user;

/**
 *
 * @author marye
 */
public class detailespace extends Layout {
   private SpanLabel des;
    EncodedImage enc;
    URLImage uRLImage;
   public detailespace(String s0,String s1,String s2){
   f.setTitle(s0);
   des = new SpanLabel(s1);
    enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
   uRLImage=URLImage.createToStorage(enc,s2, Layout.URL+s2,URLImage.RESIZE_SCALE_TO_FILL);
   ImageViewer imgV=new ImageViewer(uRLImage);
   f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
   f.add(imgV);
   f.add(des);
   }
    
    
    
    
    
    
}
