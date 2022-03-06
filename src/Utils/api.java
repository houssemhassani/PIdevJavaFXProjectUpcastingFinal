/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import ClickSend.Api.SmsApi;
import ClickSend.ApiClient;
import ClickSend.ApiException;
import ClickSend.Model.SmsMessage;
import ClickSend.Model.SmsMessageCollection;
import java.net.*;
import java.util.Base64;
import java.io.*;
import com.squareup.okhttp.*;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.squareup.okhttp.logging.HttpLoggingInterceptor.Level;
import java.util.Arrays;
import java.util.List;
import okio.BufferedSink;
import okio.Okio;
/**
 *
 * @author hamza
 */
public class api {
    
    public void sms (String to, String message){
       ApiClient defaultClient = new ApiClient();
        defaultClient.setUsername("hamzaabda09@gmail.com");
        defaultClient.setPassword("57CC6BBB-B638-4712-B95A-1B11B1C09B17");
        SmsApi apiInstance = new SmsApi(defaultClient);

        SmsMessage smsMessage = new SmsMessage();
   
        smsMessage.body("nik omek" );
      
        smsMessage.to("+216"+26862373);
        smsMessage.source("sign up");
        

        List<SmsMessage> smsMessageList = Arrays.asList(smsMessage);
        // SmsMessageCollection | SmsMessageCollection model
        SmsMessageCollection smsMessages = new SmsMessageCollection();
        smsMessages.messages(smsMessageList);
        try {
            String result = apiInstance.smsSendPost(smsMessages);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SmsApi#smsSendPost");
            e.printStackTrace();
        }
    
    
    
    }}
    
    
    
    
    
    
    

