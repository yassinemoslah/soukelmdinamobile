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
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.service.ServiceEspaceexpo;
import com.soukelmdina.service.ServiceUtilisateur;
import com.soukelmdina.technique.controleSaisie;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author marye
 */
public class updateespace extends Layout {

    private TextField nom, description, numtel, categorie, larg, longu, prix;
    private SpanLabel lnom, ldescription, lnumtel, lcategorie, llarg, llongu, lprix;
    private ComboBox<String> Soukes;
    private EncodedImage enc;
    private URLImage uRLImage;
    private Button btn;
    private Label changePhoto;
    private String photo = "nophoto";
    private byte[] bytesdata;
    Label erreurLibelle, erreurDescription, erreurnumtel, erreurPhoto, erreurSouk, erreurlarg, erreurlong, erreurprix, erreurcat;

    public updateespace(int idespace, String s0, String s1, String urloldphoto, String s3, double s4, double largg, double longue) {
        lnom = new SpanLabel("Nom :");
        ldescription = new SpanLabel("Description :");
        lnumtel = new SpanLabel("N° Tel : ");
        llarg = new SpanLabel("largeur espace : ");
        llongu = new SpanLabel("longeur espace : ");
        lprix = new SpanLabel("prix espace : ");
        lnom.setTextBlockAlign(Component.LEFT);
        ldescription.setTextBlockAlign(Component.LEFT);
        lnumtel.setTextBlockAlign(Component.LEFT);

        llarg.setTextBlockAlign(Component.LEFT);
        llongu.setTextBlockAlign(Component.LEFT);
        lprix.setTextBlockAlign(Component.LEFT);
        nom = new TextField(s0);
        description = new TextField(s1);
        numtel = new TextField(s3);
        larg = new TextField(String.valueOf(largg));
        longu = new TextField(String.valueOf(longue));
        prix = new TextField(String.valueOf(s4));

        erreurLibelle = new Label();
        erreurLibelle.setVisible(false);
        erreurDescription = new Label();
        erreurDescription.setVisible(false);
        erreurnumtel = new Label();
        erreurnumtel.setVisible(false);
        erreurPhoto = new Label();
        erreurPhoto.setVisible(false);
        erreurLibelle.setVisible(false);
        erreurDescription.setVisible(false);
        erreurnumtel.setVisible(false);
        erreurPhoto.setVisible(false);
        erreurSouk = new Label();
        erreurSouk.setVisible(false);
        erreurlarg = new Label();
        erreurlarg.setVisible(false);
        erreurlong = new Label();
        erreurlong.setVisible(false);
        erreurprix = new Label();
        erreurprix.setVisible(false);
        erreurcat = new Label();
        erreurcat.setVisible(false);

        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, urloldphoto, Layout.URL + urloldphoto, URLImage.RESIZE_SCALE_TO_FILL);
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

        btn = new Button("Modifier");
        controleSaisie ctrl = new controleSaisie();
        btn.addActionListener(
                (e) -> {
                    int nb = 0;
                   
                    if (nom.getText().equals("")) {
                        System.out.println("champs nom vide");
                        erreurLibelle.setText("champs nom vide");
                        erreurLibelle.setVisible(true);
                        nb++;
                    }
                    if (longu.getText().equals("")) {
                        System.out.println("champs longeur vide");
                        erreurlong.setText("champs longeur vide");
                        erreurlong.setVisible(true);
                        nb++;
                    }

                    if (larg.getText().equals("")) {
                        System.out.println("champs largeur vide");
                        erreurlarg.setText("champs largeur vide");
                        erreurlarg.setVisible(true);
                        nb++;
                    }
                    if (description.getText().equals("")) {
                        System.out.println("champs largeur vide");
                        erreurDescription.setText("champs description vide");
                        erreurDescription.setVisible(true);
                        nb++;
                    }

                    if (prix.getText().equals("")) {
                        System.out.println("champs prix vide");
                        erreurprix.setText("champs prix vide");
                        erreurprix.setVisible(true);
                        nb++;
                    }

                    if (ctrl.controleNumTelLongueur(numtel.getText())) {
                        erreurnumtel.setText("Repllir avec 8 chiffre");
                        erreurnumtel.setVisible(true);
                        nb++;

                    }
                    if (numtel.getText().equals("")) {
                        erreurnumtel.setText("champs N° tel vide");
                        erreurnumtel.setVisible(true);
                        nb++;

                    }

                    if (!ctrl.isValidFloat(prix.getText())) {
                        erreurprix.setText("remplir avec des chiffres");
                        erreurprix.setVisible(true);
                        nb++;

                    }
                    if (!ctrl.isValidFloat(longu.getText())) {

                        erreurlong.setText("remplir avec des chiffres");
                        erreurlong.setVisible(true);
                        nb++;
                    }
                    if (!ctrl.isValidFloat(larg.getText())) {
                        erreurlarg.setText("remplir avec des chiffres");
                        erreurlarg.setVisible(true);
                        nb++;

                    }

                    if (nb == 0) {

                        ServiceEspaceexpo ses = new ServiceEspaceexpo();

                        if (photo.equals("nophoto")) {                          
                            ses.updateespace("nophoto", nom.getText(), description.getText(), numtel.getText(), Double.parseDouble(longu.getText()), Double.parseDouble(larg.getText()), Double.parseDouble(prix.getText()), idespace, bytesdata);
                        }
                        else{
                        ses.updateespace(photo, nom.getText(), description.getText(), numtel.getText(), Double.parseDouble(longu.getText()), Double.parseDouble(larg.getText()), Double.parseDouble(prix.getText()), idespace, bytesdata);
                        }
                        Dialog.show("Alerte", "espace modifié avec succés", "cancel", "ok");
                    }
                }
        );
        toolbar.add(BorderLayout.CENTER, new Label("Modifier mon espace"));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.add(imgV);
        content.add(changePhoto);
        content.add(erreurPhoto);
        erreurPhoto.setUIID("RedLabel");
        content.add(lnom);
        content.add(nom);
        content.add(erreurLibelle);
        erreurLibelle.setUIID("RedLabel");
        content.add(ldescription);
        content.add(description);
        content.add(erreurDescription);
        erreurDescription.setUIID("RedLabel");

        content.add(lnumtel);
        content.add(numtel);
        content.add(erreurnumtel);
        erreurnumtel.setUIID("RedLabel");
        content.add(llarg);

        content.add(larg);
        content.add(erreurlarg);
        erreurlarg.setUIID("RedLabel");

        content.add(llongu);
        content.add(longu);
        content.add(erreurlong);
        erreurlong.setUIID("RedLabel");
        content.add(lprix);
        content.add(prix);
        content.add(erreurprix);
        erreurprix.setUIID("RedLabel");
        content.add(btn);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    }

}
