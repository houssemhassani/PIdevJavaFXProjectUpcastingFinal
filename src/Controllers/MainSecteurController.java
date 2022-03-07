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
import Entities.Secteur;

/**
 *
 * @author rachdi
 */
public class MainSecteurController implements Initializable {

    Secteur secteur;

    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfGouvernement;
    @FXML
    private TextField tfVille;
    @FXML
    private TextField tfCodePostal;
    @FXML
    private TableColumn<Secteur, Integer> colId;
    @FXML
    private TableColumn<Secteur, String> colGouvernement;
    @FXML
    private TableColumn<Secteur, String> colVille;
    @FXML
    private TableColumn<Secteur, String> colCodePostal;
    @FXML
    private TableView<Secteur> tvSecteur;
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
            if (tfGouvernement.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(null,"Gouvernement : champ obligaoire");
        }else if (tfVille.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"ville : champ obligaoire");
        }else if (tfVille.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"code postal : champ obligaoire");
        }else{
            insertRecord();
        }
            
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
        showSecteur();
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

    public ObservableList<Secteur> getSecteurList() {
        ObservableList<Secteur> secteurs = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM secteur";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Secteur secteur;
            while (rs.next()) {
                secteur = new Secteur(rs.getInt("id_secteur"), rs.getString("gouvernement"), rs.getString("ville"), rs.getString("code_postal"));

                secteurs.add(secteur);
            }

        } catch (SQLException ex) {
        }
        return secteurs;
    }

    public void showSecteur() {
        ObservableList<Secteur> list = getSecteurList();

        colId.setCellValueFactory(new PropertyValueFactory<>("id_secteur"));
        colGouvernement.setCellValueFactory(new PropertyValueFactory<>("gouvernement"));
        colVille.setCellValueFactory(new PropertyValueFactory<>("ville"));
        colCodePostal.setCellValueFactory(new PropertyValueFactory<>("code_postal"));

        tvSecteur.setItems(list);
    }

    private void insertRecord() throws SQLException {
        PreparedStatement p;

        String query = "INSERT INTO secteur(gouvernement,ville,code_postal) VALUES (" + "'" + tfGouvernement.getText() + "','" + tfVille.getText() + "','"
                + tfCodePostal.getText() + "')";
        p = getConnection().prepareStatement(query);
        p.executeUpdate();
        showSecteur();
    }

    private void updateRecord() {
        String query = "UPDATE secteur SET gouvernement  = '" + tfGouvernement.getText() + "', ville = '" + tfVille.getText() + "', code_postal = '" + tfCodePostal.getText() + "' WHERE id_secteur  = " + Integer.parseInt(tfId.getText()) + "";
        executeQuery(query);
        showSecteur();
    }

    private void deleteButton() {
        String query = "DELETE FROM secteur WHERE id_secteur  =" + tfId.getText() + "";
        executeQuery(query);
        showSecteur();
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
    private void OnSelect(MouseEvent event) {

        ObservableList<Secteur> r, f;
        f = tvSecteur.getSelectionModel().getSelectedItems();
        int id = 0;
        String gouvernement = null;
        String ville = null;
        String codePostal = null;
        for (Secteur A : f) {
            id = A.getId_secteur();
            gouvernement = A.getGouvernement();
            ville = A.getVille();
            codePostal = A.getCode_postal();

        }
        index = tvSecteur.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        tfId.setText(colId.getCellData(index).toString());
        tfGouvernement.setText(colGouvernement.getCellData(index).toString());
        this.tfVille.setText(ville);
        this.tfCodePostal.setText(codePostal);

    }

    @FXML
    private void MainMenuSwap(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        Parent root = FXMLLoader.load(getClass().getResource("Views/.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
