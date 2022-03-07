
package entities;

/**
 *
 * @author Moemen
 */
public class Equipe {
    int id_equipe;
    int num_equipe;

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }
    String Service_nom;
    int nbre_emp;

    public Equipe() {
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public Equipe(int id_equipe, int num_equipe, String Service_nom, int nbre_emp) {
        this.id_equipe = id_equipe;
        this.num_equipe = num_equipe;
        this.Service_nom = Service_nom;
        this.nbre_emp = nbre_emp;
    }


    public int getNum_equipe() {
        return num_equipe;
    }

    public void setNom_equipe(int num_equipe) {
        this.num_equipe = num_equipe;
    }

   
    public int getNbre_emp() {
        return nbre_emp;
    }

    public void setNbre_emp(int nbre_emp) {
        this.nbre_emp = nbre_emp;
    }


    public void setNum_equipe(int num_equipe) {
        this.num_equipe = num_equipe;
    }

    public String getService_nom() {
        return Service_nom;
    }

    public void setService_nom(String Service_nom) {
        this.Service_nom = Service_nom;
    }

    public Equipe(int num_equipe, String Service_nom) {
        this.num_equipe = num_equipe;
        this.Service_nom = Service_nom;
    }

    

    @Override
    public String toString() {
        return "Equipe{" + "id_equipe=" + id_equipe + ", num_equipe=" + num_equipe + ", Service_nom=" + Service_nom + ", nbre_emp=" + nbre_emp + '}';
    }

  
    
    
    
    
}
