import java.io.Serializable;

public class Employe implements Serializable {
    public int id;
    public String nom;
    public String prenom;
    public String adresse;
    public String grade;
    public String numCompte;
    public int idSup;
    public Employe(int id ,String nom, String prenom, String adresse, String grade, String numCompte, int idSup){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.grade = grade;
        this.numCompte = numCompte;
        this.idSup = idSup;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", grade='" + grade + '\'' +
                ", numCompte='" + numCompte + '\'' +
                ", idSup=" + idSup +
                '}';
    }
}
