/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.util.Callback;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique;
import com.soukelmdina.service.BackgroundFetchService;
import java.io.IOException;

/**
 *
 * @author mosla
 */
public class Layout {
   public static Boutique btq;
    Form f;
    Container toolbar;
    Container content;
    Container main;
    private EncodedImage enc;
    private URLImage uRLImage;
    public static String URL = "http://127.0.0.1";

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
            f.getToolbar().addComponentToSideMenu(new Label(MyApplication.theme.getImage("soukelmdina.png")));
            f.getToolbar().addMaterialCommandToSideMenu("Accueil", FontImage.MATERIAL_HOME, (e) -> {
                HomeForm home = new HomeForm();
                home.getF().show();
            });
            f.getToolbar().addMaterialCommandToSideMenu("Login", FontImage.MATERIAL_OPEN_IN_NEW, (e) -> {
                Login login = new Login();
                login.getF().show();
            });
            
            f.getToolbar().addMaterialCommandToSideMenu("Souks", FontImage.MATERIAL_ACCOUNT_BALANCE, (e) -> {
                ListeSouks souks = new ListeSouks();
                souks.getF().show();
            });

            f.getToolbar().addMaterialCommandToSideMenu("Espace d'exposition", FontImage.MATERIAL_HOME, (e) -> {
                HOMEinternaute es = new HOMEinternaute();
                es.getF().show();
            });
            f.getToolbar().addMaterialCommandToSideMenu("Evènements", FontImage.MATERIAL_HOME, (e) -> {
                    HomeEventsInternaure es = new HomeEventsInternaure();
                    es.getF().show();
                });
      f.getToolbar().addMaterialCommandToSideMenu("CafeResto", FontImage.MATERIAL_HOME, (e) -> {
                ListeCafeRestoClient es = new ListeCafeRestoClient();
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
            f.getToolbar().addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_PERM_IDENTITY, (e) -> {
                Profile profile = new Profile();
                profile.getF().show();
            });
              f.getToolbar().addMaterialCommandToSideMenu("Souks", FontImage.MATERIAL_ACCOUNT_BALANCE, (e) -> {
                ListeSouks souks = new ListeSouks();
                souks.getF().show();
            });
            String role = MyApplication.user.getRole();
            if (role.equals("Vendeur")) {
                f.getToolbar().addMaterialCommandToSideMenu("Espace d'exposition", FontImage.MATERIAL_HOME, (e) -> {
                    espacevendeur es = new espacevendeur();
                    es.getF().show();
                });
       f.getToolbar().addMaterialCommandToSideMenu("CafeResto", FontImage.MATERIAL_HOME, (e) -> {
                ListeCafeRestoVendeur es = new ListeCafeRestoVendeur();
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
                     f.getToolbar().addMaterialCommandToSideMenu("CafeResto", FontImage.MATERIAL_HOME, (e) -> {
                ListeCafeRestoClient es = new ListeCafeRestoClient();
                es.getF().show();
            });
                             f.getToolbar().addMaterialCommandToSideMenu("Panier", FontImage.MATERIAL_HOME, (e) -> {
                PanierClient es = new PanierClient();
                es.getF().show();
            });

            }
            f.getToolbar().addMaterialCommandToSideMenu("Déconnexion", FontImage.MATERIAL_SUBDIRECTORY_ARROW_LEFT, (e) -> {
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

    
            if (MyApplication.user != null) {
            if (MyApplication.user.getRole().equals("Client")) {
                f.getToolbar().addMaterialCommandToSideMenu("Produits", FontImage.MATERIAL_HOME, (e) -> {
                    new ListeBoutiqueProd().getF().show();
                });
            }
            if (MyApplication.user.getRole().equals("Vendeur")) {
                f.getToolbar().addMaterialCommandToSideMenu("Produits", FontImage.MATERIAL_HOME, (e) -> {
                    new ListeBoutiqueProd().getF().show();
                });
                f.getToolbar().addMaterialCommandToSideMenu("Ajouter Produit", FontImage.MATERIAL_HOME, (e) -> {
                    new AjoutProduitForm().getF().show();
                });
            }
        }

       
    }

    public Form getF() {
        return f;        
    }

    public void setF(Form f) {
        this.f = f;
    }
}
