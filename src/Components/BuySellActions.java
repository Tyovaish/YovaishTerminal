package Components;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BuySellActions extends HBox {
    public BuySellActions(){
        Button buy=new Button();
        buy.setText("BUY");
        Button sell=new Button();
        sell.setText("SELL");
        setAlignment(Pos.CENTER);
        setSpacing(50);
        getChildren().addAll(buy,sell);
    }
}
