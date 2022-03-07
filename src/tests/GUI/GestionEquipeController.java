/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tests.GUI;

import Entities.Employee;
import static Services.gererEmpolyee.afficheEMP_OL;
import static Services.gererEmpolyee.affiche_EMP_EQP1;
import Services.gererEquipe;
import static Services.gererEquipe.afficheEquipe_OL;
import static Services.gererEquipe.ajouterEmployeeEquipe;
import static Services.gererEquipe.get_rating_equipe;
import static Services.gererEquipe.modifierEquipe;
import static Services.gererEquipe.supprimerEquipe;
import Utils.DBConnexion;
import entities.Equipe;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Moemen
 */
public class GestionEquipeController implements Initializable {

    @FXML
    private TextField Num_Equipe;
    @FXML
    private TextField Service_Equipe;
    @FXML
    private Button EXIT_Button;
    @FXML
    private TableView<Equipe> Table_Equipe;
    @FXML
    private TableColumn<Equipe, String> ID_EQUIPE;
    @FXML
    private TableColumn<Equipe, String> SERVICE_EQUIPE;
    @FXML
    private TableColumn<Equipe, String> NBRE_EMP;
    @FXML
    private TableColumn<Equipe, String> NUM_EQUIPE;
    @FXML
    private TableColumn<Employee, Integer> ID_EMP;
    @FXML
    private TableColumn<Employee, String> NOM_EMP;
    @FXML
    private TableColumn<Employee, String> PRENOM_EMP;
    @FXML
    private TableColumn<Employee, Integer> CIN_EMP;
    @FXML
    private TableColumn<Employee, String> EMAIL_EMP;
    @FXML
    private TableColumn<Employee, Integer> EQUIPE_ID_EMP;
    @FXML
    private TableColumn<Employee, Integer> NUM_EQUIPE_EMP;
    @FXML
    private TableColumn<Employee, String> SERVICE_EMP;
    @FXML
    private TableColumn<Employee, Integer> RATING_EMP;
    @FXML
    private TableView<Employee> TABLE_EMP;
    @FXML
    private Button button_recherche_par_id;
    @FXML
    private TextField recherche_id_textfield;
    @FXML
    private Button clear_button;
    @FXML
    private TextField ID_EQUIPE_A_AJOUTER;
    @FXML
    private BarChart<String, Integer> char_bar;
    @FXML
    private TableColumn<Employee, Integer> TACHE_ID;
    @FXML
    private Rating rating_star;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {

        ID_EQUIPE.setCellValueFactory(new PropertyValueFactory<Equipe, String>("id_equipe"));
        NUM_EQUIPE.setCellValueFactory(new PropertyValueFactory<Equipe, String>("num_equipe"));
        SERVICE_EQUIPE.setCellValueFactory(new PropertyValueFactory<Equipe, String>("service_nom"));
        NBRE_EMP.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nbre_emp"));

        ID_EMP.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        CIN_EMP.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("cin"));
        NOM_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("nom"));
        PRENOM_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("prenom"));
        EMAIL_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        EQUIPE_ID_EMP.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("equipe_id"));
        NUM_EQUIPE_EMP.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("num_equipe"));
        SERVICE_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("Service_nom"));
        RATING_EMP.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("rating"));
        TACHE_ID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("tache_id"));

        ObservableList<Equipe> OL_Equipe = FXCollections.observableArrayList();
        ObservableList<Employee> OL_Employee = FXCollections.observableArrayList();
        OL_Equipe = afficheEquipe_OL();
        OL_Employee = afficheEMP_OL();
        Table_Equipe.setItems(OL_Equipe);
        TABLE_EMP.setItems(OL_Employee);

    }

    @FXML
    private void ajouterEquipe(ActionEvent event) {
        String  Numero = Num_Equipe.getText();
        String S_Nom = Service_Equipe.getText();
      

        Equipe E1 = new Equipe(Integer.parseInt(Numero), S_Nom);

        try {

            
                gererEquipe.ajouterEquipe(Integer.parseInt(Numero), S_Nom);
                ObservableList<Equipe> OL_Equipe = FXCollections.observableArrayList();
                OL_Equipe = afficheEquipe_OL();
                Table_Equipe.setItems(OL_Equipe);
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("succes.win.fxml"));

                Parent root = Loader.load();
                SucceswinController SWC = Loader.getController();
                SWC.setNumEquipe(Integer.toString(E1.getNum_equipe()));
                SWC.setServiceEquipe(E1.getService_nom());
                Stage newWindow = new Stage();
                newWindow.setTitle("RESULTAT D'OPERATION D'AJOUT");
                Scene scene = new Scene(root);
                newWindow.setScene(scene);
                newWindow.show();
          
            
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("numero equipe ou service nom, non valide");
            alert.setContentText("Veuillez remplir l'entrée avec un numero d'équipe  ou nom de service en bon format");

            alert.showAndWait();
        }

    }

    @FXML
