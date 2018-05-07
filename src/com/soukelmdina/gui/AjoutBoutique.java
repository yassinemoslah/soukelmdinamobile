/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique1;
import com.soukelmdina.service.ServiceBoutique;
import com.soukelmdina.technique.controleSaisie;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author lina
 */
public class AjoutBoutique extends Layout {

    TextField tnom, tdes, numtel;

    Button btnajout, btnaff;
    
    String chch;
    
    int number;
    
    boolean test;
    EncodedImage enc;
    URLImage uRLImage;private byte[] bytesdata;

    String photo = "nophoto";
    Label erreurLibelle, erreurDescription, erreurnumtel, erreurPhoto, erreurSouk;
    public AjoutBoutique() {
        toolbar.add(BorderLayout.CENTER, new Label("Ajouter Boutique"));
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        
        controleSaisie cs = new controleSaisie();
        
        tnom = new TextField();        
        tdes = new TextField();
        numtel = new TextField();               
        
String ph;
        btnajout = new Button("ajouter");

        

        tnom.setHint("Libelle");
        tdes.setHint("Description");
        numtel.setHint("Numéro tél");

        String[] characters = {"Tyrion Lannister", "Jaime Lannister", "Cersei Lannister", "Daenerys Targaryen",
            "Jon Snow" /* cropped */};

        ServiceBoutique ser = new ServiceBoutique();
        
        AutoCompleteTextField act = new AutoCompleteTextField(ser.findSouksJson());
        act.setHint("Choisir un Souk");
        act.addActionListener((evt) -> {
            chch=act.getText().trim();System.out.println("chch : "+chch);
            
        });
        //act.addActionListener(e -> ToastBar.showMessage("You picked " + act.getText(), FontImage.MATERIAL_INFO));
        //Button down = new Button();
        //FontImage.setMaterialIcon(down, FontImage.MATERIAL_KEYBOARD_ARROW_DOWN);
        //down.addActionListener(e -> act.showPopup());
//        f.add(
//                BorderLayout.center(act).
//                        add(BorderLayout.EAST, down));

Label lbl = new Label("Ajouter une image ");

Image red = Image.createImage(180, 180, 0xffff0000);
Container container = new Container();
        container.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        
        enc = EncodedImage.createFromImage(red, false);
        uRLImage = URLImage.createToStorage(enc, "imgvide.png", Layout.URL + "/imgvide.png", URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Label l = new Label("");
        container.add(BorderLayout.CENTER, lbl);
        
        
        content.add(tnom);
        content.add(tdes);
        content.add(numtel);
        content.add(container);
        content.add(act);
        content.add(btnajout);
               

//        btnphoto.addActionListener((e) -> {
//            Display.getInstance().openImageGallery(new ActionListener() {
//                public void actionPerformed(ActionEvent ev) {
//                    //...
//                }
//            });
//        });

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
                               
                                number=ser.findSouksJson2(chch);
                                System.out.println("number : "+number);
                                Boutique1 t = new Boutique1(tnom.getText(), tdes.getText(), numtel.getText(),number,photo);
                                ser.ajoutTask(t, bytesdata                               );
                            }
                          }                            
                        }
                    }
                }
            }
            

        });

        f.getToolbar().addCommandToSideMenu("Toutes les boutiques", null,
                (ev) -> {
                    AffichageBoutique2 home = new AffichageBoutique2();
                    home.getF().show();
                });
        f.getToolbar().addCommandToSideMenu("Stat", null,
                (ev) -> {
                    BoutiqueCharts home = new BoutiqueCharts();
                    home.getF().show();
                });
        
        lbl.addPointerPressedListener((e) -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        photo = (String) ev.getSource();
                        
                        try {
                            Image img = Image.createImage((String) ev.getSource());
                            ImageIO imgIO = ImageIO.getImageIO();
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            imgIO.save(img, out, ImageIO.FORMAT_JPEG, 1);
                            bytesdata = out.toByteArray();
                            imgV.setImage(Image.createImage(FileSystemStorage.getInstance().openInputStream(photo)));
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                    }
                }
            }, Display.GALLERY_IMAGE);
        });
    }
    
    
    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
