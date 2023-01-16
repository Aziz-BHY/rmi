
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DistantEmploye extends Remote {
    List<Employe> getEmployes() throws RemoteException;
    Employe getEmployeById(int id) throws RemoteException;
    String insertEmploye(Employe employe) throws RemoteException;
    String updateEmploye(Employe employe, int id) throws RemoteException;
    String deleteEmploye(int id) throws RemoteException;

}
