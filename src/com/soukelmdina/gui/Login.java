/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.db.Database;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.service.ServiceUtilisateur;
import java.io.IOException;

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
        
        toolbar.add(BorderLayout.CENTER, new Label("Login"));
        
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.add(tlogin);
        content.add(tpassword);
        content.add(btn);
        
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        btn.addActionListener((e) -> {
            ServiceUtilisateur su = new ServiceUtilisateur();
            Utilisateur user = su.getUser(tlogin.getText(), tpassword.getText());
            if (user != null) {
                if (user.getPassword().equals("0")) {
                    Dialog.show("Vérifier votre mot de passe", "Mot de passe invalide", "OK", null);
                } else {
                    MyApplication.user = user;
                    try {
                        MyApplication.db.execute("insert into user (id, solde, etat, email, password, token, numtel, nom, prenom, sexe, role, cin, photo, adresse, ville, codepostal) values ("+user.getId()+","+user.getSolde()+","+user.getEtat()+",'" + user.getMail() +"','" + user.getPassword() +"','" + user.getToken()+"','" + user.getNumTel()+"','" + user.getNom()+"','" + user.getPrenom()+"','" + user.getSexe()+"','" + user.getRole()+"','" + user.getCin()+"','" + user.getPhoto()+"','" + user.getAdresse().getAdresse()+"','" + user.getAdresse().getVille()+"'," + user.getAdresse().getCodePostal()+");");
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    HomeForm home = new HomeForm();
                    home.getF().show();
                }
            } else {
                Dialog.show("Vérifier CIN ou e-mail", "CIN ou e-mail invalide", "OK", null);
            }
        });
    }

}
