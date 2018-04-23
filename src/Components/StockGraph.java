package Components;

import javafx.scene.Node;
import javafx.scene.chart.*;
import Model.Stock;
import Model.StockPrice;

import java.util.ArrayList;
import java.util.ListIterator;

public class StockGraph extends LineChart<String,Number> {
    CategoryAxis xAxis;
    NumberAxis yAxis;
    XYChart.Series series = new XYChart.Series();
    Stock stock;
    public StockGraph(CategoryAxis xAxis, NumberAxis yAxis) {
        super(xAxis, yAxis);
        this.xAxis=xAxis;
        this.yAxis=yAxis;
        setAnimated(false);
        getData().add(series);
        getYAxis().setOpacity(0);
        getXAxis().setOpacity(0);
        getXAxis().setTickLabelsVisible(false);
        getXAxis().setTickMarkVisible(false);
        setCreateSymbols(false);
        setHorizontalGridLinesVisible(false);
        setVerticalGridLinesVisible(false);
        setLegendVisible(false);
    }
    public void setStockToObserve(Stock stock){
        this.stock=stock;
        setForNumberOfDays(5);
    }
    private void addStockPrices(String date,Double price){
        series.getData().add(new XYChart.Data<String,Number>(date,price));
    }
    public void setForNumberOfDays(int numberOfDays){
        series.getData().clear();
       ArrayList<StockPrice> stockPrices = stock.getAllStockPrices();
       double startPrice=stockPrices.get(numberOfDays).getClose();
       addStockPrices(stockPrices.get(numberOfDays).getDate(),0.0);
       for(int i=numberOfDays-1;i>=0;--i){
           addStockPrices(stockPrices.get(i).getDate(),stockPrices.get(i).getClose()-startPrice);
       }
        Node line = series.getNode().lookup(".chart-series-line");
        if(stockPrices.get(0).getClose()>=stockPrices.get(1).getClose()) {
            line.setStyle("-fx-stroke: green");
        } else {
            line.setStyle("-fx-stroke: red");
        }

    }
}
