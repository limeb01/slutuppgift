import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {


    public static VBox gameWon;
    public static Boolean isPlayer1Playing = true;
    public static ArrayList <Rectangle> rectangleArrayList = new ArrayList<>();
    public static ArrayList <Circle> circleArray = new ArrayList<>();
    public static ArrayList <Text> crossArray = new ArrayList<>();
    public static GridPane grid = new GridPane();
    public static Text winnerText = new Text();
    public static Stage mainStage;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        VBox menu = new VBox();
        menu.setPrefWidth(500);
        menu.setPrefHeight(500);
        menu.setAlignment(Pos.CENTER);

        mainStage.setScene(Functions.gameScene());
        mainStage.show();


    }
}