//  

    private void EXIT(ActionEvent event) {
        Stage stage = (Stage) EXIT_Button.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void DELETE_EQUIPE(ActionEvent event) {

        try {
            int num_equipe = Table_Equipe.getSelectionModel().getSelectedItem().getNum_equipe();

            FXMLLoader Loader = new FXMLLoader(getClass().getResource("succes.win.fxml"));
            Parent root;
            root = Loader.load();
            SucceswinController SWC = Loader.getController();
            SWC.setNumEquipe(Integer.toString(Table_Equipe.getSelectionModel().getSelectedItem().getNum_equipe()));
            SWC.setServiceEquipe(Service_Equipe.getText());
            Stage newWindow = new Stage();
            newWindow.setTitle("RESULTAT D'OPERATION DE SUPPRESION");
            Scene scene = new Scene(root);
            newWindow.setScene(scene);
            newWindow.show();
            supprimerEquipe(num_equipe);
            ObservableList<Equipe> OL_Equipe = FXCollections.observableArrayList();
            OL_Equipe = afficheEquipe_OL();
            Table_Equipe.setItems(OL_Equipe);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    private void select_equipe(MouseEvent event) {
        Equipe e1 = new Equipe();
        e1 = Table_Equipe.getSelectionModel().getSelectedItem();
        int num_equipe = e1.getNum_equipe();
        String Service_nom = e1.getService_nom();
        Num_Equipe.setText(Integer.toString(num_equipe));
        Service_Equipe.setText(Service_nom);
        ID_EQUIPE_A_AJOUTER.setText(Integer.toString(e1.getId_equipe()));

    }

    @FXML
    private void EDIT_EQUIPE(ActionEvent event) {
        try {
            int num_equipe = Table_Equipe.getSelectionModel().getSelectedItem().getNum_equipe();
            String service_nom = Service_Equipe.getText();

            FXMLLoader Loader = new FXMLLoader(getClass().getResource("succes.win.fxml"));
            Parent root;
            root = Loader.load();
            SucceswinController SWC = Loader.getController();
            SWC.setNumEquipe(Integer.toString(num_equipe));
            SWC.setServiceEquipe(service_nom);
            Stage newWindow = new Stage();
            newWindow.setTitle("RESULTAT D'OPERATION DE SUPPRESION");
            Scene scene = new Scene(root);
            newWindow.setScene(scene);
            newWindow.show();
            modifierEquipe(num_equipe, service_nom);
            ObservableList<Equipe> OL_Equipe = FXCollections.observableArrayList();
            OL_Equipe = afficheEquipe_OL();
            Table_Equipe.setItems(OL_Equipe);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    private void CLEAR_TABLE_EMP(ActionEvent event) {
        TABLE_EMP.getItems().clear();
    }

    @FXML
    private void RECHERCHE_EMP_ID_EQUIPE(ActionEvent event) {
        String text = recherche_id_textfield.getText();

        if (text.matches("")) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Id d'equipe non valide");
            alert.setContentText("Veuillez remplir l'entrée avec un identifiant d'équipe au bon format");

            alert.showAndWait();
        } else if (text.matches("[0-9]*")) {
            TABLE_EMP.getItems().clear();
            TABLE_EMP.setItems(affiche_EMP_EQP1(Integer.parseInt(text)));

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Id d'equipe non valide");
            alert.setContentText("Veuillez remplir l'entrée avec un identifiant d'équipe au bon format");

            alert.showAndWait();

        }

    }

    @FXML
    private void GET_ALL_EMP_VIEW(ActionEvent event) {

        ObservableList<Employee> OL_Employee = FXCollections.observableArrayList();
        OL_Employee = afficheEMP_OL();
        TABLE_EMP.getItems().clear();
        TABLE_EMP.setItems(OL_Employee);
    }

    @FXML
    private void RATE_EMP(ActionEvent event) {

        int rating = (int) Math.round(rating_star.getRating());

        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement update;
        try {
            int i = TABLE_EMP.getSelectionModel().getSelectedItem().getId();
            select = new DBConnexion().getCnx().prepareStatement("Select * from Empolyee where id=" + i + "");
            resultat = select.executeQuery();
            if (resultat.isBeforeFirst()) {
                update = new DBConnexion().getCnx().prepareStatement("Update Empolyee set rating=? where id=?");

                update.setInt(1, rating);
                update.setInt(2, i);

                update.executeUpdate();
                System.out.println("Rating of the mployee has been success done");
            } else {
                System.err.println("erreur ");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @FXML
    private void SET_EMP_TEAM_ID(ActionEvent event) {

        ajouterEmployeeEquipe(TABLE_EMP.getSelectionModel().getSelectedItem().getId(), Table_Equipe.getSelectionModel().getSelectedItem().getId_equipe());
        ObservableList<Equipe> OL_Equipe = FXCollections.observableArrayList();
        ObservableList<Employee> OL_Employee = FXCollections.observableArrayList();
        OL_Equipe = afficheEquipe_OL();
        OL_Employee = afficheEMP_OL();
        Table_Equipe.setItems(OL_Equipe);
        TABLE_EMP.setItems(OL_Employee);

    }

    @FXML
    private void gestion_de_tache_button(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("gestionTaches.fxml"));
        Parent root;
        try {
            root = Loader.load();
            GestionTachesController GTC = Loader.getController();
            Stage newWindow = new Stage();
            newWindow.setTitle("GESTION DE TACHE");
            Scene scene = new Scene(root);
            newWindow.setScene(scene);
            newWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean isNumeric(String string) {
        int intValue;

        System.out.println(String.format("Parsing string: \"%s\"", string));

        if (string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    @FXML
    private void get_stat_equipe(ActionEvent event) {

     int rate_equipe = get_rating_equipe(Table_Equipe.getSelectionModel().getSelectedItem().getId_equipe());
           String Name_equipe = Integer.toString(Table_Equipe.getSelectionModel().getSelectedItem().getNum_equipe());
//            CategoryAxis xAxis = new CategoryAxis();
//            xAxis.setLabel("Nom");
//            NumberAxis yAxis = new NumberAxis();
//            yAxis.setLabel("Evaluation");
//            BarChart BC = new BarChart(xAxis,yAxis);
//            char_bar = BC;
           if( rate_equipe != 0)
           {
               XYChart.Series DS1 = new XYChart.Series();
                DS1.getData().add(new XYChart.Data(Name_equipe, rate_equipe));
            
            char_bar.getData().addAll(DS1);
           }
//            DS1.setName("Employees Table");
            
               

    
        

    }

    @FXML
    private void get_stat_emp(ActionEvent event) {
        try {
            ArrayList<String> Names = new ArrayList<>();
            ArrayList<Integer> Values = new ArrayList<>();
            PreparedStatement select;
            select = new DBConnexion().getCnx().prepareStatement("Select * from Empolyee");
            ResultSet rs = select.executeQuery();

            while (rs.next()) {

                Names.add(rs.getString("prenom"));
                Values.add(rs.getInt("rating"));
                System.out.println(rs.getString("prenom"));
            }
//            CategoryAxis xAxis = new CategoryAxis();
//            xAxis.setLabel("Nom");
//            NumberAxis yAxis = new NumberAxis();
//            yAxis.setLabel("Evaluation");
//            BarChart BC = new BarChart(xAxis,yAxis);
//            char_bar = BC;
            XYChart.Series DS1 = new XYChart.Series();
//            DS1.setName("Employees Table");
            for (int i = 0; i < Names.size(); i++) {
                DS1.getData().add(new XYChart.Data(Names.get(i), Values.get(i)));
            }
            char_bar.getData().clear();
            char_bar.getData().addAll(DS1);

        } catch (SQLException ex) {
            System.err.println("ex.getMessage()");
        }
    }
}
