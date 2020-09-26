package products;

public enum ProductType {
    COLA(1.00, "XZ45"),
    CRISPS(.05, "YK76"),
    SWEET(.65, "KQ25");

    private double productPrice;
    private String productCode;

    ProductType(double productPrice, String productCode) {
        this.productPrice = productPrice;
        this.productCode = productCode;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductCode() {
        return productCode;
    }
}
