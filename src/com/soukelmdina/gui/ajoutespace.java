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
    
      
<<<<<<< HEAD
        
        enc = EncodedImage.createFromImage(MyApplication.theme.getImage("100x100.png"), false);
      
       // uRLImage = URLImage.createToStorage(enc,urloldphoto, Layout.URL + urloldphoto, URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV = new ImageViewer(uRLImage);

        changePhoto = new Label("Changer la photo");
        changePhoto.addPointerPressedListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (Dialog.show("Camera or Gallery", "Would you like to use the camera or the gallery for the picture?", "Camera", "Gallery")) {
                    photo = Capture.capturePhoto();
                    if (photo != null) {
                        try {
                            Image img = Image.createImage(photo);
                            ImageIO imgIO = ImageIO.getImageIO();
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            imgIO.save(img, out, ImageIO.FORMAT_JPEG, 1);
                            bytesdata = out.toByteArray();
                            imgV.setImage(Image.createImage(FileSystemStorage.getInstance().openInputStream(photo)));

                        } catch (IOException err) {
                            System.out.println(err);
                        }
                    }
                } else {
                    Display.getInstance().openGallery(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ev) {
                            if (ev != null && ev.getSource() != null) {
                                photo = (String) ev.getSource();

                                try {
                                    Image img = Image.createImage((String) ev.getSource());
                                    ImageIO imgIO = ImageIO.getImageIO();
                                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                                    imgIO.save(img, out, ImageIO.FORMAT_JPEG, 1);
                                    bytesdata = out.toByteArray();
                                    imgV.setImage(Image.createImage(FileSystemStorage.getInstance().openInputStream(photo)));
                                } catch (IOException ex) {
                                    System.out.println(ex);
                                }
                            }
                        }
                    }, Display.GALLERY_IMAGE);
                }

            }
        }
        );

        btn = new Button("ajouter annonce");

//       btn.addActionListener(
//               (e) -> {
//                      ServiceEspaceexpo ses=new ServiceEspaceexpo();
//            int idsouk=0;
//           for(int i=0; i < li.size(); i++)
//           {
//           if(li.get(i).equals(p.getValue()))
//           idsouk=li.get(i).getId(); }
//             
//                 ses.createespace(photo, nom.getText(), description.getText(),numtel.getText(),Double.parseDouble(longu.getText()),Double.parseDouble(larg.getText()),Double.parseDouble(prix.getText()),idsouk,lcategorie.getText());
//               }
//       );
        toolbar.add(BorderLayout.CENTER, new Label("blablabla"));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
  content.add(imgV);
        content.add(changePhoto);
  content.add(lnom);
        content.add(nom);
        content.add(ldescription);
        content.add(description);
         content.add(lcategorie);
        content.add(categorie);
        content.add(lsouk);
//        content.add(p);
        content.add(lnumtel);
        content.add(numtel);
        content.add(llarg);
        content.add(larg);
        content.add(llongu);
        content.add(longu);
        content.add(lprix);
        content.add(prix);
        content.add(btn);
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_1.jpg"));
=======
>>>>>>> 74783e2ea353b7c3aefd20075725584242c5ce1c
    }
    }