/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

/**
 *
 * @author TAOUFIK
 */
import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.soukelmdina.gui.ProduitForm;
import java.io.IOException;

public class LocalNotificationTest implements LocalNotificationCallback {

    public void ajouterNotification(int idproduit) {
        LocalNotification n = new LocalNotification();
        n.setAlertBody("Nouveau Produit "+idproduit);
        n.setAlertTitle("Soyer le premier à découvrir nos dernier produit");
        n.setId("" + idproduit);
        n.setBadgeNumber(1);
        int repeatType = LocalNotification.REPEAT_MINUTE;
        Display.getInstance().scheduleLocalNotification(n, System.currentTimeMillis() + 10 * 1000, repeatType);
    }

    public void destroy() {
    }

    @Override
    public void localNotificationReceived(String notificationId) {
        new ProduitForm(new serviceProduit().getProduitById(Integer.parseInt(notificationId))).getF().show();
    }

}
