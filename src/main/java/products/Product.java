package products;

public abstract class Product {

    private String description;
    private double price;
    private int code;

    public Product(String description, double price, int code) {
        this.description = description;
        this.price = price;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
