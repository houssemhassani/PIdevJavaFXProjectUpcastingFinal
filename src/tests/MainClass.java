/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Entities.Employee;
import Services.gererEmpolyee;
import static Services.gererEmpolyee.afficheEMP_OL;
import static Services.gererEmpolyee.affiche_EMP_EQP;
import static Services.gererEmpolyee.affiche_EMP_EQP1;
import static Services.gererEmpolyee.afficherEmployee;
import static Services.gererEmpolyee.afficherEmployee_parEquipe;
import Services.gererEquipe;
import Services.gererTache;
import static Services.gererTache.ajouterTache;
import Utils.DBConnexion;
import Services.gererEquipe;
import static Services.gererEquipe.afficheEquipe_OL;
import static Services.gererEquipe.afficherEquipe;
import static Services.gererEquipe.ajouterEmployeeEquipe;
import static Services.gererEquipe.ajouterEquipe;
import static Services.gererEquipe.ajouterEquipe_par3equipe;
import static Services.gererEquipe.get_rating_equipe;
import static Services.gererEquipe.modifierEquipe;
import static Services.gererTache.affecter_Tache_EMP;
import static Services.gererTache.afficheTache_OL;
import static Services.gererTache.afficheTache_OL_affecter;
import entities.Equipe;



/**
 *
 * @author Moemen
 */
public class MainClass {
    public static void main(String[] args) {
//        DBConnexion DBC;
//        DBC = new DBConnexion();
//        Equipe e2 = new Equipe();
//        Employee emp1 = new Employee("zafefefb", "moemen", "moemen.zaghbib@esprit.tn", 11410515, 2);
//        Employee emp2 = new Employee("zafefefb", "moemen", "moemen.zaghbib@esprit.tn", 11410515, 2);
//        Employee emp3 = new Employee("zafefefb", "moemen", "moemen.zaghbib@esprit.tn", 11410515, 2);
//        Employee emp4 = new Employee("zafefefb", "moemen", "moemen.zaghbib@esprit.tn", 11410515, 2);
//        Employee emp5 = new Employee("zafefefb", "moemen", "moemen.zaghbib@esprit.tn", 11410515, 2);




///         ajouterTache(1,"tachetest1",20);
////        gererTache.modifiertache(1, "DONE");
//       Equipe equipe1 = new Equipe("servicedfezfzef payement", 0);
////        //gererTache.supprimertache(1);
//         ajouterEquipe_par3equipe(equipe1);
//        gererEmpolyee.ajouterEmployee(123345, "moemen", "hcin", "ull", "null");
//        System.out.println(afficherEquipe());
//          System.out.println(afficherEmployee());
//                      System.out.println(afficherEmployee_parEquipe());
                      //ajouterEmployeeEquipe(2,2);
//             System.out.println(afficheEquipe_OL());
//                System.out.println(afficheTache_OL());
//                affecter_Tache_EMP(3,3); 
// ajouterTache(2,"test",4,"Importance");
        
        
        
        Employee e1 = new Employee(1,2,"fff","fff","fff",2, 
                                            3,"ddd",2, 3);
        e1.toString();
    }
    


}
