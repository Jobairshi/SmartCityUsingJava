
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Mycnx {
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "final_project";
    private static Integer portnumber = 3306;
    private static String password = "";
    Mycnx()
    {
        
    }
    public static Connection getConnection()
    {
        Connection cnx = null;
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(servername);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setDatabaseName(dbname);
        dataSource.setPort(portnumber);
        try{
            System.out.println("Conected");
            cnx = (Connection)dataSource.getConnection();
        }
        catch(SQLException ex)
        {
            System.out.println("Not connnection");
        }
        return cnx;
    }
}
