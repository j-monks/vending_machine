package products;

public enum CoinType {
    ONE_PENCE(.01),
    TWO_PENCE(.02),
    FIVE_PENCE(.05),
    TEN_PENCE(.10),
    TWENTY_PENCE(.20),
    FIFTY_PENCE(.50),
    ONE_POUND(1.0);


    private double coinValue;

    CoinType(double value) {
        this.coinValue = value;
    }

    public double getCoinValue() {
        return coinValue;
    }

}

