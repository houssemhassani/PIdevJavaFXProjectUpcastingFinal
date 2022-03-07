/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DBConnexion;
import entities.Equipe;
import entities.Tache;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Moemen
 */
public class gererTache {

        
    public gererTache() {
    }
    
   public static void ajouterTache(int num_tache,String nom_tache,int needed_time, String Importance)
    {
        PreparedStatement select;
         ResultSet resultat;
         PreparedStatement insert;
         try {
            select= new DBConnexion().getCnx().prepareStatement("Select * from tache where num_tache="+num_tache+"");
            resultat=select.executeQuery();
            if(!resultat.isBeforeFirst())
            {
                insert=new DBConnexion().getCnx().prepareStatement("INSERT INTO tache (num_tache,nom_tache,needed_time,importance) values (?,?,?,?)");
                insert.setInt(1, num_tache);
                insert.setString(2, nom_tache);
                insert.setInt(3, needed_time);
                insert.setString(4, Importance);
                
                insert.executeUpdate();
                System.out.println("tache ajoutee");
            }
            else
                 System.err.println("tache existe");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
   
    
   public static void modifiertache(int num_tache)
    {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement update;
        try {
             select= new DBConnexion().getCnx().prepareStatement("Select * from tache where num_tache="+num_tache+"");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                update=new DBConnexion().getCnx().prepareStatement("Update tache set etat_tache=? where num_tache=?" );
                
                update.setString(1, "DONE");
                update.setInt(2, num_tache);
           
                update.executeUpdate();
                System.out.println("modification du tache effectué");
            }
            else
                System.err.println("er²reur ");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
   
   
   
     public static void supprimertache(int num_tache)
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
   
    //"Select id,cin,nom,prenom,email,equipe_id from equipe full join Empolyee where equipe_id=Empolyee.equipe_id"
    
       public static ObservableList<Tache> afficheTache_OL_affecter()
    {
           ObservableList<Tache> OL_Tache = FXCollections.observableArrayList();
           PreparedStatement Select;
        try {
            Select = new DBConnexion().getCnx().prepareStatement("Select * from Tache full join empolyee where id_tache=tache_id");
            ResultSet rs = Select.executeQuery();
                while(rs.next())
                {
                    OL_Tache.add(new Tache(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6)));
                }
            
            
            
        } catch (SQLException ex) {
            System.err.println("l'eerreur dans cette partie est"+ex.getMessage());
            }

        return     OL_Tache; 

    }
       
         public static ObservableList<Tache> afficheTache_OL()
    {
           ObservableList<Tache> OL_Tache = FXCollections.observableArrayList();
           PreparedStatement Select;
        try {
            Select = new DBConnexion().getCnx().prepareStatement("Select * from Tache");
            ResultSet rs = Select.executeQuery();
                while(rs.next())
                {
                    OL_Tache.add(new Tache(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7)));
                }
            
            
            
        } catch (SQLException ex) {
            System.err.println("l'eerreur dans cette partie est"+ex.getMessage());
            }

        return     OL_Tache; 

    }
       public static void affecter_Tache_EMP(int id_emp,int id_tache)
       {
        try {
            PreparedStatement Select = new DBConnexion().getCnx().prepareStatement("Select * from empolyee where id="+id_emp+"");
            ResultSet rs=Select.executeQuery();
            while (rs.next())
            {
                PreparedStatement update = new DBConnexion().getCnx().prepareStatement("update empolyee set tache_id=? where id=?");
                PreparedStatement update1 = new DBConnexion().getCnx().prepareStatement("update tache set emp_id=? where id_tache=?");
                update1.setInt(1,id_emp);
                update1.setInt(2, id_tache);
                update1.executeUpdate();
                
                update.setInt(1,id_tache);
                update.setInt(2,id_emp);
                update.executeUpdate();
                System.out.println("affectation de tache est effectué avec succes");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
           

       }
}
    

