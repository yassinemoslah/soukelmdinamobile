/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.capture.Capture;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.service.ServiceUtilisateur;
import com.soukelmdina.technique.SpanLabel1;
import com.soukelmdina.technique.controleSaisie;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author mosla
 */
public class Inscription extends Layout {

    private TextField nom, prenom, numtel, adresse, codePostal, email, cin, password, password2;
    private RadioButton homme, femme, client, vendeur;
    private ComboBox<String> gouvernorat;
    private Button btn;
    private Label changePhoto, erreurNom, erreurEmail, erreurPrenom, erreurNumtel, erreurAdresse, erreurCodePostal, erreurCin, erreurPhoto;
    private SpanLabel1 erreurPassword, erreurPassword1;
    private String genre = "Homme", photo = "nophoto", role = "Client";
    private byte[] bytesdata;

    public Inscription() {

        nom = new TextField("", "Nom");
        prenom = new TextField("", "Prénom");
        numtel = new TextField("", "N° Tél.");
        adresse = new TextField("", "Adresse");
        codePostal = new TextField("", "Code Postal");
        email = new TextField("", "E-mail");
        cin = new TextField("", "CIN");
        password = new TextField("", "Mot de passe");
        password2 = new TextField("", "Répeter le mot de passe");
        password.setConstraint(TextField.PASSWORD);
        password2.setConstraint(TextField.PASSWORD);

        erreurNom = new Label();
        erreurNom.setVisible(false);
        erreurEmail = new Label();
        erreurEmail.setVisible(false);
        erreurPrenom = new Label();
        erreurPrenom.setVisible(false);
        erreurNumtel = new Label();
        erreurNumtel.setVisible(false);
        erreurAdresse = new Label();
        erreurAdresse.setVisible(false);
        erreurCodePostal = new Label();
        erreurCodePostal.setVisible(false);
        erreurCin = new Label();
        erreurCin.setVisible(false);
        erreurPassword = new SpanLabel1();
        erreurPassword.setVisible(false);
        erreurPassword1 = new SpanLabel1();
        erreurPassword1.setVisible(false);
        erreurPhoto = new Label();
        erreurPhoto.setVisible(false);

        erreurNom.setUIID("RedLabel");
        erreurEmail.setUIID("RedLabel");
        erreurPrenom.setUIID("RedLabel");
        erreurNumtel.setUIID("RedLabel");
        erreurAdresse.setUIID("RedLabel");
        erreurCodePostal.setUIID("RedLabel");
        erreurCin.setUIID("RedLabel");
        erreurPassword.setUIID("RedLabel");
        erreurPassword1.setUIID("RedLabel");
        erreurPhoto.setUIID("RedLabel");

        homme = new RadioButton("Homme");
        femme = new RadioButton("Femme");
        client = new RadioButton("Client");
        vendeur = new RadioButton("Vendeur");

        ButtonGroup sexe = new ButtonGroup(homme, femme);
        ButtonGroup Role = new ButtonGroup(client, vendeur);

        homme.setSelected(true);
        client.setSelected(true);

        remplirGouvernorat();

        changePhoto = new Label(MyApplication.theme.getImage("avatar.png"));
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
                            changePhoto.setIcon(Image.createImage(FileSystemStorage.getInstance().openInputStream(photo)).scaledSmallerRatio(100, 100));
                            f.revalidate();

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
                                    changePhoto.setIcon(Image.createImage(FileSystemStorage.getInstance().openInputStream(photo)).scaledSmallerRatio(100, 100));
                                    f.revalidate();
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

        btn = new Button("S'inscrire");

        btn.addActionListener(
                (e) -> {
                    if (!controle()) {
                        ServiceUtilisateur su = new ServiceUtilisateur();
                        if (femme.isSelected()) {
                            genre = "Femme";
                        }
                        if (vendeur.isSelected()) {
                            role = "Vendeur";
                        }
                        su.addUser(email.getText(), cin.getText(), password.getText(), role, photo, nom.getText(), prenom.getText(), genre, numtel.getText(), adresse.getText(), gouvernorat.getSelectedItem(), codePostal.getText(), bytesdata);
                    }
                }
        );
        toolbar.add(BorderLayout.CENTER, new Label("Inscription"));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.add(email);
        content.add(erreurEmail);
        content.add(cin);
        content.add(erreurCin);
        content.add(nom);
        content.add(erreurNom);
        content.add(prenom);
        content.add(erreurPrenom);
        content.add(numtel);
        content.add(erreurNumtel);
        content.add(adresse);
        content.add(erreurAdresse);
        content.add(codePostal);
        content.add(erreurCodePostal);
        content.add(gouvernorat);
        content.add(homme);
        content.add(femme);
        content.add(changePhoto);
        content.add(erreurPhoto);
        content.add(client);
        content.add(vendeur);
        content.add(password);
        content.add(erreurPassword);
        content.add(password2);
        content.add(erreurPassword1);
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
    }

