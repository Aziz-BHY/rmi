import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            MysqlCon.initConnection();
            DistantEmploye stub = (DistantEmploye) new DistantEmployeobj();
            DistantTache stub2 = (DistantTache) new DistantTacheobj();

            // Bind the remote object's stub in the registry
            LocateRegistry.createRegistry(3000);
            Naming.rebind("rmi://localhost:3000/Employe", stub);
            Naming.rebind("rmi://localhost:3000/Tache", stub2);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}