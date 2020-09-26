import machine.VendingMachine;
import org.junit.Before;
import org.junit.Test;
import products.CoinType;
import products.ProductType;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {


    VendingMachine vendingMachine;
    CoinType coinType;
    ProductType productType;

    @Before
    public void before() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void canGetInventory() {
        assertEquals(0, vendingMachine.getInventory());
    }

    @Test
    public void canGetMoneyBox() {
        assertEquals(0.00, vendingMachine.getMoneyBox(), 0.5);
    }

    @Test
    public void canAddProduct() {
        vendingMachine.addProductToInventory(ProductType.COLA);
        assertEquals(1, vendingMachine.getInventory());
    }

    @Test
    public
}
