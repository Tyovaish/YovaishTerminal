package Test;

import Model.API.StockSummaryScraper;
import Model.Stock;

public class StockSummaryTest {
    public static void main(String args []){
        new StockSummaryScraper(new Stock("AAPL")).run();
    }
}
