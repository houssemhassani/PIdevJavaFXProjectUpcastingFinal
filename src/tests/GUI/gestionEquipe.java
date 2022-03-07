/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package tests.GUI;

import entities.Equipe;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Moemen
 */
public class gestionEquipe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                
                

                
        
    
        Parent root;
      try {            //       "emp_Taches_view.fxml""gestionEquipe.fxml"
            root = FXMLLoader.load(getClass().getResource("gestionEquipe.fxml"));
               Scene scene = new Scene(root);
        
        primaryStage.setTitle("Gestion d'Equipe");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
