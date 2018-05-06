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
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.service.ServiceUtilisateur;
import com.soukelmdina.technique.controleSaisie;
import java.io.IOException;

/**
 *
 * @author mosla
 */
public class Login extends Layout {

    private TextField tlogin, tpassword;
    private Button btn;
    private Label inscription, forgetPassword, erreurLogin, erreurPassword;

    public Login() {
        erreurLogin = new Label();
        erreurLogin.setVisible(false);
        erreurLogin.setUIID("RedLabel");
        erreurPassword = new Label();
        erreurPassword.setVisible(false);
        erreurPassword.setUIID("RedLabel");

        ServiceUtilisateur su = new ServiceUtilisateur();
        tpassword = new TextField();
        tpassword.setHint("Mot de passe");
        tpassword.setConstraint(TextField.PASSWORD);
        tlogin = new TextField();
        tlogin.setHint("E-mail ou CIN");
        btn = new Button("Connexion");
        inscription = new Label("S'inscrire");
        inscription.addPointerPressedListener((e) -> {
            Inscription ins = new Inscription();
            ins.getF().show();
        });

        forgetPassword = new Label("Mot de passe oublié ?");
        forgetPassword.addPointerPressedListener((e) -> {
            if (!controle(2)) {
                su.sendKey(tlogin.getText());
                forgetPassword rp = new forgetPassword(tlogin.getText());
                rp.getF().show();
            }
        });
        toolbar.add(BorderLayout.CENTER, new Label("Login"));

        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        content.add(new Label(" "));
        content.add(new Label(" "));
        content.add(tlogin);
        content.add(erreurLogin);
        content.add(tpassword);
        content.add(erreurPassword);
        content.add(btn);
        content.add(forgetPassword);
        content.add(inscription);

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        btn.addActionListener((e) -> {
            if (!controle(1)) {

                Utilisateur user = su.getUser(tlogin.getText(), tpassword.getText());
                if (user != null) {
                    if (user.getPassword().equals("0")) {
                        Dialog.show("Vérifier votre mot de passe", "Mot de passe invalide", "OK", null);
                    } else if (user.getEtat() == 0) {
                        confirmationAccount ca = new confirmationAccount(user.getMail());
                        ca.getF().show();
                    } else {
                        MyApplication.user = user;
                        try {
                            MyApplication.db.execute("insert into user (id, solde, etat, email, password, token, numtel, nom, prenom, sexe, role, cin, photo, adresse, ville, codepostal) values (" + user.getId() + "," + user.getSolde() + "," + user.getEtat() + ",'" + user.getMail() + "','" + user.getPassword() + "','" + user.getToken() + "','" + user.getNumTel() + "','" + user.getNom() + "','" + user.getPrenom() + "','" + user.getSexe() + "','" + user.getRole() + "','" + user.getCin() + "','" + user.getPhoto() + "','" + user.getAdresse().getAdresse() + "','" + user.getAdresse().getVille() + "'," + user.getAdresse().getCodePostal() + ");");
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                        HomeForm home = new HomeForm();
                        home.getF().show();
                    }
                } else {
                    Dialog.show("Vérifier CIN ou e-mail", "CIN ou e-mail n'appartient à aucun compte", "OK", null);
                }
            }
        });
    }

    private boolean controle(int n) {
        erreurLogin.setVisible(false);
        erreurPassword.setVisible(false);

        boolean verif = false;
        controleSaisie ctrl = new controleSaisie();

        if (ctrl.controleTextFieldVide(tlogin.getText())) {
            erreurLogin.setText("Saisir votre e-mail ou CIN");
            erreurLogin.setVisible(true);
            verif = true;
        } else if (ctrl.controleMailFormat(tlogin.getText()) && (ctrl.controleTextFieldChiffres(tlogin.getText()) || tlogin.getText().length() != 8) || tlogin.getText().equals("00000000")) {
            erreurLogin.setText("Saisir un e-mail ou CIN valide");
            erreurLogin.setVisible(true);
            verif = true;
        }

        if (n == 1) {
            if (ctrl.controleTextFieldVide(tpassword.getText())) {
                erreurPassword.setText("Saisir votre mot de passe");
                erreurPassword.setVisible(true);
                verif = true;
            }
        }
        f.revalidate();
        return verif;
    }
}
