/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Moemen
 */
public class Tache {
    int id_tache;
    int num_tache;
    String nom_tache;
    int needed_time;
    String etat_tache;
    String importance;
    int emp_id;

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }
    
    public int getId_tache() {
        return id_tache;
    }

    public void setId_tache(int id_tache) {
        this.id_tache = id_tache;
    }

   
    
    

    public int getNum_tache() {
        return num_tache;
    }

    public String getEtat_tache() {
        return etat_tache;
    }

    public void setEtat_tache(String etat_tache) {
        this.etat_tache = etat_tache;
    }

    public String getNom_tache() {
        return nom_tache;
    }

    public void setNom_tache(String nom_tache) {
        this.nom_tache = nom_tache;
    }

    public int getNeeded_time() {
        return needed_time;
    }

    public void setNeeded_time(int needed_time) {
        this.needed_time = needed_time;
    }

    @Override
    public String toString() {
        return "Tache{" + "id_tache=" + id_tache + ", num_tache=" + num_tache + ", nom_tache=" + nom_tache + ", needed_time=" + needed_time + ", etat_tache=" + etat_tache + ", importance=" + importance + ", emp_id=" + emp_id + '}';
    }

  public Tache()
  {
    }

   
    public Tache(String nom_tache, int needed_time, String etat_tache) {
        this.nom_tache = nom_tache;
        this.needed_time = needed_time;
        this.etat_tache = etat_tache;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public Tache(int id_tache, int num_tache, String nom_tache, int needed_time, String etat_tache, String importance) {
        this.id_tache = id_tache;
        this.num_tache = num_tache;
        this.nom_tache = nom_tache;
        this.needed_time = needed_time;
        this.etat_tache = etat_tache;
        this.importance = importance;
    }

    public void setNum_tache(int num_tache) {
        this.num_tache = num_tache;
    }

    public Tache(int id_tache, int num_tache, String nom_tache,int emp_id, int needed_time, String etat_tache, String importance) {
        this.id_tache = id_tache;
        this.num_tache = num_tache;
        this.nom_tache = nom_tache;
        this.needed_time = needed_time;
        this.etat_tache = etat_tache;
        this.importance = importance;
        this.emp_id = emp_id;
    }
    
    
    

   

 
    
    
    
    
    
}
