/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.gui.Layout;
import com.soukelmdina.service.ServiceEspaceexpo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marye
 */
public class createespace extends Layout{
  
    private TextField nom, description, numtel, categorie, larg,longu,prix,cat;
    private SpanLabel lnom, ldescription, lnumtel, lcategorie, llarg, llongu,lprix;
   List<Souk> li = new ArrayList<>();
   Button btn;
    private EncodedImage enc;
    private URLImage uRLImage;
     private Label changePhoto;
    private String  photo = "nophoto";
    private byte[] bytesdata;

    public createespace(){
    
    String [ ] tabsouks = new String[3];
    List<String> souks = new ArrayList<>();
    ServiceEspaceexpo se=new ServiceEspaceexpo();
      li=se.getnomssouks();
     for (Souk ee:li){
           
            souks.add(ee.getLibelle());
       }
    for(int i=0; i < 3; i++){
    tabsouks[i]=souks.get(i);
}
  
    Picker p = new Picker();
    p.setStrings(tabsouks);
//    p.setSelectedString("Souk");
    
         lnom = new SpanLabel("Nom :");
        ldescription = new SpanLabel("Description :");
        lcategorie = new SpanLabel("Catégorie :");
        lnumtel = new SpanLabel("N° Tel : ");
        llarg = new SpanLabel("largeur espace : ");
        llongu = new SpanLabel("longeur espace : ");
        lprix = new SpanLabel("prix espace : ");
        lnom.setTextBlockAlign(Component.LEFT);
        lcategorie.setTextBlockAlign(Component.LEFT);
        ldescription.setTextBlockAlign(Component.LEFT);
        lnumtel.setTextBlockAlign(Component.LEFT);
        llarg.setTextBlockAlign(Component.LEFT);
        llongu.setTextBlockAlign(Component.LEFT);
        lprix.setTextBlockAlign(Component.LEFT);
        nom = new TextField();
        description = new TextField();
        cat=new TextField();
        numtel = new TextField();
        larg=new TextField();
        longu=new TextField();
        prix=new TextField();
        btn = new Button("ajouter annonce");
enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
 uRLImage = URLImage.createToStorage(enc,photo, Layout.URL + photo, URLImage.RESIZE_SCALE_TO_FILL);
ImageViewer imgV = new ImageViewer(uRLImage);

        changePhoto = new Label("Changer la photo");
        changePhoto.addPointerPressedListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (Dialog.show("Camera or Gallery", "Would you like to use the camera or the gallery for the picture?", "Camera", "Gallery")) {
                    photo = Capture.capturePhoto();
                    if (photo != null) {
                        try {
                            Image img = Image.createImage(photo);
                            ImageIO imgIO = ImageIO.getImageIO();
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            imgIO.save(img, out, ImageIO.FORMAT_JPEG, 1);
                            bytesdata = out.toByteArray();
                            imgV.setImage(Image.createImage(FileSystemStorage.getInstance().openInputStream(photo)));
                        } catch (IOException err) {
                            System.out.println(err);
                        }
                    }
                } else {
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
                }

            }
        }
        );
             btn.addActionListener(
               (e) -> {
                   int nb=0;
                   if(photo.equals("nophoto")){System.out.println("champs photo vide");
                    Dialog.show("Alerte","champs photo vide", "cancel", "ok");
                   nb++;
                   }
                   if(nom.getText().equals("")){System.out.println("champs nom vide");
                   Dialog.show("Alerte","champs photo vide", "cancel", "ok");
                   nb++;
                   }
                   if(longu.getText().equals("")){System.out.println("champs longeur vide");
                   nb++;
                   }
                   
                   if(larg.getText().equals("")){System.out.println("champs largeur vide");
                   nb++;
                   }
                   
                   if(prix.getText().equals("")){System.out.println("champs prix vide");
                   nb++;
                   }
                   
                   if(cat.getText().equals("")){System.out.println("champs categorie vide");
                   nb++;
                   }
                   
                 if(p.getValue()==null){System.out.println("champs categorie vide");
                   nb++;
                   }
                   
                   
                   if(nb==0)
                   {
                   System.out.println(photo);
                      ServiceEspaceexpo ses=new ServiceEspaceexpo();
            int idsouk=0;
           for (int i = 0; i < li.size(); i++) {
               

                if (li.get(i).getLibelle().equals(p.getValue())) {
                   

                    idsouk = li.get(i).getId();
                }
            }
             
          
           
         
                 ses.createespace(photo, nom.getText(), description.getText(),numtel.getText(),Double.parseDouble(longu.getText()),Double.parseDouble(larg.getText()),Double.parseDouble(prix.getText()),idsouk,cat.getText(), bytesdata);
                   System.out.println(idsouk);
                 Dialog.show("Alerte","espace ajouté avec succés", "cancel", "ok");
               }
               } );
       
        toolbar.add(BorderLayout.CENTER, new Label("Ajouter un nouveau espace"));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
      content.add(imgV);
        content.add(changePhoto);
        content.add(lnom);
        content.add(nom);
        content.add(ldescription);
        content.add(description);
        content.add(lcategorie);
        content.add(cat);
        content.add(lnumtel);
        content.add(numtel);
        content.add(llarg);
        content.add(larg);
        content.add(llongu);
        content.add(longu);
        content.add(lprix);
        content.add(prix);
        content.add(p);
        content.add(btn);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    }

   

    
}
