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
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.service.ServiceUtilisateur;

/**
 *
 * @author mosla
 */
public class Login extends Layout {

    private TextField tlogin, tpassword;
    private Button btn;

    public Login() {
        tpassword = new TextField();
        tpassword.setHint("Mot de passe");
        tpassword.setConstraint(TextField.PASSWORD);
        tlogin = new TextField();
        tlogin.setHint("E-mail ou CIN");
        btn = new Button("Connexion");
        f.setTitle("Login");
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.add(tlogin);
        f.add(tpassword);
        f.add(btn);
        btn.addActionListener((e) -> {
            ServiceUtilisateur su = new ServiceUtilisateur();
            Utilisateur user = su.getUser(tlogin.getText(), tpassword.getText());
            if (user != null) {
                if (user.getPassword().equals("0")){
                    Dialog.show("Vérifier votre mot de passe", "Mot de passe invalide", "OK", null);
                }else{
                    Layout.user=user;
                }
            } else {
                Dialog.show("Vérifier CIN ou e-mail", "CIN ou e-mail invalide", "OK", null);
            }
        });
    }

}
