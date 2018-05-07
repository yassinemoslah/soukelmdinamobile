/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Boutique1;
import com.soukelmdina.entite.Souk1;
import com.soukelmdina.entite.abonnement;
import com.soukelmdina.gui.Layout;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;




/**
 *
 * @author lina9
 */
public class ServiceBoutique {
     private String retour="";
    private int length;
    String reponse = "nophoto";
    
    public int ab1(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab1/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab2(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab2/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab3(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab3/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab4(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab4/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab5(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab5/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab6(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab6/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab7(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab7/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab8(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab8/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab9(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab9/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab10(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab10/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab11(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab11/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }
    
    public int ab12(int k) {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ab12/"+5);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                length = list.size();
                System.out.println("legnth : "+length);
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return length;
    }

    public ArrayList<Boutique1> getList2() {
        ArrayList<Boutique1> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/allJson");
        con.addResponseListener(e -> {
            System.out.println("looooooooooool"+e.getLength());
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    Boutique1 task = new Boutique1();
                    //int id1 = Integer.parseInt(obj.get("id").toString());
                    float id = Float.parseFloat(obj.get("id").toString());
                    float accept = Float.parseFloat(obj.get("accept").toString());
                    float caisse = Float.parseFloat(obj.get("caisse").toString());
                    //float idSouk = Float.parseFloat(obj.get("idSouk").toString());
                    //float idProprio = Float.parseFloat(obj.get("idProprio").toString());
                    float nbL = Float.parseFloat(obj.get("nbL").toString());
                    float nbD = Float.parseFloat(obj.get("nbD").toString());
                    
                    
                    task.setId((int) id);
                    task.setAccept((int) accept);
                    //task.setIdSouk((int) idSouk);
                    //task.setIdProprio((int) idProprio);
                    task.setNbL((int) nbL);
                    task.setNbD((int) nbD);
                    task.setCaisse(caisse);
                    //task.setId(id1);
                    task.setLibelle(obj.get("libelle").toString());
                    task.setPhoto(obj.get("photo").toString());
                    task.setDescription(obj.get("description").toString());
                    task.setNumTel(obj.get("numtel").toString());
                    task.setCinproprio(obj.get("cinproprio").toString());
                    

                    listTasks.add(task);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    public ArrayList<Boutique1> getListParIdProprio(int k) {
        ArrayList<Boutique1> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/BoutiqueParIdProprio/"+k);
        con.addResponseListener(e -> {
            System.out.println("looooooooooool"+e.getLength());
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    Boutique1 task = new Boutique1();
                    //int id1 = Integer.parseInt(obj.get("id").toString());
                    float id = Float.parseFloat(obj.get("id").toString());
                    float accept = Float.parseFloat(obj.get("accept").toString());
                    float caisse = Float.parseFloat(obj.get("caisse").toString());
                    //float idSouk = Float.parseFloat(obj.get("idSouk").toString());
                    //float idProprio = Float.parseFloat(obj.get("idProprio").toString());
                    float nbL = Float.parseFloat(obj.get("nbL").toString());
                    float nbD = Float.parseFloat(obj.get("nbD").toString());
                    
                    
                    task.setId((int) id);
                    task.setAccept((int) accept);
                    //task.setIdSouk((int) idSouk);
                    //task.setIdProprio((int) idProprio);
                    task.setNbL((int) nbL);
                    task.setNbD((int) nbD);
                    task.setCaisse(caisse);
                    //task.setId(id1);
                    task.setLibelle(obj.get("libelle").toString());
                    task.setPhoto(obj.get("photo").toString());
                    task.setDescription(obj.get("description").toString());
                    task.setNumTel(obj.get("numtel").toString());
                    task.setCinproprio(obj.get("cinproprio").toString());
                    

                    listTasks.add(task);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    public ArrayList<abonnement> chartss(){
             ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/charts1");
        con.addResponseListener(e -> {
            
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    abonnement task = new abonnement();
                    //int id1 = Integer.parseInt(obj.get("id").toString());
                    float id = Float.parseFloat(obj.get("id").toString());
                    float idB = Float.parseFloat(obj.get("idB").toString());
                    float idU = Float.parseFloat(obj.get("idU").toString());
                    
                                       
                    task.setId((int) id);
                    task.setIdU((int) idU);
                    task.setIdB((int) idB);
                    
                    
                    retour = obj.get("date").toString();
                    System.out.println("hey"+retour);
                    //task.setCinproprio(obj.get("cinproprio").toString());
                    Date d=null;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                    try {
                        d = sdf.parse(retour);
                        System.out.println("heeeeeeeeeeeeey"+d);
                    } catch (ParseException ex) {
                        
                    }
                    task.setDate(d);
                    listTasks.add(task);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
             
    }

    
    public ArrayList<Boutique1> getList() {
        ArrayList<Boutique1> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/allJson");
        con.addResponseListener(e -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
              
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    
    public void ajoutTask(Boutique1 ta, byte[] bytesdata) {
        ConnectionRequest con = new ConnectionRequest();
          MultipartRequest requete = new MultipartRequest();
        requete.setUrl(Layout.URL + "/server.php");
        requete.setPost(true);
        requete.addData("photo", bytesdata, "image/jpeg");
        NetworkManager.getInstance().addToQueue(requete);
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
         requete.addResponseListener((e) -> {
            reponse = new String(requete.getResponseData());
            String Url = Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/newJson?libelle=" + ta.getLibelle()
                +"&description="+ta.getDescription()
                +"&numtel="+ta.getNumTel()
                +"&idsouk="+ta.getIdSouk()
                +"&photo="+reponse;
        con.setUrl(Url);
            NetworkManager.getInstance().addToQueueAndWait(con);

        });
       

        System.out.println("tt");

        con.addResponseListener(e -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            ip.dispose();
        });
       
    }
    
    public void ModifTask(Boutique1 ta, int a) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/ModifJson/"+a+"?libelle=" + ta.getLibelle()
                +"&description="+ta.getDescription()
                +"&numtel="+ta.getNumTel()
                +"&idsouk="+ta.getIdSouk();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener(e -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    float nbL,nbD;
    String libelle, des;
    String []car;
    int id;
    
    
    
    
    public int Like(int k) {
        ArrayList<Boutique1> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/nbL/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    nbL = Float.parseFloat(obj.get("nbL").toString());                   
                }
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return (int)nbL;
    }
    
    public int DisLike(int k) {
        ArrayList<Boutique1> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/nbD/"+k);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    nbD = Float.parseFloat(obj.get("nbD").toString());                   
                }
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return (int)nbD;
    }
    
    public String findSoukById(int k)
    {        
        Souk1 s= new Souk1();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/souk/"+k);
        con.addResponseListener(e -> {
            
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    libelle = (obj.get("libelle").toString());                    
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return libelle;
    }
    public String findSoukById2(int k)
    {        
        Souk1 s= new Souk1();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/souk/"+k);
        con.addResponseListener(e -> {
            
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    libelle = (obj.get("description").toString());                    
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return libelle;
    }
    
    
    public int findSouksJson2(String ch) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/finsdSouksJson2/"+ch);
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                
                for (Map<String, Object> obj : list) {
                   float nbD = Float.parseFloat(obj.get("id").toString());
 
                    id=((int) nbD);                  
                }
                
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return id;
    }
    
    public String[] findSouksJson() {
        ArrayList<abonnement> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Layout.URL+"/soukelmdinaweb/web/app_dev.php/app/finsdSouksJson");
        con.addResponseListener(e -> {                       
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));               
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                car = new String[list.size()];
                int i=0;
                for (Map<String, Object> obj : list) {
                    System.out.println(obj);
                    car[i++] = obj.get("libelle").toString();
                    //nbL = Float.parseFloat(obj.get("nbL").toString());                   
                }
                
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return car;
    }
}
