/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tests.GUI;

import Entities.Employee;
import static Services.gererEmpolyee.afficheEMP_OL;
import static Services.gererEquipe.afficheEquipe_OL;
import static Services.gererTache.affecter_Tache_EMP;
import static Services.gererTache.afficheTache_OL;
import static Services.gererTache.ajouterTache;
import static Services.gererTache.supprimertache;
import entities.Tache;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Moemen
 */
public class GestionTachesController implements Initializable {

    @FXML
    private TableColumn<Employee, String> ID_EMP;
    @FXML
    private TableColumn<Employee, String> NOM_EMP;
    @FXML
    private TableColumn<Employee, String> PRENOM_EMP;
    @FXML
    private TableColumn<Employee, String> CIN_EMP;
    @FXML
    private TableColumn<Employee, String> EMAIL_EMP;
    @FXML
    private TableColumn<Employee, String> EQUIPE_ID_EMP;
    @FXML
    private TableColumn<Employee, String> NUM_EQUIPE_EMP;
    @FXML
    private TableColumn<Employee, String> SERVICE_EMP;
    @FXML
    private TableColumn<Employee, Integer >RATING_EMP;
    @FXML
    private TableView<Employee> TABLE_EMP;
    @FXML
    private TableView<Tache> taches_view_table;
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
    private Button Exit_button;
    @FXML
    private ComboBox<String> Importance_box;
    @FXML
    private TextField NUM_tache_TF;
    @FXML
    private TextField NOM_tache_TF;
    @FXML
    private Spinner<Integer> TEMPS_allloué_S;
    @FXML
    private TextField id_emp_a_affecter_TF;
    @FXML
    private TextField NUM_tache_a_affecter_TF;
    @FXML
    private TableColumn<Employee, String> TACHE_ID;

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
        
      
        ID_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
        CIN_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("cin"));
        NOM_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("nom"));
        PRENOM_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("prenom"));
        EMAIL_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        EQUIPE_ID_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("equipe_id"));
        NUM_EQUIPE_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("num_equipe"));
        SERVICE_EMP.setCellValueFactory(new PropertyValueFactory<Employee, String>("Service_nom"));
        RATING_EMP.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("rating"));
       TACHE_ID.setCellValueFactory(new PropertyValueFactory<Employee, String>("tache_id"));
        ObservableList<Employee> OL_Employee = FXCollections.observableArrayList();
         
            OL_Employee = afficheEMP_OL();
            TABLE_EMP.setItems(OL_Employee);
            
            
           Importance_box.getItems().addAll("Pas de priorité", "Priorité basse", "Priorité moyenne", "Priorité élevée", "Urgent");
           Importance_box.getSelectionModel().select("Pas de priorité");
           SpinnerValueFactory<Integer> valuefactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,7);
           valuefactory.setValue(1);
           TEMPS_allloué_S.setValueFactory(valuefactory);

    
    }    

    @FXML
    private void ADD_Tache(ActionEvent event) {
//        System.out.println(NOM_tache_TF.getText());
//        System.out.println(Integer.parseInt(num_tache.getText()));
//        System.out.println(TEMPS_allloué_S.getValue());
//        System.out.println(Importance_box.getValue());
        ajouterTache(Integer.parseInt(NUM_tache_TF.getText())
                    ,NOM_tache_TF.getText()
                    ,TEMPS_allloué_S.getValue()
                    ,Importance_box.getValue()
                     );
        ObservableList<Tache> OL_Tache = FXCollections.observableArrayList();
        OL_Tache = afficheTache_OL();
        taches_view_table.setItems(OL_Tache);
    
    }


    @FXML
    private void DELETE_Tache(ActionEvent event) {
        supprimertache(taches_view_table.getSelectionModel().getSelectedItem().getNum_tache());
        ObservableList<Tache> OL_Tache = FXCollections.observableArrayList();
        OL_Tache = afficheTache_OL();
        ObservableList<Employee> OL_Employee = FXCollections.observableArrayList();
         
            OL_Employee = afficheEMP_OL();
            TABLE_EMP.setItems(OL_Employee);
            taches_view_table.setItems(OL_Tache);
    }

    @FXML
    private void EXIT(ActionEvent event) {
          Stage stage = (Stage) Exit_button.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void RENOTIFICATION_ACTION(ActionEvent event) {
        int id = taches_view_table.getSelectionModel().getSelectedItem().getId_tache();
           String text1 = "la tache";
           String text2 = Integer.toString(id);
           String text3= "n'est pas encore traité" ;
           String text4= text1+" n: "+text2+" "+text3;
           System.err.println(text4);
        Notifications notificationBuilder; 
        notificationBuilder = Notifications.create().
                title("Notification").text(text4).graphic(null).
                hideAfter(javafx.util.Duration.seconds(5)).
                position(Pos.CENTER_LEFT).onAction
                                    (new EventHandler<ActionEvent>()
                                    { public void handle(ActionEvent event) {
                                        System.out.println("clicked on "); 
                                    }});
                                notificationBuilder.darkStyle();  
                                notificationBuilder.show();
        
    }

    @FXML
    private void ADD_Tache_EMP(ActionEvent event) {
        affecter_Tache_EMP(
                TABLE_EMP.getSelectionModel().getSelectedItem().getId()
                ,taches_view_table.getSelectionModel().getSelectedItem().getId_tache());
                ObservableList<Employee> OL_Employee = FXCollections.observableArrayList();
         
            OL_Employee = afficheEMP_OL();
            TABLE_EMP.setItems(OL_Employee);
            
            ObservableList<Tache> OL_Tache = FXCollections.observableArrayList();
        OL_Tache = afficheTache_OL();
        taches_view_table.setItems(OL_Tache);
//        int id = taches_view_table.getSelectionModel().getSelectedItem().getId_tache();
//        String text2 = Integer.toString(id);
//        System.err.println(text2);
//        String text = "La tache num:"+text2+"  est affecter pour vous. Veuillez la faire dans le temps imparti et merci"; 
                 Notifications notificationBuilder; 
        notificationBuilder = Notifications.create().
                title("Notification").text("vous avez une tâche qui n'est pas traitée, merci de la traiter dans le temps demandé").graphic(null).
                hideAfter(javafx.util.Duration.seconds(5)).
                position(Pos.CENTER_LEFT).onAction
                                    (new EventHandler<ActionEvent>()
                                    { public void handle(ActionEvent event) {
                                        System.out.println("clicked on "); 
                                    }});
                                notificationBuilder.darkStyle();  
                                notificationBuilder.show();
        
    }

    @FXML
    private void select_tache(MouseEvent event) {
         NUM_tache_TF.setText(Integer.toString(taches_view_table.getSelectionModel().getSelectedItem().getNum_tache()));
         NOM_tache_TF.setText(taches_view_table.getSelectionModel().getSelectedItem().getNom_tache());
         NUM_tache_a_affecter_TF.setText(Integer.toString(taches_view_table.getSelectionModel().getSelectedItem().getNum_tache()));
    }

    @FXML
    private void get_emp_id_selection(MouseEvent event) {
        id_emp_a_affecter_TF.setText(Integer.toString(TABLE_EMP.getSelectionModel().getSelectedItem().getId()));
         
    }
    
}
