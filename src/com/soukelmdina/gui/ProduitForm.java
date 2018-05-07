/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.Accordion;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.Slider;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.ComponentAnimation;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.soukelmdina.app.MyApplication;
import static com.soukelmdina.app.MyApplication.user;
import com.soukelmdina.entite.Categorie;
import com.soukelmdina.entite.CommandeProduit;
import com.soukelmdina.entite.Produit;
import com.soukelmdina.entite.Rating;
import com.soukelmdina.entite.Routes;
import com.soukelmdina.service.ServiceCategorie;
import com.soukelmdina.service.serviceProduit;
import com.soukelmdina.service.serviceRating;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TAOUFIK
 */
public class ProduitForm extends Layout {

    Label panier = new Label();

    public ProduitForm(Produit produit) {

        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        toolbar.add(BorderLayout.CENTER, new Label(produit.getLibelle()));

        Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png"));

        Style s1 = UIManager.getInstance().getComponentStyle("TitleCommand");
        s1.setBgColor(0xfff/*Color.AQUA.hashCode()*/);
        FontImage icon30 = FontImage.createMaterial(FontImage.MATERIAL_EDIT, s1);
        FontImage icon2 = FontImage.createMaterial(FontImage.MATERIAL_PHOTO, s1);
        FontImage icon22 = FontImage.createMaterial(FontImage.MATERIAL_NAVIGATE_BEFORE, s1);

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

        if (MyApplication.user != null) {
            if (MyApplication.user.getRole().equals("Vendeur"));
            f.getToolbar().addCommandToOverflowMenu("Editer Détail", icon30, (ev) -> {
                new EditerProduitForm(produit).getF().show();
            });

        }

        f.getToolbar().addCommandToOverflowMenu("Revenir", icon22, (ev) -> {
            new ListeProduitsByBoutiqueForm(btq).getF().show();
        });

        //Toolbar.setGlobalToolbar(false);
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(f.getWidth(), f.getHeight(), 0xffff0000), true);

        Routes routes = new Routes();

        ComponentAnimation title = f.getToolbar().getTitleComponent().createStyleAnimation("Title", 200);
        f.getAnimationManager().onTitleScrollAnimation(title);

        Tabs t = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
        FontImage icon1 = FontImage.createMaterial(FontImage.MATERIAL_CAMERA_FRONT, s);
        FontImage icon3 = FontImage.createMaterial(FontImage.MATERIAL_CARD_GIFTCARD, s);
        FontImage icon6 = FontImage.createMaterial(FontImage.MATERIAL_RATE_REVIEW, s);

        Container container1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        Button bedit = new Button("Editer");
        bedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new EditerProduitForm(produit).getF().show();
            }
        });

        String categorie = produit.getCategorie().getLibelle();

        Border border = Border.createLineBorder(1, 0xfff/*Color.BLUE.hashCode()*/);
        Label desc = new Label("Description :");
        desc.getAllStyles().setAlignment(Component.LEFT);
        container1.add(desc);
        SpanLabel descval = new SpanLabel(produit.getDescription());
        descval.getAllStyles().setAlignment(Component.LEFT);
        descval.getAllStyles().setBorder(border);
        container1.add(descval);
        Label categ = new Label("Categorie :");
        categ.getAllStyles().setFgColor(0xff000);

        categ.getAllStyles().setAlignment(Component.LEFT);
        container1.add(categ);
        Label categval = new Label(categorie);
        categval.getAllStyles().setBorder(border);
        container1.add(categval);
        Label prix = new Label("Prix :");
        prix.getAllStyles().setAlignment(Component.LEFT);
        container1.add(prix);
        Label prixval = new Label(produit.getPrix() + " DT");
        prixval.getAllStyles().setBorder(border);
        container1.add(prixval);
        prix.getAllStyles().setFgColor(0x01E8C9);
        desc.getAllStyles().setFgColor(0x01E8C9);
        categ.getAllStyles().setFgColor(0x01E8C9);

        int deviceWidth = Display.getInstance().getDisplayWidth();
        ImageViewer l = new ImageViewer();
        EncodedImage placeholderview = EncodedImage.createFromImage(Image.createImage(deviceWidth, deviceWidth, 0xffff0000), true);

        Storage.getInstance().deleteStorageFile(produit.getPhoto());
        Image image = URLImage.createToStorage(placeholderview, produit.getPhoto(),
                routes.getPhotoProduits() + "/" + produit.getPhoto());

        l.setImage(image);

        Container container5 = new Container(new BorderLayout());
        Container container6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container container7 = new Container(new BorderLayout());

        Slider slider = createStarRankSlider();
        TextField ratingdesc = new TextField("", "ERCRIRE UN AVIS", 20, TextArea.ANY);
        if (MyApplication.user != null) {
            if (MyApplication.user.getRole().equals("Client")) {

                container6.add(ratingdesc);
                container6.add(FlowLayout.encloseCenter(slider));

                Button addavis = new Button("Ajouter");
                addavis.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (ratingdesc.getText().equals("") || ratingdesc.getText().equals(null)) {
                            Dialog.show("Il faut entrer votre avis !", "Veuillez saisir un texte", "OK", null);
                        } else {
                            Rating rating = new Rating();
                            rating.setDescription(ratingdesc.getText());
                            rating.setEtoiles(slider.getProgress());
                            showToast("Enregistrement de votre avis ... Merci!");
                            new serviceRating().addAvis(produit, 2, rating);
                            new ProduitForm(produit).getF().show();

                        }
                    }
                });
                container6.add(addavis);
            }
        }

        Container container8 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Rating[] ratings = new serviceRating().getRatings(produit.getId());
        if (ratings.length == 0) {
            container8.add(new SpanLabel("Auccun Avis"));
        }
        ArrayList<HashMap<String, Object>> dataavis = new ArrayList<>();
        Container container9 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        for (Rating rating : ratings) {
            Container item = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            item.getAllStyles().setBorder(border);
            Label x = new Label(rating.getDescription());
            x.getAllStyles().setAlignment(Component.LEFT);
            x.getAllStyles().setMarginTop(0);
            x.getAllStyles().setMarginBottom(0);
            x.getAllStyles().setPaddingTop(0);
            x.getAllStyles().setPaddingBottom(0);
            item.add(x);
            Label y = new Label(rating.getNom());
            y.getAllStyles().setAlignment(Component.LEFT);
            y.getAllStyles().setMarginTop(0);
            y.getAllStyles().setMarginBottom(0);
            y.getAllStyles().setPaddingTop(0);
            y.getAllStyles().setPaddingBottom(0);
            item.add(y);
            Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                    derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);

            Style ss = new Style(0xffff33, 0, fnt, (byte) 0);
            Container starcontainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            starcontainer.getAllStyles().setMarginTop(0);
            starcontainer.getAllStyles().setMarginBottom(0);
            starcontainer.getAllStyles().setPaddingTop(0);
            starcontainer.getAllStyles().setPaddingBottom(0);
            for (int i = 0; i < rating.getEtoiles(); i++) {
                Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, ss).toImage();
                starcontainer.add(fullStar);
            }
            item.add(starcontainer);
            item.getAllStyles().setBgColor(0xfff/*Color.WHITE.hashCode()*/, true);
            container9.add(item);
            dataavis.add(listeavis(rating.getDescription(), rating.getNom(), rating.getEtoiles()));
        }
        //
        container9.setScrollable(true);
        container9.getAllStyles().setBgColor(0xfff/*Color.WHITE.hashCode()*/, true);
        container9.getAllStyles().setBgTransparency(100);
        container8.add(container9);
        container8.getAllStyles().setBgColor(0xfff/*Color.WHITE.hashCode()*/, true);

        container6.add(container8);

        container5.add(BorderLayout.NORTH, l);
        t.addTab("Détails", icon3, container1);
        t.addTab("Photos", icon1, container5);
        t.addTab("Avis", icon6, container6);

        // t.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
        Container cfinal = new Container();

        cfinal.setLayout(new BorderLayout());
        cfinal.add(BorderLayout.CENTER, t);

        content.add(cfinal);
        //content.setScrollableY(true);
        container8.setScrollable(false);
        content.setScrollable(false);
        f.setScrollable(false);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        t.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
      
        panier.setIcon(MyApplication.theme.getImage("panier.png"));
        panier.setText("Ajouter au panier");
