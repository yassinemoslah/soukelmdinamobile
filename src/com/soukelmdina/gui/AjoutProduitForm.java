/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique;
import com.soukelmdina.entite.Categorie;
import com.soukelmdina.entite.Produit;
import com.soukelmdina.service.ServiceBoutiqueProd;
import com.soukelmdina.service.ServiceCategorie;
import com.soukelmdina.service.serviceProduit;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author TAOUFIK
 */
public class AjoutProduitForm extends Layout {

    String path = null;

    public AjoutProduitForm() {
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        toolbar.add(BorderLayout.CENTER, new Label("Nouveau produit"));

        TextField nomProduit = new TextField("", "Nom Produits", 25, TextArea.ANY);
        nomProduit.getSelectedStyle().setFgColor(0xfff/*Color.BLUE.hashCode()*/);
        TextArea descriptionProduit = new TextArea("", 255);
        TextField prixProduit = new TextField("", "1234", 4, TextArea.NUMERIC);
        TextField quantiteProduit = new TextField("", "1234", 4, TextArea.NUMERIC);

        EncodedImage enc;
        URLImage uRLImage;
        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, MyApplication.user.getPhoto(), Layout.URL + MyApplication.user.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        content.add(imgV);
        Label gallerie = new Label("Choisir Photo");
        gallerie.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openGallery(e -> {
                    System.err.println("1");
                    if (e == null || e.getSource() == null) {
                        showToast("Gallerie fermée");
                        return;
                    }
                    path = (String) e.getSource();
                    setImage(path, imgV);
                }, Display.GALLERY_IMAGE);
            }
        });
        content.add(gallerie);

        ComboBox<HashMap<String, Object>> combocategories = new ComboBox<>();

        Categorie[] categories = new ServiceCategorie().getCtegories();

        for (Categorie category : categories) {
            combocategories.addItem(createListEntry(category.getLibelle(), category.getId()));
        }

        combocategories.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));

        ComboBox<HashMap<String, Object>> comboboutiques = new ComboBox<>();

        Boutique[] boutiques = new ServiceBoutiqueProd().getboutiques();

        for (Boutique boutique : boutiques) {
            comboboutiques.addItem(createListEntry(boutique.getNomBoutique(), boutique.getId()));
        }

        comboboutiques.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));

        Button submit = new Button("Ajouter");
        Validator v = new Validator();
        v.addConstraint(prixProduit, new NumericConstraint(true, 1.0, 99999.9, "Veuillez verifier"))
                .addConstraint(quantiteProduit, new NumericConstraint(false, 1, 99999, "Veuillez verifier"))
                .addConstraint(nomProduit, new LengthConstraint(1, "Ajouter un nom"))
                .addConstraint(descriptionProduit, new LengthConstraint(1, "Ajouter une description"));
        v.addSubmitButtons(submit);

        ImageViewer l = new ImageViewer();

        Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png"));

        f.getToolbar().addCommandToOverflowMenu("Retour à la list ", null, (ev) -> {
            new ListeProduitsByBoutiqueForm(btq);
        });
        f.getToolbar().addCommandToOverflowMenu("Gallerie", null, (ev) -> {
            Display.getInstance().openGallery(e -> {
                if (e == null || e.getSource() == null) {
                    showToast("Gallerie fermée");
                    return;
                }
                path = (String) e.getSource();
                setImage(path, imgV);
            }, Display.GALLERY_IMAGE);
        });
        overflowMenu.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    f.getToolbar().getMenuBar().showMenu();
                } catch (Exception e) {

                }
            }
        });

        toolbar.add(BorderLayout.EAST, overflowMenu);

        Container prod = new Container(BoxLayout.x());
        Container px = new Container(BoxLayout.x());
        Container qnt = new Container(BoxLayout.x());
        Container desc = new Container(BoxLayout.x());
        Container cate = new Container(BoxLayout.x());
        Container btk = new Container(BoxLayout.x());
        Label x = new Label("Nom Produits");
        x.setAlignment(Component.LEFT);
        x.getAllStyles().setFgColor(0x01E8C9);
        prod.add(x).add(nomProduit);
        content.add(prod);

        x = new Label("Description :");
        x.setAlignment(Component.LEFT);
        x.getAllStyles().setFgColor(0x01E8C9);
        content.add(x);
        content.add(descriptionProduit);

        x.getAllStyles().setFgColor(0x01E8C9);
        x = new Label("Quantite :");
        x.setAlignment(Component.LEFT);
        x.getAllStyles().setFgColor(0x01E8C9);
        qnt.add(x).add(quantiteProduit);
        content.add(qnt);

        x = new Label("Prix :");
        x.getAllStyles().setFgColor(0x01E8C9);
        x.setAlignment(Component.LEFT);
        px.add(x).add(prixProduit);
        content.add(px);

        x = new Label("Categorie :");
        x.getAllStyles().setFgColor(0x01E8C9);
        x.setAlignment(Component.LEFT);
        cate.add(x).add(combocategories);
        content.add(cate);

        x = new Label("Boutique :");
        x.getAllStyles().setFgColor(0x01E8C9);
        x.setAlignment(Component.LEFT);
        btk.add(x).add(comboboutiques);
        content.add(btk);
        Button reset = new Button("Annuler");
        Container cn = new Container(BoxLayout.x());
        cn.add(reset).add(submit);
        content.addComponent(cn);

        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                nomProduit.setText("");
                descriptionProduit.setText("");
                quantiteProduit.setText("");
                prixProduit.setText("");
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (path == null) {
                    Dialog.show("Il faut choisir une photo !", "Veuillez choisir une photo", "OK", null);
                } else {
                    int idboutique = (int) comboboutiques.getModel().getItemAt(comboboutiques.getModel().getSelectedIndex()).get("id");
                    int idcategorie = (int) combocategories.getModel().getItemAt(combocategories.getModel().getSelectedIndex()).get("id");
                    Produit produitSave = new Produit();
                    produitSave.setLibelle(nomProduit.getText());
                    produitSave.setDescription(descriptionProduit.getText());
                    produitSave.setPrix(Float.parseFloat(prixProduit.getText()));
                    produitSave.setQuantite(Integer.parseInt(quantiteProduit.getText()));
                    produitSave.setIdboutique(idboutique);
                    produitSave.setIdcategorie(idcategorie);
                    showToast("Enregistrement de votre produit ... Merci!");
                    new serviceProduit().ajouterProduit(path, produitSave);
                    new ListeBoutiqueProd().getF().show();
                }
            }
        });
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    }

    private HashMap<String, Object> createListEntry(String libelle, int id) {
        HashMap<String, Object> entry = new HashMap<>();
        entry.put("Line1", libelle);
        entry.put("id", id);
        return entry;
    }

    private void setImage(String filePath, ImageViewer iv) {
        try {
            Image i1 = Image.createImage(filePath);
            i1.scale(70, 70);
            iv.setImage(i1);
            iv.getParent().revalidate();
        } catch (Exception ex) {
            Log.e(ex);
            Dialog.show("Error", "Error during image loading: " + ex, "OK", null);
        }
    }

    private void showToast(String text) {
        Image errorImage = FontImage.createMaterial(FontImage.MATERIAL_ERROR, UIManager.getInstance().getComponentStyle("Title"), 4);
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage(text);
        status.setIcon(errorImage);
        status.setExpires(2000);
        status.show();
    }

}
