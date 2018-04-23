package Model;


import Model.API.StockDataRequest;
import Model.API.StockSummaryScraper;

import java.util.ArrayList;


public class Stock {
    private String stockTicker;
    private String stockName;
    private StockSummary stockSummary;
    private ArrayList<StockPrice> stockPrices = new ArrayList<StockPrice>();
    public Stock(String stockTicker){
        this.stockTicker=stockTicker;
        new StockDataRequest(this).run();
    }
    public String getStockTicker() {
        return stockTicker;
    }
    public String getCompanyName(){return stockName;}
    public String getPeRatio(){ return stockSummary.getPeRatio();}
    public String getVolume(){ return stockSummary.getVolume();}
    public String getAverageVolume(){return stockSummary.getAvgVolume();}
    public String getEPS(){ return stockSummary.getEPS();}
    public String getMarketCap(){return stockSummary.getMarketCap();}
    public StockPrice getStockPrice() {
        return stockPrices.get(0);
    }
    public double getLow(int numberOfDays){
        double low=stockPrices.get(0).getLow();
        for(int i=0;i<numberOfDays;i++){
            if(low>stockPrices.get(i).getLow()){
                low=stockPrices.get(i).getLow();
            }
        }
        return low;
    }
    public double getHigh(int numberOfDays){
        double high=stockPrices.get(0).getHigh();
        for(int i=0;i<numberOfDays;i++){
            if(high<stockPrices.get(i).getHigh()){
                high=stockPrices.get(i).getHigh();
            }
        }
        return high;
    }
    public double getOpen(int numberOfDays){
        return stockPrices.get(numberOfDays).getOpen();
    }
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }
    public void setStockSummary(StockSummary stockSummary){this.stockSummary=stockSummary;}
    public ArrayList<StockPrice> getAllStockPrices(){
            return stockPrices;
    }
    public void addStockPrice(StockPrice stockPrice){
        stockPrices.add(stockPrice);
    }
    public boolean priceIsIncreasing(){ return getStockPrice().getClose()-stockPrices.get(1).getClose()>=0;}
    public void setStockSummary() {
        if (stockSummary != null) {
            return;
        }
        new StockSummaryScraper(this).run();
    }
}
