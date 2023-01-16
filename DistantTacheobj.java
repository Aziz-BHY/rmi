import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DistantTacheobj extends UnicastRemoteObject implements DistantTache{
    protected DistantTacheobj() throws RemoteException {
    }

    @Override
    public List<Tache> getTaches() throws RemoteException {
        try{
            Statement smt = MysqlCon.con.createStatement();
            ResultSet rs = smt.executeQuery("select * from hadhemi.Tache;");
            List<Tache> listeTaches = new ArrayList<Tache>();
            while(rs.next()){
                Tache tache = new Tache(rs.getInt("id"),rs.getString("description"), rs.getInt("idEmploye"));
                listeTaches.add(tache);
            }
            return listeTaches;
        }catch (Exception e){
            return new ArrayList<Tache>();
        }

    }

    @Override
    public Tache getTacheById(int id) throws RemoteException {
        try{
            Statement smt = MysqlCon.con.createStatement();
            ResultSet rs = smt.executeQuery("select * from hadhemi.Tache where id="+id+";");
            rs.next();
            System.out.println(rs.getInt("id"));
            Tache tache = new Tache(rs.getInt("id"),rs.getString("description"), rs.getInt("idEmploye"));
            return tache;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String insertTache(Tache tache) throws RemoteException {
        try{
            PreparedStatement preparedStatement = MysqlCon.con.prepareStatement("insert into hadhemi.Tache (description, idEmploye) values(?,?);");
            preparedStatement.setString(1, tache.description);
            preparedStatement.setInt(2, tache.idEmploye);
            preparedStatement.execute();
            return "tache saved";
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String updateTache(Tache tache, int id) throws RemoteException {
        try{
            PreparedStatement preparedStatement = MysqlCon.con.prepareStatement("update hadhemi.Tache set description=?, idEmploye=? where id=?;");
            preparedStatement.setString(1, tache.description);
            preparedStatement.setInt(2, tache.idEmploye);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            return "tache updated";
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String deleteTache(int id) throws RemoteException {
        try{
            PreparedStatement preparedStatement = MysqlCon.con.prepareStatement("delete from hadhemi.Tache where id = ?;");
            preparedStatement.setInt(1, id);
            return "tache deleted";
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Tache> getTacheByEmployeId(int id) throws RemoteException {
        try{
            Statement smt = MysqlCon.con.createStatement();
            ResultSet rs = smt.executeQuery("select * from hadhemi.Tache where idEmploye="+id+";");
            List<Tache> listeTaches = new ArrayList<Tache>();
            while(rs.next()){
                Tache tache = new Tache(rs.getInt("id"),rs.getString("description"), rs.getInt("idEmploye"));
                listeTaches.add(tache);
            }
            return listeTaches;
        }catch (Exception e){
            return new ArrayList<Tache>();
        }
    }
}
