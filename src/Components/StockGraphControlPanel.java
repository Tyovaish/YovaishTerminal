package Components;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.YovaishTerminal;


public class StockGraphControlPanel extends HBox{
    StockGraph stockGraph;
    StockStatisticsTable stockStatisticsTable;
    public StockGraphControlPanel(StockGraph stockGraph,StockStatisticsTable stockStatisticsTable){
        this.stockGraph=stockGraph;
        this.stockStatisticsTable=stockStatisticsTable;
        setAlignment(Pos.CENTER);
        setPrefWidth(YovaishTerminal.TERMINAL_WIDTH/3);
        setSpacing(25);
        addOneWeekButton();
        addOneMonthButton();
        addSixMonthButton();

    }


    private void addOneWeekButton(){
        Button button = new Button();
        button.setText("1 WEEK");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stockGraph.setForNumberOfDays(5);
                stockStatisticsTable.setTimeRelevantStatistics(5);
            }
        });
        getChildren().add(button);

    }
    private void addOneMonthButton(){
        Button button = new Button();
        button.setText("1 MONTH");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stockGraph.setForNumberOfDays(20);
                stockStatisticsTable.setTimeRelevantStatistics(20);
            }
        });
        getChildren().add(button);
    }
    private void addSixMonthButton(){
        Button button = new Button();
        button.setText("6 MONTHS");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stockGraph.setForNumberOfDays(99);
                stockStatisticsTable.setTimeRelevantStatistics(99);
            }
        });
        getChildren().add(button);
    }
}
