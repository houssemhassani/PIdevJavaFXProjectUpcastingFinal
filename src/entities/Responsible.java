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
public class Responsible {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String cin;
    private String email_confirmed;
    private String mot_de_passe;
    private String Service_nom;

    public Responsible() {
    }

 
    public Responsible(String nom, String prenom, String email, String cin, String email_confirmed, String mot_de_passe, String Service_nom) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.email_confirmed = email_confirmed;
        this.mot_de_passe = mot_de_passe;
        this.Service_nom = Service_nom;
    }

 

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getCin() {
        return cin;
    }

    public String getEmail_confirmed() {
        return email_confirmed;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setEmail_confirmed(String email_confirmed) {
        this.email_confirmed = email_confirmed;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getService_nom() {
        return Service_nom;
    }

    public void setService_nom(String Service_nom) {
        this.Service_nom = Service_nom;
    }

    @Override
    public String toString() {
        return "Responsable{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", cin=" + cin + ", email_confirmed=" + email_confirmed + ", mot_de_passe=" + mot_de_passe + '}';
    }
}
