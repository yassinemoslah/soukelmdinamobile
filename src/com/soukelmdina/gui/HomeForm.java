/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author sana
 */
public class HomeForm extends Layout {

    public HomeForm() {
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        toolbar.add(BorderLayout.CENTER, new Label("Accueil"));
        Label lbl = new Label("Welcome to Souk El Mdina");

        content.add(lbl);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_3.jpg"));

    }

}
