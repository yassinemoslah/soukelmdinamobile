/*
nsobha fi tlf ?em
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

import com.codename1.background.BackgroundFetch;
import com.codename1.components.SpanLabel;
import com.codename1.io.NetworkManager;
import com.codename1.io.services.RSSService;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.util.Callback;
import com.soukelmdina.entite.Produit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author TAOUFIK
 */
public class BackgroundFetchService implements BackgroundFetch {

    private static int id = -1;


    /**
     * This method will be called in the background by the platform.  It will
     * load the RSS feed.  Note:  This only runs when the app is in the background.
     * @param deadline
     * @param onComplete
     */
    @Override
    public void performBackgroundFetch(long deadline, Callback<Boolean> onComplete) {
        Produit p = new serviceProduit().dernierProduct();
        
        if(p.getId() == id){
            onComplete.onSucess(Boolean.FALSE);
        }else{
            id = p.getId();
            new LocalNotificationTest().ajouterNotification(id);
            onComplete.onSucess(Boolean.TRUE);
        }
    }

}
