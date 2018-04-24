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
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import static com.soukelmdina.gui.Layout.user;
import java.util.ArrayList;
import java.util.List;
import com.soukelmdina.entite.Espace_exposition;
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
        
        for (Espace_exposition ee:li){
           
            f.add(addItem(ee));
       }
    }
    public Container addItem(Espace_exposition e){
        enc=EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage=URLImage.createToStorage(enc, e.getPhoto(), Layout.URL+e.getPhoto(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
        Label lbimage= new Label(MyApplication.theme.getImage("round.png"));
        Label btn= new Label("Description "+e.getLibelle());
        //btn.addActionListener((act)->{System.out.println(e);});
        btn.addPointerPressedListener((act)->{detailespace int2 = new detailespace();
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
