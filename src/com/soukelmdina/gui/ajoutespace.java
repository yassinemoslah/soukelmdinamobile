/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import com.codename1.ui.Button;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.soukelmdina.entite.Souk;
import com.soukelmdina.service.ServiceEspaceexpo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author marye
 */
public class ajoutespace extends Layout {
   TextField tnomspace,tdescription,tnumtel,tcategorie,tlongeur,tlargeur,tphoto,tprix;
    private Button btn; 
    public ajoutespace(){
    List<Souk> li = new ArrayList<>();
    String [ ] tabsouks = new String[100];
    List<String> souks = new ArrayList<>();
    ServiceEspaceexpo ses=new ServiceEspaceexpo();
     li=ses.getnomssouks();
     for (Souk ee:li){
           
            souks.add(ee.getLibelle());
       }
    for(int i=0; i < souks.size(); i++){
    tabsouks[i]=souks.get(i);
}
     
    tnomspace = new TextField();
    tnomspace.setHint("nom de l'espace");
    tdescription = new TextField();
    tdescription.setHint("Description");
    tnumtel = new TextField();
    tnumtel.setHint("N° tel");
    tcategorie = new TextField();
    tcategorie.setHint("categorie");
    tlargeur = new TextField();
    tlargeur.setHint("largeur");
    tlongeur = new TextField();
    tlongeur.setHint("longeur");
    tprix = new TextField();
    tprix.setHint("prix");
    Picker p = new Picker();
    p.setStrings(tabsouks);
    btn = new Button("deposez annonce");
    
    
    f.setTitle("Créer votre annonce");
    f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
    f.add(tnomspace);
    f.add(p);
    f.add(tdescription);
    f.add(tnumtel);
    f.add(tlargeur);
    f.add(tlongeur);
    f.add(tprix);
    f.add(btn);
    
      
    }
    }