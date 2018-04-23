package Components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import main.YovaishTerminal;

public class NavagationBar extends VBox {
    Button searchStock;
    Button portfolio;
    Button simulation;
    public NavagationBar(){
        Label Yovaish_Terminal=new Label();
        Yovaish_Terminal.setText("YOVAISH TERMINAL");
        Yovaish_Terminal.setAlignment(Pos.CENTER);
        searchStock=new Button();
        searchStock.setText("Stocks");
        portfolio=new Button();
        portfolio.setText("Portfolio");
        simulation=new Button();
        simulation.setText("Simulation");
        setAlignment(Pos.TOP_CENTER);
        setSpacing(100);
        setPadding(new Insets(100,0,0,0));
       setPrefWidth(YovaishTerminal.TERMINAL_WIDTH/4);
        getChildren().addAll(Yovaish_Terminal,searchStock,portfolio,simulation);
    }
}
