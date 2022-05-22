import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoTest {

    @Test
    public void getAll() {
        ProductDao PDao=new ProductDao();

        List<Product> PList=PDao.getAll();
        int count=PList.size();
        assertEquals(7,count);
    }

    @Test
    public void delete() {
        ProductDao PDao=new ProductDao();

        List<Product> PList1=PDao.getAll();

        PDao.delete(13);
        List<Product> PList2=PDao.getAll();
        int count=PList2.size();
        assertEquals(5,count);
    }

    @Test
    public void insert() {
        ProductDao PDao=new ProductDao();

        List<Product> PList1=PDao.getAll();
        String sql="INSERT INTO termek (nev, szin, tipus, gyarto, suly) VALUES('teszt','RED','teszt','SAMSUNG',5)";
        PDao.insert(sql);
        List<Product> PList2=PDao.getAll();
        int count2=PList2.size();
        assertEquals(6,count2);

    }

    @Test
    public void update() {
        ProductDao PDao=new ProductDao();

        List<Product> PList1=PDao.getAll();
        Product p=new Product.Builder("teszt",TermekSzin.RED,"tfdf",Gyartok.SAMSUNG,5).suly(5).build();
        PDao.update(p);
        List<Product> PList2=PDao.getAll();
        int count=PList2.size();
        assertEquals(5,count);
    }
}