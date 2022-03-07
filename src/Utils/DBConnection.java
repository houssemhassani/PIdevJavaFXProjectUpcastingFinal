/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rachdi
 */
public class DBConnection {
    
       private static Connection connection;
       
       public DBConnection(){
           
       
       }
       
       public static Connection getConnection()
       {
           try {
                DBConnection.connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev","root",null);
                System.out.println(DBConnection.connection.toString());
           } catch (SQLException ex) {
               System.err.println(ex.getMessage());
           }
           return DBConnection.connection;
       }
        
        
    
}