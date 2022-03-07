/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author rachdi
 */
public class MenuController implements Initializable {

    @FXML
    private Button close;
    @FXML
    private Button gestionSecteur;
    @FXML
    private Button gestionService;
    @FXML
    private ImageView Exit;
    @FXML
    private Button dashboard;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuBack;
    @FXML
    private ImageView MenuClose;
    @FXML
    private AnchorPane slider;
    @FXML
    private Button dashboard1;
    @FXML
    private Button gestionService1;
    @FXML
    private Button gestionSecteur1;
    @FXML
    private Button gestionLocalisation1;
    @FXML
    private Button gestionLocalisation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Exit.setOnMouseClicked(event ->{
            System.exit(0);
        });
        slider.setTranslateX(-176);
        Menu.setOnMouseClicked(event ->{
           TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(false);
                MenuBack.setVisible(true);
            });
        });
        MenuBack.setOnMouseClicked(event ->{
           TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(true);
                MenuBack.setVisible(false);
            });
        });
    } 
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException,IOException {        
        
        if(event.getSource() == close){
            close();
        }else if (event.getSource() == gestionSecteur){
            gestionSecteur(event);
        }else if(event.getSource() == gestionService){
            gestionService(event);
        }
        else if(event.getSource() == dashboard){
            Dashboard(event);
        }
        else if(event.getSource() == slider){
            close();
        }
        else if(event.getSource() == dashboard1){
            Dashboard(event);
        }
        else if (event.getSource() == gestionSecteur1){
            gestionSecteur(event);
        }else if(event.getSource() == gestionService1){
            gestionService(event);
        }
        else if(event.getSource() == MenuClose){
            close();        
        }
        
        
    }

    private void close() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();

    }

    private void gestionSecteur(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Views/MainSecteur.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


        private void gestionService(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/MainService.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
        
        private void Dashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    private void gestionLocalisation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/MainLocalisation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
        
        
    
}
