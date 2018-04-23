package Components;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SearchStock extends VBox {
        SearchBar searchBar;
        StockQuickDisplayTable stockQuickDisplayTable;
        public SearchStock(StockSummaryDisplay stockSummaryDisplay){
            stockQuickDisplayTable=new StockQuickDisplayTable(stockSummaryDisplay);
            searchBar=new SearchBar(stockQuickDisplayTable);
            setSpacing(20);
            getChildren().addAll(searchBar, stockQuickDisplayTable);
        }
}
