/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.service.ServiceUtilisateur;

/**
 *
 * @author mosla
 */
public class updatePassword extends Layout {

    TextField password, password1, ancienPassword;
    Button btn;

    public updatePassword() {
        ancienPassword = new TextField("", "Votre mot de passe actuel");
        password = new TextField("", "Nouveau mot de passe");
        password1 = new TextField("", "Répeter le nouveau mot de passe");
        ancienPassword.setConstraint(TextField.PASSWORD);
        password.setConstraint(TextField.PASSWORD);
        password1.setConstraint(TextField.PASSWORD);
        btn = new Button("Modifier");

        btn.addActionListener((e) -> {
            ServiceUtilisateur su = new ServiceUtilisateur();
            Utilisateur user = su.getUser(MyApplication.user.getMail(), ancienPassword.getText());
            if (user.getPassword().equals("0")) {
                Dialog.show("Vérifier votre mot de passe", "Mot de passe actuel invalide", "OK", null);
            } else {
                su.updatePassword(password.getText());
                HomeForm home = new HomeForm();
                home.getF().show();
            }
        });

        toolbar.add(BorderLayout.CENTER, new Label("Modifier mon mot de passe"));

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        content.add(ancienPassword);
        content.add(password);
        content.add(password1);
        main.add(btn);
    }

}
