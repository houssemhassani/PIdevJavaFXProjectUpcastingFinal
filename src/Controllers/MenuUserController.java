 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import Entities.Secteur;
import Entities.Service;

/**
 * FXML Controller class
 *
 * @author rachdi
 */
public class MenuUserController implements Initializable {

    @FXML
    private ComboBox<String> cbService;
    @FXML
    private ComboBox<String> cbSecteur;
    @FXML
    private WebView wvUser;
    private WebEngine engine;
    @FXML
    private ImageView tribunal;
    @FXML
    private ImageView municipalite;
    @FXML
    private ImageView Exit;
    @FXML
    private Button dashboard1;
    @FXML
    private Button gestionService1;
    @FXML
    private Button gestionLocalisation1;
    @FXML
    private Button gestionSecteur1;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuBack;
    @FXML
    private ImageView MenuClose;
    @FXML
    private AnchorPane slider;
    @FXML
    private Button gestionSecteur;
    @FXML
    private Button dashboard;
    @FXML
    private Button gestionService;
    @FXML
    private Button gestionLocalisation;
    @FXML
    private Button close;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateService();    
        populateSecteur();
        engine = wvUser.getEngine();
        Exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        slider.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(false);
                MenuBack.setVisible(true);
            });
        });
        MenuBack.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(true);
                MenuBack.setVisible(false);
            });
        });
        
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev", "root", null);
            System.out.println(conn.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return conn;
    }

    private ObservableList<String> getNomServiceList() {
        ObservableList<String> services = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT nomService FROM service";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Service service;
            while (rs.next()) {
                service = new Service(rs.getInt("id"),rs.getString("nomService"));
                services.add(service.getNomService());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return services;
    }
    
    private void populateService() {
        Connection conn = getConnection();
        Statement st;
        ObservableList<String> services = FXCollections.observableArrayList();
        try {
            
            ResultSet rs = conn.createStatement().executeQuery("select nomService from service");
            while (rs.next()) {
                services.add(rs.getString("nomService"));
            }

        } catch (Exception ex) {
            System.out.println("error while inserting record.");
            ex.printStackTrace();
        }

        cbService.setItems(null);
        cbService.setItems(services);

    }
    
    
    private ObservableList<String> getGouvernemetList() {
        ObservableList<String> secteurs = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT gouvernement FROM secteur";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Secteur secteur;
            while (rs.next()) {
                secteur = new Secteur(rs.getInt("id"),rs.getString("gouvernement"),rs.getString("ville"),rs.getString("code_postal"));
                secteurs.add(secteur.getGouvernement());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return secteurs;
    }
    
    private void populateSecteur() {
        Connection conn = getConnection();
        Statement st;
        ObservableList<String> secteurs = FXCollections.observableArrayList();
        try {
            
            ResultSet rs = conn.createStatement().executeQuery("select gouvernement from secteur");
            while (rs.next()) {
                secteurs.add(rs.getString("gouvernement"));
            }

        } catch (Exception ex) {
            System.out.println("error while inserting record.");
            ex.printStackTrace();
        }

        cbSecteur.setItems(null);
        cbSecteur.setItems(secteurs);

    }

    private void loadPage() {
        engine.load("https://www.google.com/maps/search/"+cbService.getValue()+"+"+cbSecteur.getValue()+"/");
        
        
    }
    

    
    @FXML
    private void getComboBoxInfo(ActionEvent event) {
        
        loadPage();

                

        
        
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == gestionSecteur) {
            gestionSecteur(event);
        } else if (event.getSource() == gestionService) {
            gestionService(event);
        } else if (event.getSource() == dashboard) {
            Dashboard(event);
        } else if (event.getSource() == slider) {
            close();
        } else if (event.getSource() == dashboard1) {
            Dashboard(event);
        } else if (event.getSource() == gestionSecteur1) {

            gestionSecteur(event);

        } else if (event.getSource() == gestionService1) {
            gestionService(event);
        } else if (event.getSource() == MenuClose) {
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
    

}
