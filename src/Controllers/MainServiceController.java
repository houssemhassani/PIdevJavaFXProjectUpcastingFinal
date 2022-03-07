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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import Entities.Service;

/**
 *
 * @author rachdi
 */
public class MainServiceController implements Initializable {

    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNomService;

    @FXML
    private TableColumn<Service, String> colService;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Service> tvServices;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private Button btnRetour;
    private Button btnClose;
    @FXML
    private ImageView Exit;
    @FXML
    private Button dashboard1;
    @FXML
    private Button gestionService1;
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
    private Button close;

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {

        if (event.getSource() == btnInsert) {
            if (tfNomService.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Content : champ obligaoire");
            } else {
                insertRecord();}
        } else if (event.getSource() == btnUpdate) {
            updateRecord();
        } else if (event.getSource() == btnDelete) {
            deleteButton();
        } else if (event.getSource() == gestionSecteur) {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showservice();
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

    public ArrayList<Service> getserviceList() {
        ArrayList<Service> bookList = new ArrayList<>();
        Connection conn = getConnection();
        String query = "SELECT * FROM service";
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement(query);
            rs = st.executeQuery();

            while (rs.next()) {
                Service service = new Service(rs.getInt("id"), rs.getString("nomService"));
                bookList.add(service);
            }

        } catch (SQLException ex) {
        }
        return bookList;
    }

    public void showservice() {
        ArrayList<Service> arrayList = getserviceList();
        ObservableList observablelist = FXCollections.observableArrayList(arrayList);
        this.tvServices.setItems(observablelist);
        this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colService.setCellValueFactory(new PropertyValueFactory<>("nomService"));

    }

    private void insertRecord() throws SQLException {
        PreparedStatement p;

        String query = "INSERT INTO service(nomService) VALUES ('" + tfNomService.getText() + "')";
        p = getConnection().prepareStatement(query);
        p.executeUpdate();
        showservice();
        tfId.clear();
        tfNomService.clear();
    }

    private void updateRecord() {
        String query = "UPDATE  service SET nomService  = " + tfNomService.getText() + " WHERE id = '" + tfId.getText() + "'";
        executeQuery(query);
        showservice();
        tfId.clear();
        tfNomService.clear();
    }

    private void deleteButton() {
        String query = "DELETE FROM service WHERE id =" + tfId.getText() + "";
        executeQuery(query);
        showservice();
        tfId.clear();
        tfNomService.clear();

    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    int index;

    @FXML
    private void getSelected(MouseEvent event) {
        ObservableList<Service> r, f;
        f = tvServices.getSelectionModel().getSelectedItems();
        int id = 0;
        String nomService = null;
        for (Service A : f) {
            id = A.getIdService();
            nomService = A.getNomService();
        }

        if (index <= -1) {

            return;
        }
        tfId.setText(String.valueOf(id));
        this.tfNomService.setText(nomService);
    }

    @FXML
    private void MainMenuSwap(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void closeButton(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    private void Close(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
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
