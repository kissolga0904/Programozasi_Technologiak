//import net.proteanit.sql.DbUtils;
//import org.apache.commons.dbutils.DbUtils;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Db {
    String jdbcURL = "jdbc:mysql://localhost:3306/gls";
    String username = "root";
    String password = "";
    protected String dbName;

    public Db(String dbName) {
        this.dbName = dbName;
    }

    public Connection Connect() throws SQLException {

        Connection connection=null;

        try {

            connection = DriverManager.getConnection(jdbcURL, "root", "");


        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Couldn't connect to the database...");
        }

        return connection;

    }
}
