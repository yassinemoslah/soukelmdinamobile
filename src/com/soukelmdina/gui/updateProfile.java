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
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
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
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.service.ServiceUtilisateur;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author mosla
 */
public class updateProfile extends Layout {

    private TextField nom, prenom, numtel, adresse, codePostal;
    private SpanLabel lnom, lprenom, lnumtel, ladresse, lville, lCodePostal;
    private RadioButton homme, femme;
    private ComboBox<String> gouvernorat;
    private EncodedImage enc;
    private URLImage uRLImage;
    private Button btn;
    private Label changePhoto;
    private String genre = "Homme", photo = "nophoto";
    private byte[] bytesdata;

    public updateProfile() {
        lnom = new SpanLabel("Nom :");
        lprenom = new SpanLabel("Prénom :");
        lnumtel = new SpanLabel("Tél. : ");
        ladresse = new SpanLabel("Adresse : ");
        lville = new SpanLabel("Gouvernorat : ");
        lCodePostal = new SpanLabel("Code postal : ");

        lnom.setTextBlockAlign(Component.LEFT);
        lprenom.setTextBlockAlign(Component.LEFT);
        lnumtel.setTextBlockAlign(Component.LEFT);
        ladresse.setTextBlockAlign(Component.LEFT);
        lville.setTextBlockAlign(Component.LEFT);
        lCodePostal.setTextBlockAlign(Component.LEFT);

        nom = new TextField(MyApplication.user.getNom());
        prenom = new TextField(MyApplication.user.getPrenom());
        numtel = new TextField(MyApplication.user.getNumTel());
        adresse = new TextField(MyApplication.user.getAdresse().getAdresse());
        codePostal = new TextField(String.valueOf(MyApplication.user.getAdresse().getCodePostal()), "Code postal", 4, TextArea.NUMERIC);

        homme = new RadioButton("Homme");
        femme = new RadioButton("Femme");

        ButtonGroup sexe = new ButtonGroup(homme, femme);
        if (MyApplication.user.getSexe().equals("Homme")) {
            homme.setSelected(true);
        } else {
            femme.setSelected(true);
        }
        remplirGouvernorat();
        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("250x250.png"), false);
        uRLImage = URLImage.createToStorage(enc, MyApplication.user.getPhoto()+"a", Layout.URL + MyApplication.user.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        changePhoto = new Label(uRLImage);
        changePhoto.addPointerPressedListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (Dialog.show("Camera ou Gallerie", "Voulez vous prendre ou choisir une photo ?", "Camera", "Gallerie")) {
                    photo = Capture.capturePhoto();
                    if (photo != null) {
                        try {
                            Image img = Image.createImage(photo);
                            ImageIO imgIO = ImageIO.getImageIO();
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            imgIO.save(img, out, ImageIO.FORMAT_JPEG, 1);
                            bytesdata = out.toByteArray();
                            changePhoto.setIcon(Image.createImage(FileSystemStorage.getInstance().openInputStream(photo)).scaledSmallerRatio(250, 250));

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
                                    changePhoto.setIcon(Image.createImage(FileSystemStorage.getInstance().openInputStream(photo)).scaledSmallerRatio(250, 250));
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

        btn.addActionListener(
                (e) -> {
                    ServiceUtilisateur su = new ServiceUtilisateur();
                    if (femme.isSelected()) {
                        genre = "Femme";
                    }
                    su.updateUser(photo, nom.getText(), prenom.getText(), genre, numtel.getText(), adresse.getText(), gouvernorat.getSelectedItem(), codePostal.getText(), bytesdata);
                }
        );
        toolbar.add(BorderLayout.CENTER, new Label("Modifier mon profil"));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//        content.add(imgV);
        content.add(changePhoto);
        content.add(lnom);
        content.add(nom);
        content.add(lprenom);
        content.add(prenom);
        content.add(homme);
        content.add(femme);
        content.add(lnumtel);
        content.add(numtel);
        content.add(ladresse);
        content.add(adresse);
        content.add(lville);
        content.add(gouvernorat);
        content.add(lCodePostal);
        content.add(codePostal);
        content.add(btn);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    }

    private void remplirGouvernorat() {
        gouvernorat = new ComboBox<>();
        String list[] = {"Ariana", "Beja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kebili", "Le Kef", "Mahdia", "Manouba",
            "Medenine", "Monastir", "Nabeul", "Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan"};

        for (int i = 0; i < list.length; i++) {
            gouvernorat.addItem(list[i]);
        }
        gouvernorat.setSelectedItem(MyApplication.user.getAdresse().getVille());
    }

}
