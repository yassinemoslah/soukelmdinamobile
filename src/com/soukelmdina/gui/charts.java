/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;



//import ca.weblite.codename1.components.charts.ChartBuilder;

import ca.weblite.codename1.components.charts.Chart;
import ca.weblite.codename1.components.charts.ChartBuilder;
import ca.weblite.codename1.components.charts.ChartView;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.service.ServiceBoutique;
import java.util.Random;

/**
 *
 * @author lina9
 */
public class charts extends Layout {

    
    ServiceBoutique sb = new ServiceBoutique();

    public charts(int k) {
        
        Label overflowMenu = new Label(MyApplication.theme.getImage("of_menu.png"));
        
        toolbar.add(BorderLayout.EAST, overflowMenu);
        overflowMenu.addPointerPressedListener((e) -> {
            f.getToolbar().getMenuBar().showMenu();
        });
        
        
        f.getToolbar().addCommandToOverflowMenu("Toutes les boutiques", null,
                (ev) -> {
                    AffichageBoutique2 home = new AffichageBoutique2(); home.getF().show();
                });
        f.getToolbar().addCommandToOverflowMenu("Mes Boutiques", null,
                (ev) -> {
                    BoutiqueParVendeur cf = new BoutiqueParVendeur();
                    cf.getF().show();
                });
        
        f.getToolbar().addCommandToOverflowMenu("Ajouter", null,
                (ev) -> {
                    AjoutBoutique home = new AjoutBoutique(); home.getF().show();
                });
        
        
       ServiceBoutique serviceTask = new ServiceBoutique();
       //toolbar.add(BorderLayout.NORTH, new Label("charts"));
      

        /*f.setLayout(new BorderLayout());
        ChartBuilder b = new ChartBuilder();
        Chart chart = b.newPieChart(
                new double[]{
                    serviceTask.ab1(), serviceTask.ab1(), serviceTask.ab1()},
                new String[]{"BC", "Alberta", "Saskatchewan"}
        );
        ChartView v = new ChartView(chart);
        v.initLater();
        f.addComponent(BorderLayout.CENTER, v);
        f.show();*/
        //f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.setLayout(new BorderLayout());
        ChartBuilder b = new ChartBuilder();        
        Chart chart = b.newBarChart(
                new double[][]{
                    {serviceTask.ab1(k), serviceTask.ab2(k), serviceTask.ab3(k), serviceTask.ab4(k),
                        serviceTask.ab5(k), serviceTask.ab6(k), serviceTask.ab7(k), serviceTask.ab8(k),
                        serviceTask.ab9(k), serviceTask.ab10(k), serviceTask.ab11(k), serviceTask.ab12(k)},
                    {rdm(10), rdm(10), rdm(10), rdm(10),
                        rdm(10), rdm(10), rdm(10), rdm(10),
                        rdm(10), rdm(10), rdm(10), rdm(10),},
                    {rdm(8), rdm(5), rdm(5), rdm(5),
                        rdm(5), rdm(8), rdm(5), rdm(5),
                        rdm(5), rdm(5), rdm(8), rdm(5),}
//            {2, 3, 4, 1}
                },
                //new String[]{"aa", "bb", "cc", "dd"},
                new String[]{"abonnées", "like", "dislike"},
                new String[]{"Jan", "Fév", "Mar", "Avr", "Mai", "Jui", "Jui", "Ao", "Sep", "Oct", "Nov", "Déc"}
        );        
        
        ChartView v = new ChartView(chart);
        v.initLater();                
        f.addComponent(BorderLayout.CENTER, v);
        f.show();
  
    }

    public int rdm(int i) {
        Random rand = new Random();
        int n = rand.nextInt(i) + 0;
        return n;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
