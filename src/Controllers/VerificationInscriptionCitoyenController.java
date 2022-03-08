/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class VerificationInscriptionCitoyenController implements Initializable {

    @FXML
    private Label email;
    @FXML
    private Hyperlink login;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public  void setEmail(String email)
    {
        this.email.setVisible(true);
        this.email.setText(email);
        
    }

    @FXML
    private void login(ActionEvent event) {
         try {
            Parent root;
            Stage primaryStage = null;
            root = FXMLLoader.load(getClass().getResource("/Views/CitoyenLogin.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("choix!");
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println("choix");
        } 
        catch (IOException ex) {
            System.out.println("Erreur " + ex.getMessage());
        }
    }
    
}
