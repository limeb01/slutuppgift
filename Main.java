
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
import javafx.scene.shape.;
import javafx.scene.Scene.;


	import java.awt.*;
	import java.util.ArrayList;

	public class Main extends Application {

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
	            System.out.println("HEHE");
	        });



	       startGameButton.setPrefSize(300,100);
	       menu.getChildren().add(startGameButton);


	        primaryStage.setScene(menuScene);
	        primaryStage.show();



	    }
	    public Scene gameScene(){

	        HBox grid = new HBox();
	        grid.setMinSize(500,500);
	        Scene gameScene = new Scene(grid);

	        Rectangle gridRectangle = new Rectangle(100,100);
	        gridRectangle.setFill(Color.BLACK);
	        gridRectangle.setStroke(Color.WHITE);
	        Rectangle test = gridRectangle;


	            grid.getChildren().addAll(gridRectangle,test);




	        return gameScene;
	    }


	}

	