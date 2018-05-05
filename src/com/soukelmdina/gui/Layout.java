/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import java.io.IOException;

/**
 *
 * @author mosla
 */
public class Layout {

    Form f;
    Container toolbar;
    Container content;
    Container main;
    private EncodedImage enc;
    private URLImage uRLImage;
    public static String URL = "http://192.168.1.48";

    public Layout() {
        f = new Form();

        f.getToolbar().setHidden(true, true);
        toolbar = new Container(new BorderLayout());
        Label menu = new Label(MyApplication.theme.getImage("menu.png"));
        Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png"));

        menu.addPointerPressedListener((e) -> {
            f.getToolbar().openSideMenu();
        });

        overflowMenu.addPointerPressedListener((e) -> {
            f.getToolbar().getMenuBar().showMenu();
        });

        toolbar.add(BorderLayout.WEST, menu);
        //toolbar.add(BorderLayout.EAST, overflowMenu);

        content = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        //content.setScrollableY(true);

        main = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        //main.setScrollableY(false);
        main.add(toolbar);
        main.add(content);
        //f.setScrollableX(false);
        //f.setScrollableY(false);
        f.add(main);

        if (MyApplication.user == null) {
            f.getToolbar().addMaterialCommandToSideMenu("Accueil", FontImage.MATERIAL_HOME, (e) -> {
                HomeForm home = new HomeForm();
                home.getF().show();
            });
            f.getToolbar().addMaterialCommandToSideMenu("Login", FontImage.MATERIAL_HOME, (e) -> {
                Login login = new Login();
                login.getF().show();
            });

            f.getToolbar().addMaterialCommandToSideMenu("Espace d'exposition", FontImage.MATERIAL_HOME, (e) -> {
                HOMEinternaute es = new HOMEinternaute();
                es.getF().show();
            });
            f.getToolbar().addMaterialCommandToSideMenu("Evènements", FontImage.MATERIAL_HOME, (e) -> {
                    HomeEventsInternaure es = new HomeEventsInternaure();
                    es.getF().show();
                });

        } else {
            char c = 'v';
            f.getToolbar().addMaterialCommandToSideMenu("", c, (e) -> {
            });
            enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
            uRLImage = URLImage.createToStorage(enc, MyApplication.user.getPhoto(), Layout.URL + MyApplication.user.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
            ImageViewer imgV = new ImageViewer(uRLImage);
            f.getToolbar().addComponentToSideMenu(imgV);

            f.getToolbar().addMaterialCommandToSideMenu("", c, (e) -> {
            });
            f.getToolbar().addMaterialCommandToSideMenu("Accueil", FontImage.MATERIAL_HOME, (e) -> {
                HomeForm home = new HomeForm();
                home.getF().show();
            });
            f.getToolbar().addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_HOME, (e) -> {
                Profile profile = new Profile();
                profile.getF().show();
            });
            String role = MyApplication.user.getRole();
            if (role.equals("Vendeur")) {
                f.getToolbar().addMaterialCommandToSideMenu("Espace d'exposition", FontImage.MATERIAL_HOME, (e) -> {
                    espacevendeur es = new espacevendeur();
                    es.getF().show();
                });

            } else if (role.equals("Client")) {

                f.getToolbar().addMaterialCommandToSideMenu("Espace d'exposition", FontImage.MATERIAL_HOME, (e) -> {
                    espaceexpohome es = new espaceexpohome();
                    es.getF().show();
                });
                f.getToolbar().addMaterialCommandToSideMenu("Evènements", FontImage.MATERIAL_HOME, (e) -> {
                    HomeEvents es = new HomeEvents();
                    es.getF().show();
                });

            }
            f.getToolbar().addMaterialCommandToSideMenu("Déconnexion", FontImage.MATERIAL_HOME, (e) -> {
                MyApplication.user = null;
                try {
                    MyApplication.db.execute("delete from user");
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                HomeForm home = new HomeForm();
                home.getF().show();
            });
        }

    }

    public Form getF() {
        return f;        
    }

    public void setF(Form f) {
        this.f = f;
    }
}
