/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;

import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import static com.codename1.ui.events.ActionEvent.Type.Response;
import com.codename1.util.Base64;
import com.soukelmdina.app.MyApplication;

import java.util.Map;

/**
 *
 * @author USER
 */
public class Example {

    // Find your Account Sid and Token at twilio.com/user/account
    /* public static final String ACCOUNT_SID = "AC93e5d7ad566566b15763720a458f853d";
  public static final String AUTH_TOKEN = "fff4cef904fe04334ce1dc57c2112ec6";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+21692323388"),
        new PhoneNumber("+21692323388"), 
        "This is the ship that made the Kessel Run in fourteen parsecs?").create();

    System.out.println(message.getSid());
  }*/
    String accountSID = "AC93e5d7ad566566b15763720a458f853d";
    String authToken = "fff4cef904fe04334ce1dc57c2112ec6";
    String fromPhone = "+21692323388";
    
    /*Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
        queryParam("To", MyApplication.user.getNumTel()).
        queryParam("From", fromPhone).
        queryParam("Body", "bonjour").
        basicAuth(accountSID, authToken)).
        getAsJsonMap();
*/
    Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
        queryParam("To", MyApplication.user.getNumTel()).
        queryParam("From", fromPhone).
        queryParam("Body", "bonjour").
        header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
        getAsJsonMap();
    
    
}
