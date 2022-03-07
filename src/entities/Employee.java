/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Asus
 */
public class Employee {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int cin;
    private int equipe_id;
    private int num_equipe; 
    private String Service_nom;
    private String mot_de_passe;
    private int rating;
    private int tache_id;
    

  
    public void setEquipe_id(int equipe_id) {
        this.equipe_id = equipe_id;
    }
    
    public int getNum_equipe() {
        return num_equipe;
    }

    public void setNum_equipe(int num_equipe) {
        this.num_equipe = num_equipe;
    }

    public Employee() {
    }


    public Employee(int id, int cin,String nom, String prenom, String email, int equipe_id, 
                                            int num_equipe,  String Service_nom, int rating, int tache_id) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.equipe_id = equipe_id;
        this.num_equipe = num_equipe;
        this.Service_nom = Service_nom;
        this.rating = rating;
        this.tache_id = tache_id;
    }

    
    

    public String getService_nom() {
        return Service_nom;
    }

    public void setService_nom(String Service_nom) {
        this.Service_nom = Service_nom;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getTache_id() {
        return tache_id;
    }

    public void setTache_id(int tache_id) {
        this.tache_id = tache_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getEquipe_id() {
        return equipe_id;
    }


 

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", cin=" + cin + ", equipe_id=" + equipe_id + ", num_equipe=" + num_equipe + ", Service_nom=" + Service_nom + ", mot_de_passe=" + mot_de_passe + ", rating=" + rating + ", tache_id=" + tache_id + '}';
    }

  

   

    

        
 

    
    
   
   
}
