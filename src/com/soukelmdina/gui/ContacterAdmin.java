/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.soukelmdina.app.MyApplication;
import java.io.IOException;

/**
 *
 * @author Amal Mabrouk
 */
public class ContacterAdmin extends Layout {

    public ContacterAdmin() {
                toolbar.add(BorderLayout.CENTER, new Label("Contacter l'admin"));

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
        Button btn = new Button("Envoyer");
        TextArea avis = new TextArea("");

        Container container = new Container();
        container.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        SpanLabel lm = new SpanLabel("Mail:");
        lm.setTextBlockAlign(Component.LEFT);

        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        Label l5 = new Label();
        Label l6 = new Label();

        avis.setHint("Ecrire votre message");

        content.add(l2);
        content.add(l5);
        content.add(l3);
        content.add(l4);
        content.add(l6);

        content.add(lm);
        content.add(l1);

        content.add((avis));
        content.add(btn);

        btn.addActionListener((e) -> {

            Message m = new Message(avis.getText());

            Display.getInstance().sendMessage(new String[]{"amal.mabrouk@esprit.tn"}, "cafe en attente", m);
            Dialog.show("Mail", "Votre mail est envoyé avec succés ", "OK", null);

            ListeCafeRestoVendeur lc = new ListeCafeRestoVendeur();

            lc.f.show();

        });

    }

}
