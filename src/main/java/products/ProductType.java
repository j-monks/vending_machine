package products;

public enum ProductType {
    COLA(1.00, 5643),
    CRISPS(.05, 7430),
    SWEET(.65, 6473);

    private double productPrice;
    private int productCode;

    ProductType(double productPrice, int productCode) {
        this.productPrice = productPrice;
        this.productCode = productCode;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductCode() {
        return productCode;
    }
}
