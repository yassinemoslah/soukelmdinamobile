/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.service;


/*import com.soukelmdina.app.MyApplication;
import com.soukelmdina.entite.Utilisateur;
import no.vianett.sms.SmsEventListener;
import no.vianett.sms.Sms;
import no.vianett.sms.SmsEvent;
import no.vianett.sms.component.SmsTransceiver;
import no.vianett.sms.log.SmsScreenLogger;
import no.vianett.sms.event.SmsDeliveredEvent;
import no.vianett.sms.event.SmsSendingFailedEvent;
import no.vianett.sms.event.SmsDeliveryFailedEvent;
 
public class SmsSender implements SmsEventListener
{
    private SmsTransceiver transceiver = null;
    private Object link = null; // Just to keep this object alive.
    private int counter = 0;
 
    public SmsSender()
    {
        this.link = this; // Keeps this object alive.
        this.transceiver = SmsTransceiver.getInstance(); // Get the transceiver object.
 
        // Initialize transceiver.
        String smsHost = "cpa.vianett.no";
        String smsPort = "31337";
        String smsUsername = "dorra.mahfoudhi@esprit.tn";
        String smsPassword = "wqk8m";
        this.transceiver.initialize( smsHost, Integer.parseInt( smsPort ), smsUsername, smsPassword, new SmsScreenLogger() );
 
        this.transceiver.addSmsEventListener( this ); // Registrer this class as listener for SMS events.
        
        // Send message
        Sms sms = new Sms();
        sms.setId( ++this.counter );
        sms.setReplyPath( 100 );
        sms.setSender( "Souk El Mdina" ); // Set the sender number.
        sms.setMessage( "Hello World!" );
        sms.setRecipient( "94729109" ); // The recipients phone number.
 
        this.transceiver.send( sms );
    } 

    

    //@Override

    @Override
    public void eventHappened(SmsEvent se) {
    }
    
    
   
}
*/