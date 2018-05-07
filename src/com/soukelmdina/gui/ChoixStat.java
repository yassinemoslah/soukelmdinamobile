/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;

/**
 *
 * @author lina9
 */
public class ChoixStat extends Layout{
    
    
    Button b;
    private RadioButton ch1, ch2;
            
    public ChoixStat() {
    
        toolbar.add(BorderLayout.CENTER, new Label("Choix : "));
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        b = new Button("Choisir");
        
        ch1 = new RadioButton("abonnées, like et dislike");
        ch2 = new RadioButton("Taux Like Dislike");
        
        new ButtonGroup(ch1, ch2);
        
        f.add(ch1);
        f.add(ch2);
        f.add(b);
        f.show();
        
        b.addActionListener((e) -> {
            if(ch1.isSelected()){
                BoutiqueCharts bc = new BoutiqueCharts();
                bc.getF().show();
            }
            if(ch2.isSelected()){
                BoutiqueCharts2 bc = new BoutiqueCharts2();
                bc.getF().show();
            }
        });
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
