/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique;
import com.soukelmdina.service.ServiceBoutiqueProd;

/**
 *
 * @author TAOUFIK
 */
public class ListeBoutiqueProd extends Layout{


    public ListeBoutiqueProd() {
f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         toolbar.add(BorderLayout.CENTER, new Label("Liste des Boutiques"));
        
        ServiceBoutiqueProd boutiqueProd = new ServiceBoutiqueProd();
        
        Boutique[] boutiques = boutiqueProd.getboutiques();
        for (Boutique boutique : boutiques) {
            content.add(createRankWidget(boutique.getNomBoutique(), boutique.getId()+"",boutique));
            
        }
    f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    
    
    }



//-- DON'T EDIT ABOVE THIS LINE!!!
    public SwipeableContainer createRankWidget(String title, String description, Boutique b) {
        MultiButton button = new MultiButton(title);
        button.setTextLine2(b.getDescriptionBoutique());
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btq=b ;
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
