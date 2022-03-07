/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tests.GUI;

import static Services.gererTache.afficheTache_OL;
import static Services.gererTache.modifiertache;
import entities.Equipe;
import entities.Tache;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Moemen
 */
public class Emp_Taches_viewController implements Initializable {

    @FXML
    private TableView<Tache> taches_view_table;
    @FXML
    private Button EXIT_Button;
    @FXML
    private TableColumn<Tache, String> id_tache;
    @FXML
    private TableColumn<Tache, String> num_tache;
    @FXML
    private TableColumn<Tache, String> nom_tache;
    @FXML
    private TableColumn<Tache, String> emp_id;
    @FXML
    private TableColumn<Tache, String> temps_aloué;
    @FXML
    private TableColumn<Tache, String> etat_tache;
    @FXML
    private TableColumn<Tache, String> importance;
    @FXML
    private Label id_emp_a_afficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      id_tache.setCellValueFactory(new PropertyValueFactory<Tache, String>("id_tache"));
        num_tache.setCellValueFactory(new PropertyValueFactory<Tache, String>("num_tache"));
        nom_tache.setCellValueFactory(new PropertyValueFactory<Tache, String>("nom_tache"));
        emp_id.setCellValueFactory(new PropertyValueFactory<Tache, String>("emp_id"));
        temps_aloué.setCellValueFactory(new PropertyValueFactory<Tache, String>("needed_time"));
        etat_tache.setCellValueFactory(new PropertyValueFactory<Tache, String>("etat_tache"));
        importance.setCellValueFactory(new PropertyValueFactory<Tache, String>("importance"));
        ObservableList<Tache> OL_Tache = FXCollections.observableArrayList();
        OL_Tache = afficheTache_OL();
        taches_view_table.setItems(OL_Tache);
        
    }    

    @FXML
    private void EXIT(ActionEvent event) {
        Stage stage = (Stage) EXIT_Button.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void modifier_etat_tache(ActionEvent event) {
        
        modifiertache(taches_view_table.getSelectionModel().getSelectedItem().getNum_tache());
        ObservableList<Tache> OL_Tache = FXCollections.observableArrayList();
        OL_Tache = afficheTache_OL();
        taches_view_table.setItems(OL_Tache);
        
    }

    
}
