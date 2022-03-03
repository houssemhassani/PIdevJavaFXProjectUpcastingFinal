/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entities.demande;
import Entities.notification;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.gererdemande;
/**
 *
 * @author hamza
 */
public class DBConnexion {

    
    public static Connection connecterDB(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver ok");
        String url ="jdbc:mysql://localhost:3306/pidev";
        String user ="root";
        String password="";
        Connection cnx = DriverManager.getConnection(url,user,password);
        System.out.println("Connexion bien établie");
        return cnx;
        
        
        
                
        }catch(Exception e){
        e.printStackTrace();
        return null;
        }
    }

    public static  ObservableList<demande>getDatademande(){
    
         Connection conn = DBConnexion.connecterDB();
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
    
    
    
    
   
}
    
    
    
    
    
    
    

