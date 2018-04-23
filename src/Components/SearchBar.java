package Components;

import javafx.scene.control.TextField;
import Model.Stock;
import Model.StockTickerFilter;
import main.YovaishTerminal;


import java.util.HashMap;

public class SearchBar extends TextField {
    StockQuickDisplayTable stockQuickDisplayTable;
    StockTickerFilter stockTickerFilter;
    HashMap<String,Stock> savedStock;
    public SearchBar(StockQuickDisplayTable stockQuickDisplayTable){
        this.savedStock=new HashMap<String,Stock>();
        this.stockTickerFilter=new StockTickerFilter();
        this.stockQuickDisplayTable=stockQuickDisplayTable;
        setPromptText("Search by Ticker Symbol");
        setPrefSize(YovaishTerminal.TERMINAL_WIDTH/4,YovaishTerminal.TERMINAL_HEIGHT/20);
        textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.compareTo("")==0){
                this.stockQuickDisplayTable.reset();
                return;
            }
            if(stockTickerFilter.checkStockTicker(newValue.toUpperCase())) {
                if(savedStock.containsKey(newValue.toUpperCase())){
                    this.stockQuickDisplayTable.updateTable(savedStock.get(newValue.toUpperCase()));
                    return;
                }
                Stock stock = new Stock(newValue.toUpperCase());
                stock.setStockName(stockTickerFilter.getCompanyName(newValue.toUpperCase()));
                this.stockQuickDisplayTable.updateTable(stock);
                savedStock.put(stock.getStockTicker(),stock);
                if(savedStock.size()>=20){
                    savedStock.remove(savedStock.keySet().toArray()[0]);
                }
                return;
            }
        });
    }
}
