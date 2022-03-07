/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Moemen
 */
public class DBConnexion {
    String url="jdbc:mysql://localhost:3306/pidev";
    String login="root";
    String pwd="";
    Connection cnx;

    public DBConnexion() {
    
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public Connection getCnx ()
    {
        return cnx;
    }
    
    
    
    
}
