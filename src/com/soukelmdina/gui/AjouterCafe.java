/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.NumericSpinner;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.service.ServiceCafeResto;
import com.soukelmdina.technique.controleSaisie;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amal Mabrouk
 */
public class AjouterCafe extends Layout {

    TextField libelle, description, numtel;
    TextField tetat;
    Button btnajout, btn;
    EncodedImage enc;
    URLImage uRLImage;
    Label erreurLibelle, erreurDescription, erreurnumtel, erreurPhoto, erreurSouk;
    String photo = "nophoto";
    private byte[] bytesdata;

    List<Souk> li = new ArrayList<>();
    int idsouk = 0;

    public AjouterCafe() {
        toolbar.add(BorderLayout.CENTER, new Label("Ajouter CafeResto"));
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));

        libelle = new TextField();
        description = new TextField();
        numtel = new TextField();
        libelle.setHint("nom du CafeResto");
        description.setHint("Description");
        numtel.setHint("Numéro ");
        erreurLibelle = new Label();
        erreurLibelle.setVisible(false);
        erreurDescription = new Label();
        erreurDescription.setVisible(false);
        erreurnumtel = new Label();
        erreurnumtel.setVisible(false);
        erreurPhoto = new Label();
        erreurPhoto.setVisible(false);
        Label lbl = new Label("Ajouter une image ");
        erreurLibelle.setVisible(false);
        erreurDescription.setVisible(false);
        erreurnumtel.setVisible(false);
        erreurPhoto.setVisible(false);

        Container container = new Container();
        container.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));

        btnajout = new Button("ajouter");
        //   btn = new Button("image");

        ServiceCafeResto sc = new ServiceCafeResto();
        CafeResto c = new CafeResto();
        Image red = Image.createImage(180, 180, 0xffff0000);

        enc = EncodedImage.createFromImage(red, false);
        uRLImage = URLImage.createToStorage(enc, "imgvide.png", Layout.URL + "/imgvide.png", URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Label l = new Label("");
        container.add(BorderLayout.CENTER, lbl);

        String[] tabsouks = new String[2];
        List<String> souks = new ArrayList<>();
        ServiceCafeResto se = new ServiceCafeResto();
        li = se.getnomssouks();
        for (Souk ee : li) {

            souks.add(ee.getLibelle());
        }
        for (int i = 0; i < souks.size(); i++) {
            tabsouks[i] = souks.get(i);
        }

        Picker p = new Picker();
        erreurSouk = new Label();
        erreurSouk.setVisible(false);
        p.setName("souk");
        p.setStrings(tabsouks);
//fab.bindFabToContainer(content.getContentPane());

        content.add(imgV);
        content.add(erreurPhoto);
        erreurPhoto.setUIID("RedLabel");

        content.add(container);
        content.add(libelle);
        content.add(erreurLibelle);
        erreurLibelle.setUIID("RedLabel");
        content.add(l);
        content.add(description);
        content.add(erreurDescription);
        erreurDescription.setUIID("RedLabel");
        content.add(numtel);
        content.add(erreurnumtel);
        erreurnumtel.setUIID("RedLabel");
        content.add(p);
        content.add(erreurSouk);
        erreurSouk.setUIID("RedLabel");

        content.add(btnajout);
        btnajout.addActionListener((e) -> {

            //   p.setSelectedString("Souk");
            for (int i = 0; i < li.size(); i++) {
                System.out.println("value  " + p.getValue());
                System.out.println("value mta3 li  " + li.get(i).getId());

                if (li.get(i).getLibelle().equals(p.getValue())) {
                    System.out.println("mawjoud");

                    idsouk = li.get(i).getId();
                }
            }

            System.out.println("id souk" + idsouk);

            if (controle() == true) {
                c.setLibelle(libelle.getText());
                c.setDescription(description.getText());
                c.setNumtel(numtel.getText());
                c.setAccept(0);
                c.setIdSouk(idsouk);
                c.setPhoto(photo);
                c.setIdprprio(MyApplication.user.getId());
                System.out.println("id proprio" + c.getIdprprio());
                sc.AjouterCafe(c, bytesdata);
                Dialog.show("Ajout", "Ajout avec succés", "OK", null);

                ListeCafeRestoVendeur lc = new ListeCafeRestoVendeur();

                lc.f.show();

            }

        });

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
        if (idsouk == 0) {
            erreurSouk.setVisible(true);
            erreurSouk.setText("choisissez un souk");
            verif = false;

        }
        if (idsouk != 0) {
            erreurSouk.setVisible(false);

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

    boolean isEmpty(String s) {

        if (s.equals("")) {
            return true;
        }
        return false;
    }
}
