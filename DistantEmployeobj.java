import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DistantEmployeobj extends UnicastRemoteObject implements DistantEmploye{

    protected DistantEmployeobj() throws RemoteException {
    }

    @Override
    public List<Employe> getEmployes() throws RemoteException {
        try{
            Statement smt = MysqlCon.con.createStatement();
            ResultSet rs = smt.executeQuery("select * from hadhemi.Employe;");
            List<Employe> listeEmployes = new ArrayList<Employe>();
            while(rs.next()){
                Employe e = new Employe(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getString("grade"),rs.getString("numCompte"), rs.getInt("idSup"));
                listeEmployes.add(e);
            }
            return listeEmployes;
        }catch (Exception e){
            return new ArrayList<Employe>();
        }

    }

    @Override
    public Employe getEmployeById(int id) throws RemoteException {
        try{
            Statement smt = MysqlCon.con.createStatement();
            System.out.println("select * from hadhemi.Employe where id="+id+";");
            ResultSet rs = smt.executeQuery("select * from hadhemi.Employe where id="+id+";");
            rs.next();
            System.out.println(rs.getInt("id"));
                Employe e = new Employe(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getString("grade"),rs.getString("numCompte"), rs.getInt("idSup"));
            return e;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String insertEmploye(Employe employe) throws RemoteException {
        try{
            PreparedStatement preparedStatement = MysqlCon.con.prepareStatement("insert into hadhemi.Employe (nom, prenom, adresse, grade, numCompte, idSup ) values(?,?,?,?,?,?)");
            preparedStatement.setString(1, employe.nom);
            preparedStatement.setString(2, employe.prenom);
            preparedStatement.setString(3, employe.adresse);
            preparedStatement.setString(4, employe.grade);
            preparedStatement.setString(5, employe.numCompte);
            preparedStatement.setInt(6, employe.idSup);
            preparedStatement.execute();
            return "employe saved";
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String updateEmploye(Employe employe, int id) throws RemoteException {
        try{
            PreparedStatement preparedStatement = MysqlCon.con.prepareStatement("update hadhemi.Employe set nom=?, prenom=?, adresse=?, grade=?, numCompte=?, idSup=? where id=?;");
            preparedStatement.setString(1, employe.nom);
            preparedStatement.setString(2, employe.prenom);
            preparedStatement.setString(3, employe.adresse);
            preparedStatement.setString(4, employe.grade);
            preparedStatement.setString(5, employe.numCompte);
            preparedStatement.setInt(6, employe.idSup);
            preparedStatement.setInt(7, id);
            preparedStatement.execute();
            return "employe updated";
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String deleteEmploye(int id) throws RemoteException {
        try{
            PreparedStatement preparedStatement = MysqlCon.con.prepareStatement("delete from hadhemi.Employe where id=?;");
            preparedStatement.setInt(1, id);
            return "employe deleted";
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
