package Components;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import Model.Stock;
import main.YovaishTerminal;
import java.util.ArrayList;

public class StockQuickDisplayTable extends GridPane {
    public Stock [] startingStock = {new Stock("TSLA"),new Stock("GE"),new Stock("AAPL"),new Stock("KO"),new Stock("MSFT"), new Stock("BLK"),new Stock("BAC")};
    ArrayList<StockQuickDisplayCell> stocksToDisplay;
    StockSummaryDisplay stockSummaryDisplay;
    public StockQuickDisplayTable(StockSummaryDisplay stockSummaryDisplay)
    {
        setVgap(10);
        setPrefWidth(YovaishTerminal.TERMINAL_WIDTH/4);
       this.stockSummaryDisplay=stockSummaryDisplay;
       reset();
    }

    public void updateTable(Stock stock) {
        getChildren().clear();
        StockQuickDisplayCell cell = new StockQuickDisplayCell(this);
        add(cell,0,0);
        cell.setStockToObserve(stock);
    }
    public void updateStockSummary(Stock stock){
        stockSummaryDisplay.updateStockData(stock);
    }
    public void reset(){
        getChildren().clear();
        getRowConstraints().clear();
        getColumnConstraints().clear();

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(YovaishTerminal.TERMINAL_HEIGHT/10);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(YovaishTerminal.TERMINAL_WIDTH/4);
        for(int i=0;i<7;++i){
            StockQuickDisplayCell cell = new StockQuickDisplayCell(this);
            cell.setStockToObserve(startingStock[i]);
            add(cell,0,i);
            getRowConstraints().add(rowConstraints);
            getColumnConstraints().add(columnConstraints);
        }
    }
}
