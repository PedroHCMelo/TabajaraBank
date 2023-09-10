import java.sql.Connection;
import java.sql.DriverManager;


public class SQLConnection
{
    static String url = "jdbc:mysql://localhost:3306/bankconection";
    static String user = "root";
    static String password = "teste";


    static Connection open() throws Exception{
        Connection conexao = DriverManager.getConnection(url, user, password);
       return conexao;
    }
}
