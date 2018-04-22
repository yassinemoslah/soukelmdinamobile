/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.ui.Form;
import com.codename1.ui.Label;

/**
 *
 * @author sana
 */
public class HomeForm {

    Form f;

    public HomeForm() {
        f = new Form("home");
        f.add(new Label("Welcome to Souk El Mdina"));
 
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
