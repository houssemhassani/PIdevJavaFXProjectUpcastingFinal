/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_pidev;

import Entities.Responsable;
import Services.AdminLoginService;
import Services.EmployeeLoginService;
import Services.GererResponsableService;
import Services.GestionReclamation;
import Utils.DBConnexion;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // EmployeeLoginService e=new EmployeeLoginService();
        //System.out.println(e.modifierMotDePasse("06996868", "nouveau_mot_de_passe"));
       /* GererResponsableService v =  new  GererResponsableService();
            
            ArrayList<Responsable> arrayList=v.getResponsables();
            for(Responsable e:arrayList)
            {
                System.out.println(e.toString());
            }*/
        //AdminLoginService.modifierMotDePasse("123456", "mot_de_passe");
    }
    //DBConnexion.getConnexion();
        
//       GestionReclamation.ajouterReclamation( 9,"facture","telecom","bizerte", 16);
//      GestionReclamation.ajouterReclamation(2,"Soned","facture", "Hammamet", 2);
//      GestionReclamation.modefierReclamationVille(2 ,"nabeul");
//        GestionReclamation.supprimerReclamation(7);
//         GestionReclamation.modefierReclamationType(22, "devis");
//        GestionReclamation.modefierReclamationDescription(3, "STEG ******");
//        GestionReclamationResponsable.modefierEtat(15, "traitéé");
    
}
