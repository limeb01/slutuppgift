
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.Scene.*;


import java.awt.*;
import java.util.ArrayList;

public class Main extends Application {

    Boolean isPlayer1Playing;

    ArrayList <Rectangle> rectangleArrayList = new ArrayList<>();

    ArrayList <Integer> test = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {

        VBox menu = new VBox();
        menu.setPrefWidth(500);
        menu.setPrefHeight(500);
        menu.setAlignment(Pos.CENTER);


        Scene menuScene = new Scene(menu,500,500);


        Button startGameButton = new Button("Start Game");
        startGameButton.setOnAction(event -> {
            primaryStage.setScene(gameScene());
        });
        Button exitGameButton = new Button("Exit Game");



       startGameButton.setPrefSize(300,100);
       menu.getChildren().addAll(startGameButton,exitGameButton);


        primaryStage.setScene(menuScene);
        primaryStage.show();



    }
    public Scene gameScene(){

        GridPane grid = new GridPane();
        grid.setMinSize(500,500);
        Scene gameScene = new Scene(grid);
        int x=0;
        int temp;

        for (int i = 0; i < 9 ; i++) {
            if (i%3==0){
                x++;
            }
            Rectangle gridRectangle = new Rectangle(200,200);
            gridRectangle.setFill(Color.BLACK);
            gridRectangle.setStroke(Color.WHITE);

            gridRectangle.setOnMousePressed(event -> {

                gridRectangle.setFill(Color.BLUE);


            });
            rectangleArrayList.add(gridRectangle);
            grid.addRow(x,rectangleArrayList.get(i));

            }



        return gameScene;

        }



    public void drawCross(){

    }
    public void drawCircle(){

    }
    public void game(){
        while (true){



        }

    }


}

	