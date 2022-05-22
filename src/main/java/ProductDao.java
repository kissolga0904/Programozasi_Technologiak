import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product>{
    private Db db = new Db("termek");

    @Override
    public List getAll() {

        List<Product> allProducts=new ArrayList<>();
        try
        {
            Connection connection=db.Connect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM termek");
            while(rs.next()) {

                Product product = new Product.Builder(rs.getString("nev"),TermekSzin.valueOf(rs.getString("szin")),rs.getString("tipus"), Gyartok.valueOf(rs.getString("gyarto")), rs.getInt("id")).suly(rs.getInt("suly")).build();
                allProducts.add(product);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();

        }
        return allProducts;
    }

    @Override
    public void delete(int id) {

        try {
            Connection connection = db.Connect();
            PreparedStatement query = null;
            query = connection.prepareStatement("DELETE FROM termek WHERE `id` = '"+id+"'");
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }


    @Override
    public void insert(String sql) {
        try {
            Connection connection = db.Connect();
            PreparedStatement query = null;
            query = connection.prepareStatement(sql);
            query.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try
        {
            Connection connection=db.Connect();

            String sqlQuery = "UPDATE `termek` SET `nev`='" + product.getNev() + "',"+
                    "`szin`='" + product.getSzin() + "'," +
                    "`tipus`='" + product.getTipus() + "', " +
                    "`gyarto`='" + product.getGyarto() +"',"+
                    "`suly`='" + product.getSuly() + "'" +
                    "WHERE `id`='"+product.getId()+"'";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement = connection.prepareStatement(sqlQuery);
            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();

        }
    }

}
