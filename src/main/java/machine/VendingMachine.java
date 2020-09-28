package machine;

import products.CoinType;
import products.ProductType;

import java.util.ArrayList;

public class VendingMachine {

    private double moneyBox;
    private ArrayList<ProductType> inventory;
    private double coinReturn;
    private double amountRequired;
    private ArrayList<ProductType> soldProducts;

    public VendingMachine() {
        this.moneyBox = 0.00;
        this.coinReturn = 0.00;
        this.amountRequired = 0.00;
        this.inventory = new ArrayList<ProductType>();
        this.soldProducts = new ArrayList<ProductType>();
    }

    public double getMoneyBox() {
        return moneyBox;
    }

    public int getInventory() {
        return inventory.size();
    }

    public void setMoneyBox() {
        this.moneyBox = 0.00;
    }

    public int getSoldProducts() {
        return soldProducts.size();
    }

    public double getCoinReturn() {
        return coinReturn;
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

    public void sellProduct(ProductType product) {
        this.soldProducts.add(product);
    }

    public CoinType insertCoin(CoinType coin) {
        if (coin.getCoinValue() >= .02) {
            this.moneyBox += coin.getCoinValue();
        } else {
            return coin;
        }
        return null;
    }

    public ProductType enterCode(int code) {
        ProductType product = this.getProductTypeByCode(code);
        double price = product.getProductPrice();
        if (this.moneyBox == price) {
            sellProduct(product);
            setMoneyBox();
        } else {
            changeDue(price);
        }
        return null;
    }

    public void changeDue(double price) {
        if (this.moneyBox > price) {
            coinReturn = moneyBox - price;
        }
        amountRequired = price - moneyBox;
    }

    public double getAmountRequired() {
        return amountRequired;
    }
}
