/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.demande;
import Utils.DBConnexion;
import com.sun.xml.internal.bind.v2.model.core.ID;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.gererdemande;
import Entities.demande;
import Utils.JavaMailUtil;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author hamza
 */
public class DemandeController implements Initializable {

   @FXML
    private TextField tfNUM;

    @FXML
    private TextField tfTYPE;

    @FXML
    private TextField tfDATE;

    @FXML
    private TextField tfCITOYEN;

    @FXML
    private TextField tfSERVICE;

    @FXML
    private Button btnajouter;

   @FXML
    private Button btnmodifier;
     @FXML
    private Button btnrefresh;
    @FXML
    private TextField tfID;
      @FXML
    private TextField filterFiled;

    
    @FXML
    private TableView<demande> table_demande;
    @FXML
    private TableColumn<demande, Integer> col_ID;
   
    @FXML
    private TableColumn<demande, Integer> col_numero;

    @FXML
    private TableColumn<demande, String> col_type;

    @FXML
    private TableColumn<demande, String> col_date;

    @FXML
    private TableColumn<demande, Integer> col_citoyen;

    @FXML
    private TableColumn<demande, Integer> col_service;
     
   
    
    /**
     * Initializes the controller class.
     */
   
    ObservableList<demande> oblist;
     ObservableList<demande> data;
    int index =-1;
    Connection conn =null;
    PreparedStatement pst =null;
    
    public void UpdateTable(){
    
       col_ID.setCellValueFactory(new PropertyValueFactory<demande,Integer>("id_demande"));  
       col_numero.setCellValueFactory(new PropertyValueFactory<demande,Integer>("num_demande"));
       col_type.setCellValueFactory(new PropertyValueFactory<demande,String>("type_demande"));
       col_date.setCellValueFactory(new PropertyValueFactory<demande,String>("date_demande"));
       col_citoyen.setCellValueFactory(new PropertyValueFactory<demande,Integer>("id_citoyen"));
       col_service.setCellValueFactory(new PropertyValueFactory<demande,Integer>("id_service"));
        oblist=DBConnexion.getDatademande();
        table_demande.setItems(oblist);
    
    
    
    
    
    
    
    
    
    }
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
      UpdateTable(); 
       
      
      
    }
    
   
    
    @FXML    
    void savedemande(ActionEvent event) {
    
      Connection conn =DBConnexion.connecterDB();
      String sql="insert into demande(num_demande,type_demande,date_demande,id_citoyen,id_service)values(?,?,?,?,?)";
        try {
            
            pst =conn.prepareStatement(sql);
            int num_demande = Integer.parseInt(tfNUM.getText());  
           
            String type_demande =tfTYPE.getText();
            String date_demande =tfDATE.getText();
    
     int id_citoyen = Integer.parseInt(tfCITOYEN.getText());
     int id_service = Integer.parseInt(tfSERVICE.getText());
     
     pst.setString(1, tfNUM.getText());
     pst.setString(2, tfTYPE.getText());
     pst.setString(3, tfDATE.getText());
     pst.setString(4, tfCITOYEN.getText());
     pst.setString(5, tfSERVICE.getText());
     
     
     pst.execute();
     JOptionPane.showMessageDialog(null, "demande ajoutée");
        UpdateTable(); 
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);        
        }
       
   
    
    }
    
    
   
    
    
   @FXML
    public void Edit(){
      
        try {
         
          Connection conn =DBConnexion.connecterDB();
         
            String value1 =tfID.getText();
            String value2 =tfNUM.getText();
            String value3 =tfTYPE.getText();
            String value4 =tfDATE.getText();
            String value5 =tfCITOYEN.getText();
            String value6 =tfSERVICE.getText();
            
   String sql="update demande set ID='"+value1+"',num_demande='"+value2+"',type_demande='"+value3+"',date_demande='"+value4+"',id_citoyen='"+value5+"',id_service='"+value6+"' where ID='"+value1+"'"        
           ; 
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
             UpdateTable(); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        
    }
    
   
    
        
    }
    
    @FXML
   public void Delete(){
   
   Connection conn =DBConnexion.connecterDB();
   String sql ="delete from demande where ID=?";
       try {
           pst = conn.prepareStatement(sql);
           pst.setString(1, tfID.getText());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
   
   
   }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
         index =table_demande.getSelectionModel().getSelectedIndex();
    if (index<=-1){
    
    return;
    }
    tfID.setText(col_ID.getCellData(index).toString());
    tfNUM.setText(col_numero.getCellData(index).toString());
    tfTYPE.setText(col_type.getCellData(index).toString());
    tfDATE.setText(col_date.getCellData(index).toString());
    tfCITOYEN.setText(col_citoyen.getCellData(index).toString());
    tfSERVICE.setText(col_service.getCellData(index).toString());
    
    }
    
    
    }
  
    
   

   
    
    
    
    
    

     
        

   
    
     
     

     
     
     
         
        
    

