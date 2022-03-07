/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Employee;
import Utils.DBConnexion;
import entities.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Moemen
 */
public class gererEquipe {

    public gererEquipe() {
    }

    public static void  ajouterEquipe(int num_equipe, String role_equipe) {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement insert;
        boolean i = false;
        
        try {
            select = new DBConnexion().getCnx().prepareStatement("Select * from equipe where num_equipe="+num_equipe+"");
            resultat = select.executeQuery();
            if (!resultat.isBeforeFirst()) {
                insert = new DBConnexion().getCnx().prepareStatement("INSERT INTO equipe (num_equipe,service_nom) values (?,?)");
                insert.setInt(1, num_equipe);
                insert.setString(2, role_equipe);

                insert.executeUpdate();
                System.out.println("equipe ajoutee");
                i = true;
            } else {
                System.err.println("equipe existe");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
  
        }
    }

    public static boolean ajouterEquipe_par3equipe(Equipe equipe) {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement insert;
        boolean i = false ;
        try {
            int id_equipe = equipe.getId_equipe();
            int num_equipe = equipe.getNum_equipe();
            String service_nom = equipe.getService_nom();

            select = new DBConnexion().getCnx().prepareStatement("Select * from equipe where num_equipe=" + num_equipe + "");
            resultat = select.executeQuery();
            if (!resultat.isBeforeFirst()) {
                insert = new DBConnexion().getCnx().prepareStatement("INSERT INTO equipe (num_equipe,service_nom) values (?,?)");
                insert.setInt(1, num_equipe);
                insert.setString(2, service_nom);

                insert.executeUpdate();
                System.out.println("equipe ajoutee");
                i = true;
            } else {
                System.err.println("equipe existe");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return i;
    }

    public static void modifierEquipe(int num_equipe, String Service_nom) {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement update;
        try {
            select = new DBConnexion().getCnx().prepareStatement("Select * from equipe where num_equipe=" +num_equipe+ "");
            resultat = select.executeQuery();
            if (resultat.isBeforeFirst()) {
                update = new DBConnexion().getCnx().prepareStatement("Update equipe set Service_nom=? where num_equipe=?");

                update.setString(1, Service_nom);
                update.setInt(2, num_equipe);

                update.executeUpdate();
                System.out.println("modification d'equipe effectué");
            } else {
                System.err.println("erreur ");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void supprimerEquipe(int num_equipe) {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement delete;
        try {
            select = new DBConnexion().getCnx().prepareStatement("Select * from equipe where num_equipe=" + num_equipe + "");
            resultat = select.executeQuery();
            if (resultat.isBeforeFirst()) {
                delete = new DBConnexion().getCnx().prepareStatement("Delete from equipe where num_equipe='" + num_equipe + "'");
                delete.executeUpdate();
                System.out.println("equipe supprimee");
            } else {
                System.err.println("failed");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void ajouterEmployeeEquipe(int id, int id_equipe) {
        PreparedStatement select;
        PreparedStatement select1;
        ResultSet resultat;
        ResultSet resultat1;
        PreparedStatement update;
        try {
            select = new DBConnexion().getCnx().prepareStatement("Select * from empolyee where id=" + id);
            select1 = new DBConnexion().getCnx().prepareStatement("Select * from equipe where id_equipe=" + id_equipe + "");
            
            resultat = select.executeQuery();
            resultat1 = select1.executeQuery();
            
            while (resultat.next() && resultat1.next())
            { int i = resultat1.getInt("nbre_emp");
                 i+=1;
                 int i1 = resultat.getInt("equipe_id");
                 if (i1 != 0)
                 {   PreparedStatement select2 = new DBConnexion().getCnx().prepareStatement("Select * from equipe where id_equipe=" + i + "");
                        ResultSet rs = select2.executeQuery();
                        while(rs.next())
                        {   int i2 = rs.getInt("nbre_emp");
                            i2 =i2-1;
                            PreparedStatement update2 = new DBConnexion().getCnx().prepareStatement("Update equipe set nbre_emp=? where id_equipe=?");
                            update2.setInt(1, i2);
                            update2.setInt(2, i1);
                            update2.executeUpdate();
                        }
                     
            
                                     }
            update = new DBConnexion().getCnx().prepareStatement("Update empolyee set equipe_id=?, Service_nom=?, num_equipe=? where id=?");
            PreparedStatement update1 = new DBConnexion().getCnx().prepareStatement("Update equipe set nbre_emp=? where id_equipe=?");
            
            update1.setInt(1, i);
            update1.setInt(2, id_equipe);
            update1.executeUpdate();
            
            update.setInt(1, id_equipe);
            update.setString(2, resultat1.getString("Service_nom"));
            update.setString(3, resultat1.getString("num_equipe"));

            update.setInt(4, id);
            update.executeUpdate();
            System.out.println("Empolyee added to team succecfully ");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<Equipe> afficherEquipe() {
        ArrayList<Equipe> Equipes = new ArrayList<>();
        PreparedStatement select;


        try {
            select = new DBConnexion().getCnx().prepareStatement("Select * from Equipe");
            ResultSet rs = select.executeQuery();
            
            while (rs.next()) {
                Equipe e1 = new Equipe();
                e1.setId_equipe(rs.getInt(1));
                e1.setNum_equipe(rs.getInt(2));
                e1.setService_nom(rs.getNString("Service_nom"));
                e1.setNbre_emp(rs.getInt(4));
                Equipes.add(e1);
            }

        } catch (SQLException ex) {
            System.err.println("ex.getMessage()");
        }

        return Equipes;
    }
    

    public static ObservableList<Equipe> afficheEquipe_OL()
    {
           ObservableList<Equipe> OL_Equipe = FXCollections.observableArrayList();
           PreparedStatement Select;
        try {
            Select = new DBConnexion().getCnx().prepareStatement("Select * from Equipe");
            ResultSet rs = Select.executeQuery();
                while(rs.next())
                {
                    OL_Equipe.add(new Equipe(
                                            rs.getInt(1), 
                                            rs.getInt(2), 
                                            rs.getString(3), 
                                            rs.getInt(4)));
                }
            
            
            
        } catch (SQLException ex) {
            System.err.println("l'eerreur dans cette partie est"+ex.getMessage());
            }

        return     OL_Equipe; 

    }
    public static int get_rating_equipe(int i)
    {int Names;
            int values=0;
            PreparedStatement select;
            int j = 0;
            int value = 0;
             int k = 0;
        try {
            
            select = new DBConnexion().getCnx().prepareStatement("Select * from Empolyee where equipe_id=" + i + "");
            ResultSet rs = select.executeQuery();

            while (rs.next()) {
                value = value + rs.getInt("rating");
                System.err.println(value);
                j++;

            }
           k = value / j;
            
        } catch (SQLException ex) {
        return k;        }
        return k;
         
    }  
}