if(MyApplication.user.getRole().equals("Client"))
        f.add(panier);
        panier.addPointerPressedListener((act) -> {
            int verif = 0;
            for (int i = 0; i < MyApplication.listeCommandep.size(); i++) {
                if (MyApplication.listeCommandep.get(i).getIdproduit() == produit.getId()) {
                    verif = 1;
                    if (MyApplication.listeCommandep.get(i).getQte() < produit.getQuantite()) {

                        MyApplication.listeCommandep.get(i).setQte(MyApplication.listeCommandep.get(i).getQte() + 1);
                        Dialog.show("Panier!!", "Produit ajouté au panier ", "OK", null);

                    } else {
                        Dialog.show("Quantité indisponible!!", "Vous avez dépassez la quantité disponible", "OK", null);

                    }

                }
            }
            if (verif == 0) {
                CommandeProduit cmp = new CommandeProduit();
                cmp.setIdproduit(produit.getId());
                cmp.setPhoto(produit.getPhoto());
                cmp.setQte(1);
                cmp.setPrix(produit.getPrix());
                MyApplication.listeCommandep.add(cmp);
                Dialog.show("Panier!!", "Produit ajouté au panier ", "OK", null);
            }

            System.out.println("men houné " + MyApplication.listeCommandep.toString());

        });

    }

//-- DON'T EDIT ABOVE THIS LINE!!!
    private Map<String, Object> createListEntry(String name, String desc) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", desc);
        return entry;
    }

    private Map<String, Object> createListEntry2(String name, String val) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", new SpanLabel(val));
        return entry;
    }

    private Map<String, Object> createListEntryFidelite(String name, String code, String date) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", code);
        entry.put("Line3", date);
        return entry;
    }

    private Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(5);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        return starRank;
    }

    private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }

    private HashMap<String, Object> createListEntryRating(String description, String nom) {
        HashMap<String, Object> entry = new HashMap<>();
        entry.put("Line1", description);
        entry.put("Line2", nom);
        return entry;
    }

    private void showToast(String text) {
        Image errorImage = FontImage.createMaterial(FontImage.MATERIAL_ERROR, UIManager.getInstance().getComponentStyle("Title"), 4);
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage(text);
        status.setIcon(errorImage);
        status.setExpires(2000);
        status.show();
    }

    private HashMap<String, Object> listeavis(String description, String nom, int stars) {
        HashMap<String, Object> entry = new HashMap<>();
        entry.put("Line1", description);
        entry.put("Line2", nom);

        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);

        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        entry.put("icon", fullStar);
        entry.put("Line3", stars + " etoiles");
        return entry;
    }

}
