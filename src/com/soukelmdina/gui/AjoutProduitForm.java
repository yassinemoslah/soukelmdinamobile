/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
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
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique;
import com.soukelmdina.entite.Categorie;
import com.soukelmdina.entite.Produit;
import com.soukelmdina.entite.Routes;
import static com.soukelmdina.gui.Layout.btq;
import com.soukelmdina.service.ServiceBoutiqueProd;
import com.soukelmdina.service.ServiceCategorie;
import com.soukelmdina.service.serviceProduit;
import java.util.HashMap;

/**
 *
 * @author TAOUFIK
 */


public class AjoutProduitForm extends Layout {

    String path = null;

    public AjoutProduitForm() {
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Label lab = new Label("Nouveau Produit");
        lab.getAllStyles().setFgColor(0xF6E497);

        toolbar.add(BorderLayout.CENTER, lab);

        TextField nomProduit = new TextField("", "Nom Produits", 25, TextArea.ANY);
        TextArea descriptionProduit = new TextArea("..", 100);
        TextField prixProduit = new TextField("", "1234", 4, TextArea.NUMERIC);
        TextField quantiteProduit = new TextField("", "1234", 4, TextArea.NUMERIC);

        EncodedImage enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        URLImage uRLImage = URLImage.createToStorage(enc, Routes.getPhotoProduits() + "/img", Routes.getPhotoProduits() + "/img", URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        content.add(imgV);
        Label gallerie = new Label("Choisir Photo");
        gallerie.getAllStyles().setFgColor(0xB9121B);
        gallerie.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openGallery(e -> {

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

     


        Button submit = new Button("Ajouter");
        Validator v = new Validator();
        v.addConstraint(prixProduit, new NumericConstraint(true, 1.0, 99999.9, "Veuillez verifier"))
                .addConstraint(quantiteProduit, new NumericConstraint(false, 1, 99999, "Veuillez verifier"))
                .addConstraint(nomProduit, new LengthConstraint(1, "Ajouter un nom"))
                .addConstraint(descriptionProduit, new LengthConstraint(1, "Ajouter une description"));
        v.addSubmitButtons(submit);

        Style s1 = UIManager.getInstance().getComponentStyle("TitleCommand");

        FontImage icon30 = FontImage.createMaterial(FontImage.MATERIAL_NAVIGATE_BEFORE, s1);

        Label a = new Label(icon30);
        a.getAllStyles().setBorder(Border.createEmpty());
        a.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);

        toolbar.add(BorderLayout.EAST, a);
        a.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new ListeProduitsByBoutiqueForm(btq).getF().show();
            }
        });
        Container prod = new Container(BoxLayout.x());
        Container px = new Container(BoxLayout.x());
        Container qnt = new Container(BoxLayout.x());
        Container desc = new Container(BoxLayout.x());
        Container cate = new Container(BoxLayout.x());
        Container btk = new Container(BoxLayout.x());
        Label x = new Label("-Libelle: ");
        x.setAlignment(Component.LEFT);
        x.getAllStyles().setFgColor(0x01E8C9);
        prod.add(x).add(nomProduit);
        content.add(prod);

        x = new Label("-Description :");
        x.setAlignment(Component.LEFT);
        x.getAllStyles().setFgColor(0x01E8C9);
        content.add(x);
        content.add(descriptionProduit);

        x.getAllStyles().setFgColor(0x01E8C9);
        x = new Label("-Quantite :");
        x.setAlignment(Component.LEFT);
        x.getAllStyles().setFgColor(0x01E8C9);
        qnt.add(x).add(quantiteProduit);
        content.add(qnt);

        x = new Label("-Prix :");
        x.getAllStyles().setFgColor(0x01E8C9);
        x.setAlignment(Component.LEFT);
        px.add(x).add(prixProduit);
        content.add(px);

        x = new Label("-Categorie :");
        x.getAllStyles().setFgColor(0x01E8C9);
        x.setAlignment(Component.LEFT);
        cate.add(x).add(combocategories);
        content.add(cate);


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
                    int idboutique = btq.getId();
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
                    new ListeProduitsByBoutiqueForm(btq).getF().show();
                }
            }
        });
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
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
        status.setExpires(3000);
        status.show();
    }

}
