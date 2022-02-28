/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Entities.Citoyen;
import Utils.DBConnexion;
import Utils.JavaMailUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hamza
 */
public class gerercitoyen {
    
  private static Connection cnx=DBConnexion.connecterDB();
    
    
    public gerercitoyen(){}
    public static void inscrire(String nom,String prenom,String email,String cin,long num_tel,String ville,String photo,String mot_de_passe)
    {
         PreparedStatement select;
         ResultSet resultat;
         PreparedStatement insert;
        try {
            Citoyen citoyen=new Citoyen(nom, prenom, email, cin, num_tel, ville,photo ,mot_de_passe);
            select=cnx.prepareStatement("select * from citoyen where cin=?");
            select.setString(1, cin);
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                System.err.println("Utilisateur existe");
            }
            else
            {
                insert=cnx.prepareCall("INSERT INTO citoyen(nom,prenom,email,cin,num_tel,ville,mot_de_passe) VALUES(?,?,?,?,?,?,?)");
                insert.setString(1,nom);
                insert.setString(2,prenom);
                insert.setString(3, email);
                insert.setString(4, cin);
                insert.setLong(5, num_tel);
                insert.setString(6, ville);
                
                insert.setString(7,mot_de_passe);
                insert.executeUpdate();
                
                    JavaMailUtil.sendEmail(email, "Bienvenue sur E-Citoyen \n"+" Attendez la confimation de l'Admin pour accéder à notre application \n Vous serez notifiés via une mail de confirmation \n Merci !! ");
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception exx) {
            System.err.println(exx.getMessage());
            
        }
        
        System.out.println("citoyen ajoutee");
    }
   
    
}
