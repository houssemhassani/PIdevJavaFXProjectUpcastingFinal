/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ghassen-pc
 */
public class Main extends  Application{
    @Override
    public  void start (Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Controllers/test.fxml"));
            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
