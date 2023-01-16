import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DistantTache extends Remote {
    List<Tache> getTaches() throws RemoteException;
    Tache getTacheById(int id) throws RemoteException;
    String insertTache(Tache tache) throws RemoteException;
    String updateTache(Tache tache, int id) throws RemoteException;
    String deleteTache(int id) throws RemoteException;
    List<Tache> getTacheByEmployeId(int id) throws RemoteException;

}
