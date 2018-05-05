/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Display;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Produit;
import com.soukelmdina.entite.Rating;
import com.soukelmdina.service.serviceRating;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author TAOUFIK
 */
public class RatingsForm_1 extends Layout {

    public RatingsForm_1(Produit produitav) {
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        f.setTitle("Liste des Ratings");

        f.setLayout(new BorderLayout());
        /**/
        LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("It's time to take a break and look at me");
        n.setAlertTitle("Break Time!");
        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE // Whether to repeat and what frequency
        );
        /**/

        
        ArrayList<HashMap<String, Object>> data = new ArrayList<>();

        Rating[] ratings = new serviceRating().getRatings(produitav.getId());
        for (Rating rating : ratings) {
            data.add(createListEntry(rating.getDescription() , rating.getNom()));
        }

        DefaultListModel<HashMap<String, Object>> model = new DefaultListModel<>(data);
        MultiList ml = new MultiList(model);
        f.add(BorderLayout.CENTER,ml);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
    }

    private HashMap<String, Object> createListEntry(String description, String nom) {
        HashMap<String, Object> entry = new HashMap<>();
        entry.put("Line1", description);
        entry.put("Line2", nom);
        return entry;
    }

}
