import machine.VendingMachine;
import org.junit.Before;
import org.junit.Test;
import products.*;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {


    VendingMachine vendingMachine;
    CoinType coinType;
    Crisps crisps;
    Cola cola;
    Sweet sweet;

    @Before
    public void before() {
        vendingMachine = new VendingMachine();
        crisps = new Crisps("Lightly Salted", 0.50, 7430);
        cola = new Cola("Fizzy cola cube", 1.0,5643);
        sweet = new Sweet("Snickers", 0.65, 6473);
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
        vendingMachine.addProductToInventory(cola);
        assertEquals(1, vendingMachine.getInventory());
    }

    @Test
    public void canGetProductByProductCode() {
        vendingMachine.addProductToInventory(cola);
        vendingMachine.addProductToInventory(crisps);
        assertEquals(cola, vendingMachine.getProductByCode(5643));
    }

    @Test
    public void canGetProductByProductPrice() {
        vendingMachine.addProductToInventory(sweet);
        assertEquals(sweet, vendingMachine.getProductByPrice(.65));
    }

    @Test
    public void canInsertCoin() {
        vendingMachine.insertCoin(CoinType.TEN_PENCE);
        assertEquals(0.10, vendingMachine.getMoneyBox(), 0.01);
        // checking if inserting an invalid coin spits it back out
        assertEquals(coinType.ONE_PENCE, vendingMachine.insertCoin(CoinType.ONE_PENCE));
    }

    @Test
    public void canGetProductWhenEnoughMoneyHasBeenInsertedAndCodeHasBeenEntered() {
        vendingMachine.addProductToInventory(sweet);
        vendingMachine.insertCoin(CoinType.FIFTY_PENCE);
        vendingMachine.insertCoin(CoinType.TEN_PENCE);
        vendingMachine.insertCoin(CoinType.FIVE_PENCE);
        vendingMachine.enterCode(6473);
        // product sold because enough money was entered
        assertEquals(1, vendingMachine.getSoldProducts());
        // moneyBox returns to zero once product has been sold
        assertEquals(0.00, vendingMachine.getMoneyBox(), 0.05);
    }

    @Test
    public void whenIncorrectAmountHasBeenEnteredAmountRequiredPlusNoProduct() {
        vendingMachine.addProductToInventory(sweet);
        vendingMachine.insertCoin(CoinType.FIFTY_PENCE);
        vendingMachine.insertCoin(CoinType.FIVE_PENCE);
        vendingMachine.enterCode(6473);
        // remaining amount needed to buy product
        assertEquals(0.10, vendingMachine.getAmountRequired(), 0.05);
        // didn't sell the product because not enough was inserted
        assertEquals(0, vendingMachine.getSoldProducts());
    }

    @Test
    public void addsChangeToTheCoinReturnWhenAmountExceedsProductPrice() {
        vendingMachine.addProductToInventory(sweet);
        vendingMachine.insertCoin(CoinType.FIFTY_PENCE);
        vendingMachine.insertCoin(CoinType.FIVE_PENCE);
        vendingMachine.insertCoin(CoinType.ONE_POUND);
        vendingMachine.enterCode(6473);
        // coin return is adding the change if too much money has been inserted
        assertEquals(1.0, vendingMachine.getCoinReturn(), 0.1);
    }

    @Test
    public void returnCoinsButtonReleasesMoneyBoxCoinsAndSetsMoneyBoxToZero() {
        vendingMachine.insertCoin(CoinType.FIFTY_PENCE);
        vendingMachine.insertCoin(CoinType.FIVE_PENCE);
        vendingMachine.insertCoin(CoinType.ONE_POUND);
        vendingMachine.returnCoinsButton();
        // coin return is adding the money that has been inserted after returnCoinButton is pressed
        assertEquals(1.55, vendingMachine.getCoinReturn(), 0.1);
        // moneyBox is setting back to zero as the money is swapped to coin return
        assertEquals(0.00, vendingMachine.getMoneyBox(), 0.1);
    }

    @Test
    public void whenMachineHasInsufficientChangeItWillRequestTheExactAmountToBeEntered() {
        vendingMachine.addProductToInventory(sweet);
        vendingMachine.insertCoin(CoinType.FIFTY_PENCE);
        vendingMachine.insertCoin(CoinType.FIVE_PENCE);
        vendingMachine.insertCoin(CoinType.ONE_POUND);
        // if the vending machine doesn't have sufficient change, it will decline the sale and ask for an exact amount
        assertEquals("Insufficient change, please enter exact amount!", vendingMachine.enterCode(6473));
    }
}