    private boolean controle() {
        erreurNom.setVisible(false);
        erreurEmail.setVisible(false);
        erreurPrenom.setVisible(false);
        erreurNumtel.setVisible(false);
        erreurAdresse.setVisible(false);
        erreurCodePostal.setVisible(false);
        erreurCin.setVisible(false);
        erreurPassword.setVisible(false);
        erreurPassword1.setVisible(false);
        erreurPhoto.setVisible(false);

        boolean verif = false;
        controleSaisie ctrl = new controleSaisie();

        if (ctrl.controleTextFieldVide(email.getText())) {
            erreurEmail.setText("Vous devez saisir votre e-mail");
            erreurEmail.setVisible(true);
            verif = true;
        } else if (ctrl.controleMailFormat(email.getText())) {
            erreurEmail.setText("E-mail invalide");
            erreurEmail.setVisible(true);
            verif = true;
        }

        if (ctrl.controleTextFieldVide(cin.getText())) {
            erreurCin.setText("Vous devez saisir votre cin");
            erreurCin.setVisible(true);
            verif = true;
        } else if (ctrl.controleTextFieldChiffres(cin.getText()) || cin.getText().length() != 8) {
            erreurCin.setText("Le CIN est composé de 8 chiffres.");
            erreurCin.setVisible(true);
            verif = true;
        } else if (cin.getText().equals("00000000")) {
            erreurCin.setText("CIN incorrect.");
            erreurCin.setVisible(true);
            verif = true;
        }

        if (ctrl.controleTextFieldVide(nom.getText())) {
            erreurNom.setText("Vous devez saisir votre nom");
            erreurNom.setVisible(true);
            verif = true;
        } else if (ctrl.controleTextFieldOnlyLetters(nom.getText())) {
            erreurNom.setText("Le nom est composé des lettres");
            erreurNom.setVisible(true);
            verif = true;
        }

        if (ctrl.controleTextFieldVide(prenom.getText())) {
            erreurPrenom.setText("Vous devez saisir votre prénom");
            erreurPrenom.setVisible(true);
            verif = true;
        } else if (ctrl.controleTextFieldOnlyLetters(prenom.getText())) {
            erreurPrenom.setText("Le prénom est composé des lettres");
            erreurPrenom.setVisible(true);
            verif = true;
        }

        if (ctrl.controleTextFieldVide(numtel.getText())) {
            erreurNumtel.setText("Vous devez saisir votre N° Tél.");
            erreurNumtel.setVisible(true);
            verif = true;
        } else if (numtel.getText().length() != 8) {
            erreurNumtel.setText("Le N° Tél. est composé des 8 chiffres");
            erreurNumtel.setVisible(true);
            verif = true;
        } else if (ctrl.controleTextFieldChiffres(numtel.getText())) {
            erreurNumtel.setText("Le N° Tél. est composé des 8 chiffres");
            erreurNumtel.setVisible(true);
            verif = true;
        } else if (ctrl.controleNumTelFormat(numtel.getText())) {
            erreurNumtel.setText("N° Tél. n'est pas valide");
            erreurNumtel.setVisible(true);
            verif = true;
        }

        if (ctrl.controleTextFieldVide(adresse.getText())) {
            erreurAdresse.setText("Vous devez saisir votre adresse");
            erreurAdresse.setVisible(true);
            verif = true;
        }

        if (ctrl.controleTextFieldVide(codePostal.getText())) {
            erreurCodePostal.setText("Vous devez saisir le code postal");
            erreurCodePostal.setVisible(true);
            verif = true;
        } else if (ctrl.controleTextFieldChiffres(codePostal.getText()) || codePostal.getText().length() != 4) {
            erreurCodePostal.setText("Le code postal est composé de 4 chiffres.");
            erreurCodePostal.setVisible(true);
            verif = true;
        } else if (codePostal.getText().equals("0000")) {
            erreurCodePostal.setText("Code postal incorrect.");
            erreurCodePostal.setVisible(true);
            verif = true;
        }

        if (photo.equals("nophoto")) {
            erreurPhoto.setText("Vous devez choisir une photo.");
            erreurPhoto.setVisible(true);
            verif = true;
        }

        if (ctrl.controleTextFieldVide(password.getText())) {
            erreurPassword.setText("Vous devez saisir un mot de passe");
            erreurPassword.setVisible(true);
            verif = true;
        } else if (password.getText().length() < 8) {
            erreurPassword.setText("Le MDP doit au moins contenir 8 caractères.");
            erreurPassword.setVisible(true);
            verif = true;
        } else if (ctrl.controleComplexiteMDP(password.getText())) {
            erreurPassword.setText("Le MDP doit contenir des lettres miniscules, majuscules et des chiffres");
            erreurPassword.setVisible(true);
            verif = true;
        }

        if (!password.getText().equals(password2.getText())) {
            erreurPassword1.setText("Les 2 mot de passes ne sont pas identiques");
            erreurPassword1.setVisible(true);
            verif = true;
        }
        f.revalidate();
        return verif;
    }
}
