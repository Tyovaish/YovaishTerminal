package Components;

import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.VBox;
import Model.Stock;
import Model.StockTickerFilter;
import main.YovaishTerminal;

public class StockSummaryDisplay extends VBox {
    public void setStockSummaryDisplay(Stock stock){
        stock.setStockName(StockTickerFilter.getCompanyName(stock.getStockTicker()));
        setAlignment(Pos.CENTER);
        setPrefSize(YovaishTerminal.TERMINAL_WIDTH/3,YovaishTerminal.TERMINAL_HEIGHT);
        setSpacing(20);
        StockPriceRibbon stockPriceRibbon = new StockPriceRibbon();
        stockPriceRibbon.setStockPrice(stock.getStockPrice().getClose(),stock.priceIsIncreasing());
        stockPriceRibbon.setStockTicker(stock.getStockTicker());
        stockPriceRibbon.setCompanyName(stock.getCompanyName());
        StockGraph stockGraph = new StockGraph(new CategoryAxis(), new NumberAxis());
        stockGraph.setStockToObserve(stock);
        stockGraph.setPrefSize(YovaishTerminal.TERMINAL_WIDTH/3,YovaishTerminal.TERMINAL_HEIGHT/2);
        StockStatisticsTable stockStatisticsTable= new StockStatisticsTable(stock);
        getChildren().addAll(stockPriceRibbon,stockGraph,new StockGraphControlPanel(stockGraph,stockStatisticsTable),stockStatisticsTable,new BuySellActions());
    }

    public void updateStockData(Stock stock) {
        getChildren().clear();
        setStockSummaryDisplay(stock);
    }
}
