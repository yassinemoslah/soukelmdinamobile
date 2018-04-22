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
 * @author mosla
 */
public class Layout {
      Form f;

    public Layout() {
        f = new Form();
        f.getToolbar().addCommandToSideMenu("Home",  null,(e)->{System.out.println("yes");});
 
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
