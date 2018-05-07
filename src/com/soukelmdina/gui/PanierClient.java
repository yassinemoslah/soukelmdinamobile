/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.CafeResto;
import com.soukelmdina.entite.Commande;
import com.soukelmdina.entite.CommandeProduit;
import com.soukelmdina.service.ServiceCafeResto;
import com.soukelmdina.service.ServiceCommande;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Amal Mabrouk
 */
public class PanierClient extends Layout {

   Label supp;
    EncodedImage enc;
    URLImage uRLImage;
    double prix = 0;

    public PanierClient() {

        toolbar.add(BorderLayout.CENTER, new Label("Panier"));

        Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png"));

        f.setTitle("Panier");
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));

        content.setLayout(BoxLayout.y());
        if (MyApplication.listeCommandep.size() != 0) {
            for (CommandeProduit ee : MyApplication.listeCommandep) {
                content.add(addItem(ee));
                content.add(addItem1());

            }

            for (int i = 0; i < MyApplication.listeCommandep.size(); i++) {
                prix = MyApplication.listeCommandep.get(i).getQte() * MyApplication.listeCommandep.get(i).getPrix() + prix;
            }
            Border border = Border.createLineBorder(1, 0xfff/*Color.BLUE.hashCode()*/);

            SpanLabel descval = new SpanLabel("Prix total:" + String.valueOf(prix) + "dt");
            descval.getAllStyles().setAlignment(Component.LEFT);
            descval.getAllStyles().setBorder(border);
            content.add(descval);

            Button valider = new Button("Valider panier");
            content.add(valider);
            Commande cc = new Commande();
            cc.setTotalPrix(prix);

            valider.addActionListener((e) -> {
                if (MyApplication.user.getSolde() > prix) {
                    ServiceCommande sc = new ServiceCommande();

                    int qte = 0;
                    for (int i = 0; i < MyApplication.listeCommandep.size(); i++) {

                        qte = MyApplication.listeCommandep.get(i).getQte();
                        sc.ModifierQte(qte, MyApplication.listeCommandep.get(i).getIdproduit());

                    }

                    sc.ajoutCommande(cc);
                    Dialog.show("Panier", "panier validé", "OK", null);
                    MyApplication.listeCommandep = new ArrayList<>();
                    f.revalidate();
                    PanierClient p = new PanierClient();
                    p.getF().show();
                } else {
                    Dialog.show("Solde!!", "Désolé votre solde est insuffisant", "OK", null);
                }
            });
        } else {
            Container cnt2 = new Container(BoxLayout.x());
            Container cnt1 = new Container(BoxLayout.y());

            Label l = new Label("                  ");
            Label ll = new Label("                  ");
            Label lll = new Label("                  ");
            Label llll = new Label("                  ");

            Border border = Border.createLineBorder(1, 0xfff/*Color.BLUE.hashCode()*/);

            SpanLabel descval = new SpanLabel("Panier Vide");
            descval.getAllStyles().setAlignment(Component.CENTER);
            descval.getAllStyles().setBorder(border);
            cnt2.add(l);
            cnt2.add(descval);
            cnt1.add(ll);
            cnt1.add(lll);
            cnt1.add(cnt2);
            content.add(cnt1);

        }
        
        
        
        
        

    }

    public Container addItem(CommandeProduit c) {
        //Label lbimage= new Label(MyApplication.theme.getImage("round.png"));
        Image screenshot = Image.createImage(130, 130);
        enc = EncodedImage.createFromImage(screenshot, false);
        System.out.println(c.getPhoto() + "taswiraaaa");
        uRLImage = URLImage.createToStorage(enc, c.getPhoto(), Layout.URL + c.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        Label prix = new Label("Prix unitaire:" + String.valueOf(c.getPrix()));
        Label qte = new Label("La quantité:" + String.valueOf(c.getQte()));

        // SpanLabel lblnumtel = new SpanLabel("numéro: " + c.getNumtel());
        Label ll = new Label("");
        Label lll = new Label("");
        Label llllll = new Label("");
        Label lllll = new Label("");
        Label llll = new Label("");
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        //Container cnt3 = new Container(BoxLayout.x());
        supp = new Label("");
        supp.setIcon(MyApplication.theme.getImage("supp.png"));
        
        
           supp.addPointerPressedListener((act) -> {
           MyApplication.listeCommandep.remove(c);
             PanierClient es = new PanierClient();
                    es.getF().show();

        });
        //supp.setTextBlockAlign(Component.RIGHT);

        cnt2.setScrollableY(true);
        cnt1.add(ll);
        //cnt1.add(lll);
                cnt1.add(supp);

        //cnt1.add(lllll);
       // cnt1.add(supp);

       // cnt1.add(supp);

        cnt1.add(prix);
        cnt1.add(qte);

        cnt2.add(imgV);
        cnt2.add(cnt1);
        

        //    cnt2.setLeadComponent(prix);
        return cnt2;
    }

    public Container addItem1() {
        //Label lbimage= new Label(MyApplication.theme.getImage("round.png"));
        Label lll = new Label("");
        Label llll = new Label("");

        Label ll = new Label("");
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt3 = new Container(BoxLayout.x());

        cnt1.add(ll);
        cnt1.add(llll);

        cnt1.add(lll);

        //  cnt2.add(ll);
        // cnt3.add(cnt2);
        return cnt1;
    }

}
