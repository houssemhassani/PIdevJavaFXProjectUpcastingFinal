/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entities.demande;
import Entities.notification;
import Utils.DBConnexion;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import services.gererdemande;
import  services.gerernotification;

/**
 *
 * @author hamza
 */
public class Test {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        DBConnexion.connecterDB();
        //Date aujourdhui = SystemClockFactory.getDatetime();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
Date now = new Date();
        DateFormat dateFormatYMD = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        String vDateYMD = dateFormatYMD.format(now);
      //gererdemande.ajouterdemande(5, vDateYMD, vDateYMD, 5, 6);
     //gererdemande.modifierdemande(6, "bonsoir");
     // gererdemande.supprimerdemande(6);
 
      //gerernotification.ajouternotification(15, "facture", "hamzaabda09@gmail.com");
      //gerernotification.modifiernotification(15, "paiment");
     // gerernotification.supprimerdemande(15);

         /* ArrayList<demande> e=gererdemande.afficher();
       for (demande object : e) {
            System.out.println(object.toString());
            
      }*/
    
       ArrayList<notification> d=gerernotification.afficher();
       for (notification object : d) {
            System.out.println(object.toString());
            
      }
       //System.out.println(gererdemande.afficher());
        
        // System.out.println(gererdemande.Recherchedemande(8));
     
//     gerernotification.ajouternotification(15, "facture", "hamzaabda08@gmail.com",15);
        //System.out.println(gerernotification.afficher());
    }
    
}    
      
        
        
        
      
    
    
    
    
