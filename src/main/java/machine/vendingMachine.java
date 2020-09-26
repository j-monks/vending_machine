package machine;

import products.ProductType;

import java.util.ArrayList;

public class vendingMachine {

    private double moneyBox;
    private ArrayList<ProductType> inventory;

    public vendingMachine(double moneyBox) {
        this.moneyBox = 0.00;
        this.inventory = new ArrayList<ProductType>();
    }

    public double getMoneyBox() {
        return moneyBox;
    }

    public ArrayList<ProductType> getInventory() {
        return inventory;
    }

    public void setMoneyBox(double moneyBox) {
        this.moneyBox = moneyBox;
    }

    public void setInventory(ArrayList<ProductType> inventory) {
        this.inventory = inventory;
    }
}
