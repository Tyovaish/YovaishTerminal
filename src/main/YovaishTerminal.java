package main;


import Controller.SearchStockController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class YovaishTerminal extends Application {
    public static double TERMINAL_WIDTH=1700;
    public static double TERMINAL_HEIGHT=1000;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Yovaish Terminal");
        new SearchStockController(root);
        Scene scene = new Scene(root,TERMINAL_WIDTH,TERMINAL_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
