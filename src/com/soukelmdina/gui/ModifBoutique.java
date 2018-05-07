/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique1;
import com.soukelmdina.service.ServiceBoutique;
import com.soukelmdina.technique.controleSaisie;
import java.util.Map;

/**
 *
 * @author sana
 */
public class ModifBoutique extends Layout {

    
    TextField tnom, tdes, numtel;
    EncodedImage enc;
    Button btnajout, btnaff;
    URLImage uRLImage;
    
    String chch;
    
    int number;
   

    public ModifBoutique(Boutique1 b) {
        //f.setLayout(BoxLayout.y());

        controleSaisie cs = new controleSaisie();
        toolbar.add(BorderLayout.CENTER, new Label("Modifier Boutique"));
        
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        tnom = new TextField();
        tdes = new TextField();
        numtel = new TextField();

        btnajout = new Button("Modifier");

        tnom.setText(b.getLibelle());
        tdes.setText(b.getDescription());
        numtel.setText(b.getNumTel());
        

        Style ss = UIManager.getInstance().getComponentStyle("MultiLine1");
        FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, ss);
        enc = EncodedImage.createFromImage(p.scaled(p.getWidth() * 3, p.getHeight() * 3), false);
        uRLImage = URLImage.createToStorage(enc, b.getLibelle(), "http://localhost" + b.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        imgV.addPointerReleasedListener((act) -> {
            Display.getInstance().openImageGallery(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    //...
                }
            });
        });
        
        ServiceBoutique ser = new ServiceBoutique();
        chch=ser.findSoukById(b.getId());
        AutoCompleteTextField act = new AutoCompleteTextField(ser.findSouksJson());
        act.setHint(chch);
        act.addActionListener((evt) -> {
            chch=act.getText().trim();System.out.println("chch : "+chch);
            
        });

        //f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.add(imgV);
        content.add(tnom);
        content.add(tdes);
        content.add(numtel);
        content.add(act);
        content.add(btnajout);

        btnajout.addActionListener((e) -> {
            if(cs.controleTextFieldVide(tnom.getText()))  
                Dialog.show("Alerte", "libelle vide", "OK", null);
            else{
                if(cs.controleTextFieldVide(tdes.getText()))
                    Dialog.show("Alerte", "Description vide", "OK", null);
                else{
                    if(cs.controleTextFieldVide(numtel.getText()))
                        Dialog.show("Alerte", "num tel", "OK", null);
                    else{
                        if(cs.controleNumTelFormat(numtel.getText()))
                            Dialog.show("Alerte", "num tem Format incorrecte", "OK", null);
                        else{
                            if(cs.controleNumTelLongueur(numtel.getText()))
                                Dialog.show("Alerte", "num tel Format incorrecte", "OK", null);
                            else
                            {if(act.getText()=="")
                                    Dialog.show("Alerte", "Choisissez souk", "OK", null); 
                            else{  
                                if (chch==""||chch== null)
                chch=ser.findSoukById(b.getId());
            
            number=ser.findSouksJson2(chch);
            
            //Boutique1 t = new Boutique1(tnom.getText(), tdes.getText(), numtel.getText(),number);
            //ser.ModifTask(t,b.getId());
                                }
                          }                            
                        }
                    }
                }
            
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
