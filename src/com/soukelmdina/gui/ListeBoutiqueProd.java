/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.ToastBar;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique;
import com.soukelmdina.entite.Routes;
import com.soukelmdina.service.ServiceBoutiqueProd;

/**
 *
 * @author TAOUFIK
 */
public class ListeBoutiqueProd extends Layout{


    public ListeBoutiqueProd() {
f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         Label lab = new Label("Liste des Boutiques");
        lab.getAllStyles().setFgColor(0xF6E497);

        toolbar.add(BorderLayout.CENTER,lab);
         
         Style s1 = UIManager.getInstance().getComponentStyle("TitleCommand");

    FontImage icon30 = FontImage.createMaterial(FontImage.MATERIAL_NAVIGATE_BEFORE, s1);

    Label a = new Label(icon30);
    a.getAllStyles().setBorder(Border.createEmpty());
    a.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);

    toolbar.add(BorderLayout.EAST, a);
    a.addPointerPressedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            new HomeForm().getF().show();
        }
    });
        
        ServiceBoutiqueProd boutiqueProd = new ServiceBoutiqueProd();
        
        Boutique[] boutiques = boutiqueProd.getboutiques();
        for (Boutique boutique : boutiques) {
            content.add(createRankWidget(boutique.getNomBoutique(), boutique.getId()+"",boutique));
             
        }
        
   f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_5.jpg"));
    
    
    
    }



//-- DON'T EDIT ABOVE THIS LINE!!!
    public SwipeableContainer createRankWidget(String title, String description, Boutique b) {
        MultiButton button = new MultiButton(title);
              
        button.setTextLine2(b.getDescriptionBoutique());
       int mm = Display.getInstance().convertToPixels(6);
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 4, mm * 3, 0), false);

      URLImage  uRLImage = URLImage.createToStorage(placeholder, Routes.getPhotoProduits() + "/"+title, Routes.getPhotoProduits() +"/"+title, URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        imgV.setWidth(200);
        System.out.println(Routes.getPhotoProduits());
        content.add(imgV);
        
        button.addActionListener(new ActionListener() {

             
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                btq=b ;
                ToastBar.Status status = ToastBar.getInstance().createStatus();
                 status.setMessage("liste de produits en chargement .. ");
             status.setExpires(2000);
           status.show();
                new ListeProduitsByBoutiqueForm(b).getF().show();
            }
        });
        
        return new SwipeableContainer(FlowLayout.encloseCenterMiddle(createStarRankSlider()),
                button);
    }

    private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }

    private Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(10);
        starRank.setProgress(3);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        starRank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
            }
        });
        return starRank;
    }

 
   
   

}
