package Components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import Model.Stock;
import main.YovaishTerminal;

public class StockStatisticsTable extends GridPane{
    double cellSize=200;
    Stock stock;
    public StockStatisticsTable(Stock stock){
        this.stock=stock;
        stock.setStockSummary();
        setAlignment(Pos.CENTER);
        setPrefWidth(YovaishTerminal.TERMINAL_WIDTH/3);
        setVgap(20);
        setHgap(10);
        setTitle();
        setTimeRelevantStatistics(5);
    }
    public void setTimeRelevantStatistics(int numberOfDays){
        getChildren().clear();
        setOpen(String.valueOf(stock.getOpen(numberOfDays)));
        setHigh(String.valueOf(stock.getHigh(numberOfDays)));
        setLow(String.valueOf(stock.getLow(numberOfDays)));
        set26High(String.valueOf(stock.getHigh(99)));
        set26Low(String.valueOf(stock.getLow(99)));
        setVolume(stock.getVolume());
        setAVGVolume(stock.getAverageVolume());
        setEPS(stock.getEPS());
        setMKTCap(stock.getMarketCap());
        setPERatio(stock.getPeRatio());
    }
    public void setTitle(){
        Label title = new Label();
        title.setText("Stats");
        title.setFont(Font.font ("Verdana", 30));
        add(title,0,0);

    }
    public void setOpen(String price){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label open = new Label();
        open.setText("OPEN");
        open.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(String.valueOf(price));
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(open,region1,value);
        add(hBox,0,1);
    }
    public void setHigh(String price){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label high = new Label();
        high.setText("HIGH");
        high.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(String.valueOf(price));
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(high,region1,value);
        add(hBox,0,2);
    }
    public void setLow(String price){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label low = new Label();
        low.setText("LOW");
        low.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(String.valueOf(price));
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(low,region1,value);
        add(hBox,0,3);
    }
    public void set26High(String price){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label yearLow = new Label();
        yearLow.setText("26 WK HIGH");
        yearLow.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(String.valueOf(price));
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(yearLow,region1,value);
        add(hBox,0,4);
    }
    public void set26Low(String price){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label yearHigh = new Label();
        yearHigh.setText("26 WK LOW");
        yearHigh.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(String.valueOf(price));
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(yearHigh,region1,value);
        add(hBox,0,5);
    }
    public void setVolume(String amount){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label volume = new Label();
        volume.setText("VOLUME");
        volume.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(amount);
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(volume,region1,value);
        add(hBox,1,1);
    }
    public void setAVGVolume(String amount){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label avgVolume = new Label();
        avgVolume.setText("AVG VOLUME");
        avgVolume.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(amount);
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(avgVolume,region1,value);
        add(hBox,1,2);
    }
    public void setMKTCap(String amount){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label marketCap = new Label();
        marketCap.setText("MKT CAP");
        marketCap.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(amount);
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(marketCap,region1,value);
        add(hBox,1,3);
    }

    public void setPERatio(String amount){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label marketCap = new Label();
        marketCap.setText("PE Ratio");
        marketCap.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(amount);
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(marketCap,region1,value);
        add(hBox,1,4);
    }
    public void setEPS(String amount){
        HBox hBox=new HBox();
        hBox.setPrefWidth(cellSize);
        Label marketCap = new Label();
        marketCap.setText("EPS");
        marketCap.setFont(Font.font ("Verdana", 12));
        Label value=new Label();
        value.setFont(Font.font("Verdana",12));
        value.setText(amount);
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        hBox.getChildren().addAll(marketCap,region1,value);
        add(hBox,1,5);
    }

}
