package machine;

import products.ProductType;

import java.util.ArrayList;

public class VendingMachine {

    private double moneyBox;
    private ArrayList<ProductType> inventory;

    public VendingMachine() {
        this.moneyBox = 0.00;
        this.inventory = new ArrayList<ProductType>();
    }

    public double getMoneyBox() {
        return moneyBox;
    }

    public int getInventory() {
        return inventory.size();
    }

    public void setMoneyBox(double moneyBox) {
        this.moneyBox = moneyBox;
    }

    public void setInventory(ArrayList<ProductType> inventory) {
        this.inventory = inventory;
    }

    public void addProductToInventory(ProductType product) {
        this.inventory.add(product);
    }

    public ProductType getProductTypeByCode(int code) {
        for (ProductType product : this.inventory) {
            if (product.getProductCode() == code) {
                return product;
            }
        }
        return null;
    }

    public ProductType getProductTypeByPrice(double price) {
        for (ProductType product : this.inventory) {
            if (product.getProductPrice() == price) {
                return product;
            }
        }
        return null;
    }
}
