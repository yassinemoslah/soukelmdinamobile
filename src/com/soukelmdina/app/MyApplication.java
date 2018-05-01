package com.soukelmdina.app;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.entite.Adresse;
import com.soukelmdina.entite.Utilisateur;
import com.soukelmdina.gui.HomeForm;
import com.soukelmdina.gui.Layout;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename
 * One</a> for the purpose of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    public static Resources theme;
    public static Database db;
    public static Utilisateur user = null;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        try {
            Boolean test = Database.exists("pidev.db");
            db = Database.openOrCreate("pidev.db");
            if (!test) {
                db.execute("create table user (id INTEGER, solde REAL, etat INTEGER, email TEXT, password TEXT, token TEXT, numtel TEXT, nom TEXT, prenom TEXT, sexe TEXT, role TEXT, cin TEXT, photo TEXT, adresse TEXT, ville TEXT, codepostal INTEGER);");
            }
            Cursor cur = db.executeQuery("select * from user");
            while (cur.next()) {
                user = new Utilisateur();
                user.setAdresse(new Adresse());
                
                Row row = cur.getRow();
                user.setId(row.getInteger(0));
                user.setSolde(row.getDouble(1));
                user.setEtat(row.getInteger(2));
                user.setMail(row.getString(3));
                user.setPassword(row.getString(4));
                user.setToken(row.getString(5));
                user.setNumTel(row.getString(6));
                user.setNom(row.getString(7));
                user.setPrenom(row.getString(8));
                user.setSexe(row.getString(9));
                user.setRole(row.getString(10));
                user.setCin(row.getString(11));
                user.setPhoto(row.getString(12));
                user.getAdresse().setAdresse(row.getString(13));
                user.getAdresse().setVille(row.getString(14));
                user.getAdresse().setCodePostal(row.getInteger(15));
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }
        HomeForm h = new HomeForm();
        h.getF().show();
    }

    public void stop() {
        current = getCurrentForm();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = getCurrentForm();
        }
    }

    public void destroy() {
    }

}
