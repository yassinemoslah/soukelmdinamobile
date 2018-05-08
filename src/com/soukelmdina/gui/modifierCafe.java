/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.service.ServiceCafeResto;
import com.soukelmdina.technique.controleSaisie;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author Amal Mabrouk
 */
public class modifierCafe extends Layout {

    TextField libelle, numtel;
    TextField tetat;
    TextArea description;
    Button btnmodification, btn;
    EncodedImage enc;
    URLImage uRLImage;
    Label erreurLibelle, erreurDescription, erreurnumtel, erreurPhoto;
    String photo = "nophoto";
    private byte[] bytesdata;

    public modifierCafe(CafeResto c) {
        toolbar.add(BorderLayout.CENTER, new Label("Modifier CafeResto"));

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));

        Image red = Image.createImage(180, 180, 0xffff0000);

        ServiceCafeResto sc = new ServiceCafeResto();
        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, c.getPhoto(), Layout.URL + c.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        libelle = new TextField(c.getLibelle());
        description = new TextArea(c.getDescription());
        numtel = new TextField(c.getNumtel());
        btnmodification = new Button("Modifier");
        Label lbl = new Label("Ajouter une image ");

        Container container = new Container();
        container.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        container.add(BorderLayout.CENTER, lbl);
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
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

        content.add(imgV);
        content.add(container);
        content.add(libelle);
        content.add(erreurLibelle);
        erreurLibelle.setUIID("RedLabel");
        content.add(description);
        content.add(erreurDescription);
        erreurDescription.setUIID("RedLabel");
        content.add(numtel);
        content.add(erreurnumtel);
        erreurnumtel.setUIID("RedLabel");
        content.add(btnmodification);

        content.add(erreurPhoto);
        erreurPhoto.setUIID("RedLabel");

        lbl.addPointerPressedListener((e) -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        photo = (String) ev.getSource();
                        c.setPhoto(photo);
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

        btnmodification.addActionListener((e) -> {
            if (controle() == true) {

                c.setLibelle(libelle.getText());
                c.setDescription(description.getText());
                c.setNumtel(numtel.getText());
                c.setAccept(1);
                c.setIdSouk(1);
                c.setPhoto(photo);
                c.setIdprprio(MyApplication.user.getId());
                sc.ModifierCafe(c, bytesdata);
                Dialog.show("Modification", "Le caféresto est modifié avec succés", "OK", null);

                ListeCafeRestoVendeur l = new ListeCafeRestoVendeur();
                l.f.show();
            }

        });

    }

    private boolean controle() {

        boolean verif = true;
        controleSaisie ctrl = new controleSaisie();
        if (ctrl.controleTextFieldVide(libelle.getText())) {
            erreurLibelle.setText("Libelle invalide");
            erreurLibelle.setVisible(true);
            verif = false;
        }
        if (!ctrl.controleTextFieldVide(libelle.getText())) {
            erreurLibelle.setVisible(false);

        }

        if (ctrl.controleTextFieldVide(description.getText())) {
            erreurDescription.setText("Description invalide");
            erreurDescription.setVisible(true);
            verif = false;

        }

        if (!ctrl.controleTextFieldVide(description.getText())) {
            erreurDescription.setVisible(false);

        }
        if (!isANumber(numtel.getText())) {
            erreurnumtel.setText("numéro de tel invalide");
            erreurnumtel.setVisible(true);
            verif = false;

        }
        if (isANumber(numtel.getText())) {
            erreurnumtel.setVisible(false);

        }

        f.revalidate();
        return verif;

    }

    boolean isANumber(String s) {
        if (s.length() != 8) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
