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
import com.soukelmdina.technique.SpanLabel1;
import com.soukelmdina.technique.controleSaisie;

/**
 *
 * @author mosla
 */
public class recupPassword extends Layout {

    TextField password, password1;
    Button btn;
    SpanLabel1 erreurPassword, erreurPassword1;

    public recupPassword() {
        erreurPassword = new SpanLabel1();
        erreurPassword.setVisible(false);
        erreurPassword1 = new SpanLabel1();
        erreurPassword1.setVisible(false);
        erreurPassword.setUIID("RedLabel");
        erreurPassword1.setUIID("RedLabel");
        password = new TextField("", "Nouveau mot de passe");
        password1 = new TextField("", "Répeter le nouveau mot de passe");
        password.setConstraint(TextField.PASSWORD);
        password1.setConstraint(TextField.PASSWORD);
        btn = new Button("Modifier");

        btn.addActionListener((e) -> {
            if (!controle()){
            ServiceUtilisateur su = new ServiceUtilisateur();
            su.updatePassword(password.getText());
            HomeForm home = new HomeForm();
            home.getF().show();
            }
        });

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        content.add(password);
        content.add(erreurPassword);
        content.add(password1);
        content.add(erreurPassword1);
        main.add(btn);

    }

    private boolean controle() {
        erreurPassword.setVisible(false);
        erreurPassword1.setVisible(false);

        boolean verif = false;
        controleSaisie ctrl = new controleSaisie();

        if (ctrl.controleTextFieldVide(password.getText())) {
            erreurPassword.setText("Saisir le nouveau mot de passe");
            erreurPassword.setVisible(true);
            verif = true;
        } else if (password.getText().length() < 8) {
            erreurPassword.setText("Le MDP doit au moins contenir 8 caractères.");
            erreurPassword.setVisible(true);
            verif = true;
        } else if (ctrl.controleComplexiteMDP(password.getText())) {
            erreurPassword.setText("Le MDP doit contenir des lettres miniscules, majuscules et des chiffres");
            erreurPassword.setVisible(true);
            verif = true;
        }

        if (ctrl.controleTextFieldVide(password1.getText())) {
            erreurPassword1.setText("Retaper le nouveau mot de passe");
            erreurPassword1.setVisible(true);
            verif = true;
        } else if (!password.getText().equals(password1.getText())) {
            erreurPassword1.setText("Les 2 mot de passes ne sont pas identiques");
            erreurPassword1.setVisible(true);
            verif = true;
        }
        f.revalidate();
        return verif;
    }
}
