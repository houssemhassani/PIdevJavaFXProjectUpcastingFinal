/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author rachdi
 */
public class Secteur {
    private int id_secteur;
    private String gouvernement;
    private String ville;
    private String code_postal;

    public Secteur(int id_secteur, String gouvernement, String ville, String code_postal) {
        this.id_secteur = id_secteur;
        this.gouvernement = gouvernement;
        this.ville = ville;
        this.code_postal = code_postal;
    }

    public int getId_secteur() {
        return id_secteur;
    }

    public String getGouvernement() {
        return gouvernement;
    }

    public String getVille() {
        return ville;
    }

    public String getCode_postal() {
        return code_postal;
    }
    
    
    
}
