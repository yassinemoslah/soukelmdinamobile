/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.ui.Button;
import com.codename1.ui.TextField;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.service.ServiceUtilisateur;

/**
 *
 * @author mosla
 */
public class recupPassword extends Layout{
    TextField password, password1;
    Button btn;

    public recupPassword() {
        password = new TextField("", "Nouveau mot de passe");
        password1 = new TextField("", "Répeter le nouveau mot de passe");
        password.setConstraint(TextField.PASSWORD);
        password1.setConstraint(TextField.PASSWORD);
        btn = new Button("Modifier");
        
        btn.addActionListener((e)->{
            ServiceUtilisateur su = new ServiceUtilisateur();
            su.updatePassword(password.getText());
            HomeForm home = new HomeForm();
            home.getF().show();
        });
        
       f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
       content.add(password);
       content.add(password1);
       main.add(btn);

    }
    
    
}
