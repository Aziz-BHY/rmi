import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlCon {
    public static Connection con;
    static void initConnection(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hadhemi?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
            System.out.println("database connected!!");
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
