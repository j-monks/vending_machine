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
    public void canGetProductByProductCode() {
        vendingMachine.addProductToInventory(ProductType.COLA);
        vendingMachine.addProductToInventory(ProductType.CRISPS);
        assertEquals(ProductType.COLA, vendingMachine.getProductTypeByCode(5643));
    }

    @Test
    public void canGetProductByProductPrice() {
        vendingMachine.addProductToInventory(ProductType.SWEET);
        assertEquals(productType.SWEET, vendingMachine.getProductTypeByPrice(.65));
    }

    @Test
    public void canInsertCoin() {
        vendingMachine.insertCoin(CoinType.FIFTY_PENCE);
        assertEquals(.5, vendingMachine.getMoneyBox(), 0.05);
    }
}
