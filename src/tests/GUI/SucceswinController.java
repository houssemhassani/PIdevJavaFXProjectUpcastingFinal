/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tests.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Moemen
 */
public class SucceswinController implements Initializable {

    @FXML
    private TextField Num_Equipe;
    @FXML
    private TextField Service_Equipe;
    @FXML
    private Button Exit_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Num_Equipe.setEditable(false);
        Service_Equipe.setEditable(false);

    }    
public void setNumEquipe(String message)
{
    this.Num_Equipe.setText(message);
}
public void setServiceEquipe(String message)
{
    this.Service_Equipe.setText(message);
}

    @FXML
    private void EXIT(ActionEvent event) {
        Stage stage = (Stage) Exit_button.getScene().getWindow();
        stage.close();
    }
}
