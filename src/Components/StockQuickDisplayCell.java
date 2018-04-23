package Components;

import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import Model.Stock;
import main.YovaishTerminal;
import java.text.NumberFormat;

public class StockQuickDisplayCell extends HBox {
    StockQuickDisplayTable stockQuickDisplayTable;
    Stock stockToObserve;
    Label stockPrice;
    StockGraph stockGraph;
    Label stockTicker;
    public StockQuickDisplayCell(StockQuickDisplayTable stockQuickDisplayTable) {
        this.stockQuickDisplayTable = stockQuickDisplayTable;
        setPrefSize(YovaishTerminal.TERMINAL_WIDTH /4,YovaishTerminal.TERMINAL_HEIGHT/10);
        setMinSize(YovaishTerminal.TERMINAL_WIDTH /4,YovaishTerminal.TERMINAL_HEIGHT/10);
        setMaxSize(YovaishTerminal.TERMINAL_WIDTH /4,YovaishTerminal.TERMINAL_HEIGHT/10);

        setStyle("-fx-border-style: solid outside");
        setAlignment(Pos.CENTER);
        setSpacing(15);
        Region region1 = new Region();
        Region region2 = new Region();
        setHgrow(region1,Priority.ALWAYS);
        setHgrow(region2,Priority.ALWAYS);

        stockPrice = new Label();
        stockPrice.setText("STOCK_PRICE");
        stockPrice.setMinWidth(YovaishTerminal.TERMINAL_WIDTH/20);
        stockPrice.setPrefWidth(YovaishTerminal.TERMINAL_WIDTH/20);
        stockPrice.setMaxWidth(YovaishTerminal.TERMINAL_WIDTH/20);

        stockTicker = new Label();
        stockTicker.setText("STOCK_TICKER");
        stockTicker.setMinWidth(YovaishTerminal.TERMINAL_WIDTH/20);
        stockTicker.setPrefWidth(YovaishTerminal.TERMINAL_WIDTH/20);
        stockTicker.setMaxWidth(YovaishTerminal.TERMINAL_WIDTH/20);

        stockGraph = new StockGraph(new CategoryAxis(), new NumberAxis());
        stockGraph.setMinSize(YovaishTerminal.TERMINAL_WIDTH /10, YovaishTerminal.TERMINAL_HEIGHT /10);
        stockGraph.setMaxSize(YovaishTerminal.TERMINAL_WIDTH /10, YovaishTerminal.TERMINAL_HEIGHT /10);
        stockGraph.setPrefSize(YovaishTerminal.TERMINAL_WIDTH /10, YovaishTerminal.TERMINAL_HEIGHT /10);
        getChildren().addAll(stockTicker,region1,stockGraph,region2,stockPrice);
    }
    public void setStockPrice(Double stockPrice){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        this.stockPrice.setText(formatter.format(stockPrice));
        if(stockToObserve.priceIsIncreasing()){
            this.stockPrice.setTextFill(Color.GREEN);
        } else {
            this.stockPrice.setTextFill(Color.RED);
        }
    }
    public void setStockTicker(String stockTicker){

        this.stockTicker.setText(stockTicker);
    }
    public void setStockGraph(Stock stock){
            stockGraph.setStockToObserve(stock);
    }

    public void setStockToObserve(Stock stock) {
        this.stockToObserve=stock;
        setStockPrice(stock.getStockPrice().getClose());
        setStockTicker(stock.getStockTicker());
        setStockGraph(stock);
        setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("UPDATING");
                stockQuickDisplayTable.updateStockSummary(stockToObserve);
            }
        });
    }
}
