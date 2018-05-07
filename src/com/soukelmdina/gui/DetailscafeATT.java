/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.ImageIO;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.service.ServiceCafeResto;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Amal Mabrouk
 */
public class DetailscafeATT extends Layout {

    private SpanLabel libelle, description, numtel, cin, sexe, role;
    EncodedImage enc;
    URLImage uRLImage;
    private static final String HTML_API_KEY = "AIzaSyDhITczpAB5sqv1nJ0to8cyIcQPD0mJpKE";

    public DetailscafeATT() {
    }

    DetailscafeATT(CafeResto c) {
        toolbar.add(BorderLayout.CENTER, new Label("Détails du caféResto"));

        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));

        Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png"));

        toolbar.add(BorderLayout.EAST, overflowMenu);
        overflowMenu.addPointerPressedListener((e) -> {
            f.getToolbar().getMenuBar().showMenu();
        });
        //   ms.envoyerMail("amal.mabrouk@esprit.tn", "yguhj", "test");

        f.getToolbar().addCommandToOverflowMenu("Contacter l'admin", null,
                (ev) -> {
                    ContacterAdmin cf = new ContacterAdmin();
                    cf.getF().show();
                });

        Button devGuide = new Button("Show PDF");

        libelle = new SpanLabel(c.getLibelle());
        libelle.setTextBlockAlign(Component.CENTER);
        description = new SpanLabel(c.getDescription());
        description.setTextBlockAlign(Component.LEFT);

        numtel = new SpanLabel("Tél. : " + c.getNumtel());
        numtel.setTextBlockAlign(Component.LEFT);

        Button btn = new Button("img");

        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, c.getPhoto(), Layout.URL + c.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        Border border = Border.createLineBorder(1, 0xfe6565/*Color.RED.hashCode()*/);

        description.getAllStyles().setAlignment(Component.LEFT);
        description.getAllStyles().setBorder(border);
        numtel.getAllStyles().setAlignment(Component.LEFT);
        numtel.getAllStyles().setBorder(border);
        Label l = new Label("");
        Label l1 = new Label("");
        Label l2 = new Label("");
        f.setTitle("CafeResto");
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.add(imgV);
        content.add(libelle);
        content.add(description);
        content.add(l);
        content.add(l1);
        content.add(l2);
        content.add(numtel);
        // content.add(btn);

        btn.addActionListener((e) -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        String filePath = (String) ev.getSource();
                        try {
                            imgV.setImage(Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath)));
                        } catch (IOException ex) {
                            System.out.println("yassine");
                        }
                    }
                }

            }, Display.GALLERY_IMAGE);
        });

        devGuide.addActionListener(e -> {
            FileSystemStorage fs = FileSystemStorage.getInstance();
            String fileName = "file:///C:/Users/AMALMA~1/AppData/Local/Temp/Rar$DIa12856.29009/Workshop-API-Symfony.pdf";
            if (!fs.exists(fileName)) {
                Util.downloadUrlToFile("file:///C:/Users/AMALMA~1/AppData/Local/Temp/Rar$DIa12856.29009/Workshop-API-Symfony.pdf", fileName, true);
            }
            Display.getInstance().execute(fileName);
        });

        ShareButton sb = new ShareButton();
        sb.setText("Share Screenshot");
        //   f.add(sb);

        Image screenshot = Image.createImage(f.getWidth(), f.getHeight());
        f.revalidate();
        f.setVisible(true);
        f.paintComponent(screenshot.getGraphics(), true);

        String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
        try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
            ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
        } catch (IOException err) {
            Log.e(err);
        }
        sb.setImageToShare(imageFile, "image/png");

        Button Partage = new Button("partager votre avis sur Facebook");
        TextArea avis = new TextArea("Ajouter votre avis");
        avis.setHint("Ajouter votre avis");

//        content.add(avis);
//        content.add(Partage);
//        
        // content.add(ComponentGroup.enclose(avis ));
        //content.add(Partage);
        Partage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (isEmpty(avis.getText())) {
                    Dialog.show("Avis", "vous devez taper un avis", "OK", null);

                } else {
                    String token = "EAACEdEose0cBAMyoZBWl3J1AlD16yGE3Wlmun7KkjnFQJpr7xxKMeX4g7KST0Y90ElBZCAYjQwAkaHTSDDThoomYulfN8Sg37kIXCZCS5gBIPLoB3WZANGckzVPX9HEXnMsAHeClOR6hQ57YtxrHhqfsotOjwQom94N20rjES9ZAf3qda0f7zNL8bL27s2rESecKe5pJLCmcytp4rofWd";
                    FacebookClient fb = new DefaultFacebookClient(token);
                    FacebookType r = fb.publish("me/feed", FacebookType.class, Parameter.with("message", avis.getText() + "  " + Layout.URL + c.getPhoto()));
                    Dialog.show("Avis", "Votre avis a été partagé avec succés", "OK", null);

                    System.out.println("fb.com" + r.getId());

                }
            }
        });

    }

    public boolean isEmpty(String s) {

        if (s.equals("")) {
            return true;
        }
        return false;
    }
}
