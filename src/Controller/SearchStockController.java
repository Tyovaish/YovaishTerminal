package Controller;

import Components.StockDisplay;
import javafx.scene.Group;


public class SearchStockController {
        Group terminal;
        StockDisplay stockDisplay;
        public SearchStockController(Group terminal){
            this.terminal=terminal;
            stockDisplay=new StockDisplay();
            terminal.getChildren().add(stockDisplay);
        }
}
