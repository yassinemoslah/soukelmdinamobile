/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.googlemaps.MapContainer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.maps.providers.GoogleMapsProvider;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Souk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mosla
 */
public class DetailsSouk extends Layout {

    private SpanLabel description, gouvernorat;
    private Label libelle;
    EncodedImage enc;
    URLImage uRLImage;
    private static final String HTML_API_KEY = "AIzaSyDuqAvDt7ghPGrgFScH4eHRbBuPClc6Y0E";
    Location position;
    boolean ok = false;

    public DetailsSouk() {
    }

    public DetailsSouk(Souk s, ArrayList<Souk> listeSouks) {
        toolbar.add(BorderLayout.CENTER, new Label("Détails du Souk"));
        Label back = new Label("Retour");
        toolbar.add(BorderLayout.EAST, back);
        back.addPointerPressedListener((e) -> {
            ListeSouks liste = new ListeSouks(listeSouks);
            liste.getF().show();
        });

        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
        uRLImage = URLImage.createToStorage(enc, s.getPhoto(), Layout.URL + s.getPhoto(), URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);
        libelle = new Label(s.getLibelle());
        libelle.setUIID("PinkLabel");
        description = new SpanLabel(s.getDescription());
        gouvernorat = new SpanLabel(s.getGouvernorat());

        final MapContainer cnt = new MapContainer(new GoogleMapsProvider(HTML_API_KEY));
        cnt.zoom(new Coord(s.getCoordonnees().getLatitude(), s.getCoordonnees().getLongitude()), 13);
        Style style = new Style();
        style.setFgColor(0xff0000);
        style.setBgTransparency(0);
        FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, style, Display.getInstance().convertToPixels(3));
        cnt.addMarker(
                EncodedImage.createFromImage(markerImg.scaled(50, 50), false),
                cnt.getCameraPosition(),
                s.getLibelle(),
                s.getDescription(),
                evt -> {
                    ToastBar.showMessage(s.getLibelle(), FontImage.MATERIAL_PLACE);
                }
        );

        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.add(new Label(" "));
        f.add(imgV);
        f.add(libelle);
        f.add(gouvernorat);
        f.add(description);
        f.add(cnt);

        try {
            position = LocationManager.getLocationManager().getCurrentLocation();
            cnt.addMarker(
                    EncodedImage.createFromImage(markerImg.scaled(50, 50), false),
                    new Coord(position.getLatitude(), position.getLongitude()),
                    "Votre position",
                    "Votre position",
                    evt -> {
                        ToastBar.showMessage("Votre position", FontImage.MATERIAL_PLACE);
                    }
            );
            cnt.addPath(
                    new Coord(s.getCoordonnees().getLatitude(), s.getCoordonnees().getLongitude()),
                    new Coord(position.getLatitude(), position.getLongitude())
            //new Coord(33.7732938, 10.7536639)
            );
        } catch (IOException ex) {
            System.out.println(ex);
        }

        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + position.getLatitude() + "," + position.getLongitude() + "&destinations=" + String.valueOf(s.getCoordonnees().getLatitude()) + "," + String.valueOf(s.getCoordonnees().getLongitude()) + "&language=fr&key=AIzaSyDp0MV6ZR8_23QiXWAwp97dj_63asC0QHM");
        //con.setUrl("https://maps.googleapis.com/maps/api/distancematrix/json?origins=33.7732938,10.7536639&destinations=" + String.valueOf(s.getCoordonnees().getLatitude()) + "," + String.valueOf(s.getCoordonnees().getLongitude()) + "&language=fr&key=AIzaSyDp0MV6ZR8_23QiXWAwp97dj_63asC0QHM");
        con.addArgument("Content-Length", "0");
        con.addResponseListener(e -> {
            ip.dispose();
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                List<Map<String, Object>> rows = (List<Map<String, Object>>) tasks.get("rows");
                List<Map<String, Object>> elements = (List<Map<String, Object>>) rows.get(0).get("elements");
                if (elements.get(0).get("status").equals("OK")) {
                    ok = true;
                    String distance = elements.get(0).get("distance").toString();
                    String duration = elements.get(0).get("duration").toString();
                    System.out.println(duration);
                    f.add(new SpanLabel(distance.substring(6, distance.indexOf(",")) + " km vous séparent de " + s.getLibelle()));
                    Label duree = new Label(duration.substring(6, duration.indexOf(",")));
                    duree.setIcon(MyApplication.theme.getImage("car_50.png"));
                    f.add(duree);
                } else {
                    f.add(new SpanLabel("Désolé on n'a pas pu calculer la distance entre vous et " + s.getLibelle()));
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        if (ok) {
            ConnectionRequest con1 = new ConnectionRequest();
            con1.setUrl("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + position.getLatitude() + "," + position.getLongitude() + "&destinations=" + String.valueOf(s.getCoordonnees().getLatitude()) + "," + String.valueOf(s.getCoordonnees().getLongitude()) + "&language=fr&mode=walking&key=AIzaSyDp0MV6ZR8_23QiXWAwp97dj_63asC0QHM");
            //con1.setUrl("https://maps.googleapis.com/maps/api/distancematrix/json?origins=33.7732938,10.7536639&destinations=" + String.valueOf(s.getCoordonnees().getLatitude()) + "," + String.valueOf(s.getCoordonnees().getLongitude()) + "&language=fr&mode=walking&key=AIzaSyDp0MV6ZR8_23QiXWAwp97dj_63asC0QHM");
            con1.addArgument("Content-Length", "0");
            con1.addResponseListener(e -> {
                JSONParser jsonp1 = new JSONParser();
                try {
                    Map<String, Object> tasks = jsonp1.parseJSON(new CharArrayReader(new String(con1.getResponseData()).toCharArray()));
                    List<Map<String, Object>> rows = (List<Map<String, Object>>) tasks.get("rows");
                    List<Map<String, Object>> elements = (List<Map<String, Object>>) rows.get(0).get("elements");
                    if (elements.get(0).get("status").equals("OK")) {
                        String distance = elements.get(0).get("distance").toString();
                        String duration = elements.get(0).get("duration").toString();
                        System.out.println(rows);
                        Label dist = new Label(duration.substring(6, duration.indexOf(",")));
                        dist.setIcon(MyApplication.theme.getImage("walking_50.png"));
                        f.add(dist);
                    }
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            });
            NetworkManager.getInstance().addToQueueAndWait(con1);
        }
    }
}
