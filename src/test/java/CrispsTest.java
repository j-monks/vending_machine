import org.junit.Before;
import org.junit.Test;
import products.Crisps;

import static org.junit.Assert.assertEquals;

public class CrispsTest {

    Crisps crisps;

    @Before
    public void before() {
        crisps = new Crisps("Lightly Salted", 0.65, 6473);
    }

    @Test
    public void canGetDescription() {
        assertEquals("Lightly Salted", crisps.getDescription());
    }

    @Test
    public void canGetPrice() {
        assertEquals(0.65, crisps.getPrice(), 0.01);
    }
}
