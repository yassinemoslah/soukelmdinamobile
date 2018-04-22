/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.soukelmdina.entite.Utilisateur;

/**
 *
 * @author mosla
 */
public class Layout {
      Form f;
      public static String name="yassine";
      public static String URL="http://127.0.0.1"; 
      public static Utilisateur user = null;
    public Layout() {
        f = new Form();
        f.getToolbar().addCommandToSideMenu("Accueil",  null,(e)->{HomeForm home=new HomeForm();
        home.getF().show();});
        f.getToolbar().addCommandToSideMenu("Login",  null,(e)->{Login login=new Login();
        login.getF().show();});
 
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
