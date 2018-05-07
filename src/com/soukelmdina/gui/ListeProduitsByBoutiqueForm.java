/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ToastBar;
import com.codename1.io.Storage;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique;
import com.soukelmdina.entite.Produit;
import com.soukelmdina.entite.Routes;
import com.soukelmdina.service.serviceProduit;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author TAOUFIK
 */
public class ListeProduitsByBoutiqueForm extends Layout {

    public Produit[] produits = null;

    public ListeProduitsByBoutiqueForm(Boutique boutique) {
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        toolbar.add(BorderLayout.CENTER, new Label("Liste des Produits "));

        f.removeComponent(main);
        main.removeComponent(toolbar);
        f.add(toolbar);

        int mm = Display.getInstance().convertToPixels(4);
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 4, mm * 3, 0), false);

        ArrayList<HashMap<String, Object>> data = new ArrayList<>();

        Produit[] produits = new serviceProduit().getProduitsBoutique(boutique);
        Routes routes = new Routes();
        for (Produit produit : produits) {
            Storage.getInstance().deleteStorageFile(produit.getPhoto());
            Image icon = URLImage.createToStorage(placeholder, produit.getPhoto(), routes.getPhotoProduits() + "/" + produit.getPhoto());
            data.add(createListEntry(produit.getLibelle(), "" + produit.getPrix(), icon, produit.getId()));

        }

        DefaultListModel<HashMap<String, Object>> model = new DefaultListModel<>(data);
        MultiList ml = new MultiList(model);
        // ml.getStyle().setBgColor(0x01E8C9);
        ml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                int i = ml.getSelectedIndex();

                ToastBar.Status status = ToastBar.getInstance().createStatus();
                status.setMessage("produit" + produits[i].getId());
                status.setExpires(2000);
                status.show();

                new ProduitForm(produits[i]).getF().show();

            }
        });

        Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png"));
        f.getToolbar().addCommandToOverflowMenu("Revenir", null, (ev) -> {
            new ListeBoutiqueProd().getF().show();
        });
        toolbar.add(BorderLayout.EAST, overflowMenu);
        overflowMenu.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    f.getToolbar().getMenuBar().showMenu();
                } catch (Exception e) {

                }
            }
        });

        Container c = new Container(new BorderLayout());

        //ml.getStyle().setBgColor(0x01E8C9);
        ml.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));

        c.add(BorderLayout.CENTER, ml);
        c.setScrollableY(true);

        main.removeComponent(content);

        c.setScrollable(false);
        content.setScrollable(false);
        f.setScrollable(false);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
        //content.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));

        f.add(c);
    }

    private HashMap<String, Object> createListEntry(String libelle, String prix, Image icon, int id) {
        HashMap<String, Object> entry = new HashMap<>();
        entry.put("Line1", libelle);
        entry.put("Line2", prix + " DT");
        entry.put("id", id);
        entry.put("icon", icon);
        return entry;
    }

}
