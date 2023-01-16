import java.io.Serializable;

public class Tache implements Serializable {
    public int id;
    public String description;
    public int idEmploye;


    public Tache(int id, String description, int idEmploye) {
        this.id = id;
        this.description = description;
        this.idEmploye = idEmploye;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", idEmploye=" + idEmploye +
                '}';
    }
}
