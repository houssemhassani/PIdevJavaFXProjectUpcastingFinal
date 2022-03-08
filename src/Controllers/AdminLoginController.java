/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import org.hibernate.cfg.AnnotationConfiguration;
 import org.hibernate.SessionFactory;
import Services.AdminLoginService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdminLoginController implements Initializable {

    @FXML
    private TextField cin;
    @FXML
    private PasswordField mdp;
    @FXML
    private Hyperlink MdpOublié;
    public static String cinn;
    @FXML
    private AnchorPane inscrippane;
    @FXML
    private Label cinlable;
    @FXML
    private Button btnlogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    public void MdpOublié(ActionEvent event) throws IOException
    {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/MDPOunliéeAdmin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Mot de passe oublié !");
        primaryStage.setScene(scene);
        primaryStage.show();  
       
    }

    @FXML
    private void seConnecter(ActionEvent event) throws IOException {
         AdminLoginService s=new AdminLoginService();
         if (this.cin.getText().equals("") || this.mdp.getText().equals(""))
        {
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("l'un de champs est vide");
            a.setTitle("Vide!!");
            a.show();
            this.cin.setText("");
            this.mdp.setText("");
            return;
        }
        if(s.seConnecter(cin.getText(), mdp.getText())) {
            try {
                System.out.println("cin ; "+cin.getText());
            Parent root;
            cinn=cin.getText();
            Stage primaryStage=new Stage();
            root = FXMLLoader.load(AdminLoginService.class.getResource("/Views/GérerProfilAdmin.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("choix!");
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println("choix");
            
                
        } 
        catch (IOException ex) {
            System.out.println("Erreur " + ex.getMessage());
        }
            }
        else
        {
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Mot de Passe ou cin incorrecte");
            a.setTitle("Attention !! ");
            a.show();
            this.cin.setText("");
            this.mdp.setText("");
            return ;
        }
    }
    
}