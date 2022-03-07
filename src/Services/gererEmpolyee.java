/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Moemen
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.Employee;
import Utils.DBConnexion;
import entities.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Moemen
 */
public class gererEmpolyee {

        
    public gererEmpolyee() {
    }
    
   public static void ajouterEmployee(int cin, String nom, String prenom, String email, String mot_de_pass)
    {
        PreparedStatement select;
         ResultSet resultat;
         PreparedStatement insert;
         try {
            select= new DBConnexion().getCnx().prepareStatement("Select * from Empolyee where cin="+cin+"");
            resultat=select.executeQuery();
            if(!resultat.isBeforeFirst())
            {
                insert=new DBConnexion().getCnx().prepareStatement("INSERT INTO Empolyee (nom,prenom,email,cin,mot_de_pass) values (?,?,?,?,?)");
                insert.setString(1, nom);
                insert.setString(2, prenom);
                insert.setString(3, email);
                insert.setInt(4, cin);
                insert.setString(5,mot_de_pass);
                  
                
                insert.executeUpdate();
                System.out.println("Empolyee ajoutee");
            }
            else
                 System.err.println("Empolyee existe");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
   
       public static void modifierEmployee(int cin,String mot_de_pass)
    {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement update;
        try {
             select= new DBConnexion().getCnx().prepareStatement("Select * from Employee where cin="+cin+"");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                update=new DBConnexion().getCnx().prepareStatement("Update Employee set mot_de_pass=? where cin=?" );
                
                update.setString(1, mot_de_pass);
                update.setInt(2, cin);
           
                update.executeUpdate();
                System.out.println("modification du Employee effectué");
            }
            else
                System.err.println("erreur ");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }  
   
     public static void supprimerEmployee(int num_tache)
    {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement delete;
         try {
            select= new DBConnexion().getCnx().prepareStatement("Select * from tache where num_tache="+num_tache+"");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                delete=new DBConnexion().getCnx().prepareStatement("Delete from tache where num_tache='"+num_tache+"'");
                delete.executeUpdate();
                System.out.println("tache supprimee");
            }
            else
                 System.err.println("failed");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
     
   public static ArrayList<Employee> afficherEmployee() {
        ArrayList<Employee> Employees = new ArrayList<>();
        PreparedStatement select;


        try {
            select = new DBConnexion().getCnx().prepareStatement("Select * from Empolyee");
            ResultSet rs = select.executeQuery();
            
            while (rs.next()) {
                Employee e1 = new Employee();
                e1.setId(rs.getInt(1));
                e1.setCin(rs.getInt(2));
                e1.setNom(rs.getNString("nom"));
                e1.setPrenom(rs.getNString("prenom"));
                e1.setEmail(rs.getString("email"));
                e1.setNum_equipe(rs.getInt(6));
                e1.setService_nom(rs.getString("Service_nom"));
                e1.setEquipe_id(rs.getInt(9));
                Employees.add(e1);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return Employees;
    }
   
   public static ArrayList<Employee> afficherEmployee_parEquipe()
   {
       
       ArrayList<Employee> Employees = new ArrayList<>();
               PreparedStatement select;
         try {
             select = new DBConnexion().getCnx().prepareStatement
                            ("Select id,cin,nom,prenom,email,equipe_id from equipe full join Empolyee where equipe_id=Empolyee.equipe_id");
            ResultSet rs = select.executeQuery();
            
            while (rs.next()) {
                Employee e1 = new Employee();
                e1.setId(rs.getInt(1));
                e1.setCin(rs.getInt(2));
                e1.setNom(rs.getNString("nom"));
                e1.setPrenom(rs.getNString("prenom"));
                e1.setEmail(rs.getString("email"));
//                e1.setNum_equipe(rs.getInt(6));
//                e1.setService_nom(rs.getString("Service_nom"));
                e1.setEquipe_id(rs.getInt(6));
                Employees.add(e1);
            } 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }


       return Employees;
   }

  public static ArrayList<Employee> affiche_EMP_EQP(int i) {
        ArrayList<Employee> Employees = new ArrayList<>();
        PreparedStatement select;
        PreparedStatement select1;


        try {
             select = new DBConnexion().getCnx().prepareStatement
                            ("Select id,cin,nom,prenom,email,equipe_id from equipe full join Empolyee where equipe_id="+i+"");
            ResultSet rs = select.executeQuery();
            
            while (rs.next()) {
                Employee e1 = new Employee();
                e1.setId(rs.getInt(1));
                e1.setCin(rs.getInt(2));
                e1.setNom(rs.getNString("nom"));
                e1.setPrenom(rs.getNString("prenom"));
                e1.setEmail(rs.getString("email"));
                e1.setEquipe_id(rs.getInt(6));
                Employees.add(e1);
            } 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return Employees;
    }
  public static ObservableList<Employee> afficheEMP_OL()
  { 
             ObservableList<Employee> OL_Employee = FXCollections.observableArrayList();
           PreparedStatement Select;
        try {
            Select = new DBConnexion().getCnx().prepareStatement("Select * from Empolyee");
            
            ResultSet rs = Select.executeQuery();
               System.err.println("ERREUR RAHI LEHNE WIN ENTI TLAWEJ DEJA");   
            while(rs.next())
            {         System.err.println("ERREUR RAHI LEHNE WIN ENTI TLAWEJ DEJA");   
                     OL_Employee.add(new Employee(rs.getInt("id"), 
                                             rs.getInt("cin"),
                                             rs.getString("nom"), 
                                             rs.getString("prenom"), 
                                             rs.getString("email"),
                                             rs.getInt("equipe_id"),
                                             rs.getInt("num_equipe"),
                                             rs.getString("Service_nom"),
                                             rs.getInt("rating"),
                                             rs.getInt("tache_id")));
                   System.err.println("ERREUR RAHI LEHNE WIN ENTI TLAWEJ DEJA");   
            }
                } catch (SQLException ex) {
            System.err.println("ERREUR RAHI LEHNE WIN ENTI TLAWEJ DEJA");        }
    return OL_Employee;

  }
    public static ObservableList<Employee> affiche_EMP_EQP1(int i) {
        ArrayList<Employee> Employees = new ArrayList<>();
        PreparedStatement select;
        PreparedStatement select1;
                      ObservableList<Employee> OL_Employee = FXCollections.observableArrayList();


        try {
             select = new DBConnexion().getCnx().prepareStatement("Select * from Empolyee where equipe_id="+i+""); //("Select * from equipe full join Empolyee where equipe_id="+i+""
                            
            ResultSet rs = select.executeQuery();
            
           
          
            while(rs.next())
            {
                OL_Employee.add(new Employee(rs.getInt("id"), 
                                             rs.getInt("cin"),
                                             rs.getString("nom"), 
                                             rs.getString("prenom"), 
                                             rs.getString("email"),
                                             rs.getInt("equipe_id"),
                                             rs.getInt("num_equipe"),
                                             rs.getString("Service_nom"),
                                             rs.getInt("rating"),
                                             rs.getInt("tache_id")));
            }
                } catch (SQLException ex) {
            System.err.println(ex.getMessage());       
                }
   return OL_Employee;


}} 
    
 
    


