package Components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import Model.Stock;
import Model.StockPrice;

import java.text.NumberFormat;


public class StockPriceRibbon extends VBox {
    public StockPriceRibbon(){
        setSpacing(10);
    }
    public void setStockPrice(Double stockPrice, boolean isPriceIncreasing){
        HBox hBox  = new HBox();
        Label stockPriceLabel= new Label();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        stockPriceLabel.setText(formatter.format(stockPrice));
        if(isPriceIncreasing){
            stockPriceLabel.setTextFill(Color.GREEN);
        } else {
            stockPriceLabel.setTextFill(Color.RED);
        }
        stockPriceLabel.setFont(Font.font ("Verdana", 40));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(stockPriceLabel);
        getChildren().add(hBox);
    }
    public void setStockTicker(String stockTicker){
        Label stockTickerLabel= new Label();
        stockTickerLabel.setText(String.valueOf(stockTicker));
        stockTickerLabel.setFont(Font.font ("Verdana", 25));
        HBox hBox = new HBox();
        hBox.getChildren().add(stockTickerLabel);
        hBox.setAlignment(Pos.CENTER);
        getChildren().add(hBox);

    }
    public void setCompanyName(String companyName){
        Label stockCompanyNameLabel= new Label();
        stockCompanyNameLabel.setText(String.valueOf(companyName));
        stockCompanyNameLabel.setFont(Font.font ("Verdana", 12));
        HBox hBox = new HBox();
        hBox.getChildren().add(stockCompanyNameLabel);
        hBox.setAlignment(Pos.CENTER);
        getChildren().add(hBox);
    }
}
