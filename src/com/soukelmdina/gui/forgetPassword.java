/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.service.ServiceUtilisateur;
import java.io.IOException;

/**
 *
 * @author mosla
 */
public class forgetPassword extends Layout {

    TextField cle;
    Button btn;
    SpanLabel lbl;

    public forgetPassword(String email) {
        lbl = new SpanLabel("Nous avons envoyé la clé de récupération par E-mail");
        cle = new TextField("", "Clé de récupération");
        btn = new Button("Récupérer votre compte");
       
        
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_3.jpg"));
        content.add(lbl);
        content.add(cle);
        main.add(btn);
        //content.add(new Label("Annuler"));
         btn.addActionListener((e)->{
            ServiceUtilisateur su = new ServiceUtilisateur();
            Utilisateur user = su.getUser(email, "pass");
            if (user != null) {
                if (!user.getToken().equals(cle.getText())) {
                    Dialog.show("Vérifier votre clé", "Clé incorrecte", "OK", null);
                } else {
                    MyApplication.user = user;
                    try {
                        MyApplication.db.execute("insert into user (id, solde, etat, email, password, token, numtel, nom, prenom, sexe, role, cin, photo, adresse, ville, codepostal) values (" + user.getId() + "," + user.getSolde() + "," + user.getEtat() + ",'" + user.getMail() + "','" + user.getPassword() + "','" + user.getToken() + "','" + user.getNumTel() + "','" + user.getNom() + "','" + user.getPrenom() + "','" + user.getSexe() + "','" + user.getRole() + "','" + user.getCin() + "','" + user.getPhoto() + "','" + user.getAdresse().getAdresse() + "','" + user.getAdresse().getVille() + "'," + user.getAdresse().getCodePostal() + ");");
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    recupPassword rp = new recupPassword();
                    rp.getF().show();
                }
            } else {
                Dialog.show("Vérifier CIN ou e-mail", "CIN ou e-mail invalide", "OK", null);
            }
        });
    }

}
