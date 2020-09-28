package machine;

import products.CoinType;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private double moneyBox;
    private ArrayList<Product> inventory;
    private double coinReturn;
    private double amountRequired;
    private double change;
    private ArrayList<Product> soldProducts;

    public VendingMachine() {
        this.moneyBox = 0.00;
        this.coinReturn = 0.00;
        this.amountRequired = 0.00;
        this.change = 0.00;
        this.inventory = new ArrayList<Product>();
        this.soldProducts = new ArrayList<Product>();
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

    public double getChange() {
        return change;
    }

    public double getCoinReturn() {
        return coinReturn;
    }

    public void setInventory(ArrayList<Product> inventory) {
        this.inventory = inventory;
    }

    public void addProductToInventory(Product product) {
        this.inventory.add(product);
    }

    public Product getProductByCode(int code) {
        for (Product product : this.inventory) {
            if (product.getCode() == code) {
                return product;
            }
        }
        return null;
    }

    public Product getProductByPrice(double price) {
        for (Product product : this.inventory) {
            if (product.getPrice() == price) {
                return product;
            }
        }
        return null;
    }

    public void sellProduct(Product product) {
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

    public String enterCode(int code) {
        Product product = this.getProductByCode(code);
        double price = product.getPrice();
        if (this.moneyBox == price) {
            sellProduct(product);
            setMoneyBox();
        }
        if (this.change >= this.moneyBox - price) {
            changeDue(price);
        } else {
            return "Insufficient change, please enter exact amount!";
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

    public void returnCoinsButton() {
        coinReturn = moneyBox;
        setMoneyBox();
    }
}
