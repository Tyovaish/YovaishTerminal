package Components;

import javafx.scene.layout.HBox;

public class StockDisplay extends HBox {
    public StockDisplay(){
        StockSummaryDisplay stockSummaryDisplay = new StockSummaryDisplay();
        setSpacing(50);
        getChildren().addAll(new NavagationBar(),new SearchStock(stockSummaryDisplay),stockSummaryDisplay);
    }
}
