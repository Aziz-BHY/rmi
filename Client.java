import java.rmi.Naming;

public class Client {
    public static void main(String[] args){
        try {
            DistantEmploye distantEmploye = (DistantEmploye) Naming.lookup("rmi://localhost:3000/Employe");
            DistantTache distantTache = (DistantTache) Naming.lookup("rmi://localhost:3000/Tache");
            System.out.println(distantTache.getTacheByEmployeId(1));
        }
        catch(Exception e){
            System.out.println("Erreur client : " +e);
        }
    }

}
