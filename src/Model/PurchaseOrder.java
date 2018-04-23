package Model;

public class PurchaseOrder {
    String stockTicker;
    double amountOfShares;
    double purchasePrice;
    public PurchaseOrder(String stockTicker,double amountOfShares,double purchasePrice){
        this.stockTicker=stockTicker;
        this.amountOfShares=amountOfShares;
        this.purchasePrice=purchasePrice;
    }
    public double getAmountOfShares() {
        return amountOfShares;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }
    public void setAmountOfShares(double amountOfShares) {
        this.amountOfShares = amountOfShares;
    }
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }
    public double getValue(){
        return amountOfShares*purchasePrice;
    }
}
