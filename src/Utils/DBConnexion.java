/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entities.demande;
import Entities.reclamations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Asus
 */
public class DBConnexion {
    
       private static Connection connexion;
       
       public DBConnexion(){
           
       
       }
       
       public static Connection getConnexion()
       {
           try {
                DBConnexion.connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev","root",null);
                System.out.println(DBConnexion.connexion.toString());
           } catch (SQLException ex) {
               System.err.println(ex.getMessage());
           }
           return DBConnexion.connexion;
       }
       public static  ObservableList<demande>getDatademande(){
    
         Connection conn = DBConnexion.getConnexion();
        ObservableList<demande> oblist =FXCollections.observableArrayList();
        try {
        ResultSet rs =conn.createStatement().executeQuery("select * from demande");
        
        while(rs.next()){
        demande d=new demande(rs.getInt("ID"),rs.getInt("num_demande"),rs.getString("type_demande"),
        rs.getString("date_demande"),
        rs.getInt("id_citoyen"),
        rs.getInt("id_service"));
        d.setEtat(rs.getString("etat"));
        oblist.add(d);        
        }
        }catch (SQLException ex){
        
    
        }
        return oblist ;
    
    
    
    
    }
       public static  ObservableList<reclamations>getDataReclam(){
    
         Connection conn = DBConnexion.getConnexion();
        ObservableList<reclamations> oblist =FXCollections.observableArrayList();
        try {
        ResultSet rs =conn.createStatement().executeQuery("select * from réclamation");
        
        while(rs.next()){
            System.out.println(rs.getString("description_reclamation"));
        reclamations d=new reclamations(rs.getInt("num_reclamation"),rs.getString("type_reclamation"),
        rs.getString("description_reclamation"),
        rs.getString("ville_reclamation"),
        rs.getInt("id_citoyen"));
       // d.setEtat(rs.getString("etat"));
        oblist.add(d);        
        }
        }catch (SQLException ex){
        
    
        }
        return oblist ;
       }
        
        
    
}
