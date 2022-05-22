import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ProductTest {

    @Test
    public void getNev(){
        Product product = new Product.Builder("Mouse",TermekSzin.BLACK,"gamer",Gyartok.SAMSUNG,2).build();
        assertEquals("Mouse",product.getNev());
    }

    @Test
    public void getSzin(){
        Product product = new Product.Builder("Laptop",TermekSzin.WHITE,"gamer",Gyartok.LENOVO,3).build();
        assertEquals(TermekSzin.WHITE,product.getSzin());
    }

    @Test
    public void getSuly() {
        Product product = new Product.Builder("Phone",TermekSzin.GREEN,"smart",Gyartok.APPLE, 1).suly(1).build();
        assertEquals(1,product.getSuly());
    }

    @Test
    public void getTipus(){
        Product product = new Product.Builder("Microwave",TermekSzin.RED,"smart",Gyartok.SAMSUNG,5).build();
        assertEquals("smart",product.getTipus());
    }

    @Test
    public void getGyarto(){
        Product product = new Product.Builder("Airpods",TermekSzin.BLUE,"wireless",Gyartok.APPLE,4).build();
        assertEquals(Gyartok.APPLE,product.getGyarto());
    }


}