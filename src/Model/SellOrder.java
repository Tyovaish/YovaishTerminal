package Model;

public class SellOrder {
    String stockTicker;
    double amountOfShares;
    double sellPrice;

    public SellOrder(String stockTicker, double amountOfShares, double sellPrice) {
        this.stockTicker=stockTicker;
        this.amountOfShares=amountOfShares;
        this.sellPrice=sellPrice;
    }

    public double getAmountOfShares() {
        return amountOfShares;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public double getSellPrice() {
        return sellPrice;
    }
    public void setAmountOfShares(double amountOfShares) {
        this.amountOfShares = amountOfShares;
    }
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }
    public double getValue(){
        return amountOfShares*sellPrice;
    }
}
