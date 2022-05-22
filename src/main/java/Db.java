//import net.proteanit.sql.DbUtils;
//import org.apache.commons.dbutils.DbUtils;
import javax.swing.*;
import java.sql.*;

public class Db {
    String jdbcURL="jdbc:mysql://localhost:3306/gls";
    String username="root";
    String password="";
    protected String dbName;
    public Db(String dbName) { this.dbName = dbName; }

    public Connection Connect() throws SQLException {

        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, "root","");
            return connection;
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        throw new SQLException("Couldn't connect to the database...");
    }
   /* protected void Selectall(String tableName, JTable table) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect();

        try
        {
            query = connection.prepareStatement(String.format("select * from %s", tableName));
            ResultSet rs = query.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (SQLException e)
        {
            e.printStackTrace();

        }


    }*/
    protected void Delete(String tableName, String field, String txtFieldValue) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect();

        try {
            query = connection.prepareStatement(String.format("delete from %s where %s = ?", tableName, field));
            query.setString(1, txtFieldValue);
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record deleted successfully!");

        }

        catch (SQLException e1)
        {
            e1.printStackTrace();

        }
    }
    protected void Insert(String sqlQuery) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect();
        try {
            query = connection.prepareStatement(sqlQuery);
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record was inserted.");

        }

        catch (SQLException e1)
        {
            e1.printStackTrace();

        }
    }
    protected void Update(int id, String name, String dOInst, String addr) throws SQLException {

        PreparedStatement query = null;
        Connection connection = this.Connect();

        try {
            // want to get the special char that separates the numbers in the date
            // and replace that with the ',' char that mysql accepts
            if (!(dOInst.contains(","))) {
                JOptionPane.showMessageDialog(null, "The date should be separated with ','!");
            } else {
                String sqlQuery = "UPDATE `factories` SET `company_name`='" + name + "',"+
                        "`institution`=STR_TO_DATE('" + dOInst + "', '%Y,%m,%d')," +
                        "`address`='" + addr + "' " +
                        "WHERE `id` = " + id;

                query = connection.prepareStatement(sqlQuery);
                query.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record updated successfully!");

            }
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();

        }
    }
}
