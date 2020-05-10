
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.Scene.*;
import javafx.scene.text.Text;



import java.awt.*;
import java.util.ArrayList;

public class Main extends Application {

    Boolean isPlayer1Playing = true;

    ArrayList <Rectangle> rectangleArrayList = new ArrayList<>();

    ArrayList <Circle> circleArray = new ArrayList<>();

    ArrayList <Text> crossArray = new ArrayList<>();

    GridPane grid = new GridPane();

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
        grid = new GridPane();
        grid.setMinSize(500,500);
        Scene gameScene = new Scene(grid);
        int x=0;


        for (int i = 0; i < 9 ; i++) {
            if (i%3==0){
                x++;
            }
            Rectangle gridRectangle = new Rectangle(200,200);

            gridRectangle.setFill(Color.BLACK);
            gridRectangle.setStroke(Color.WHITE);

            final int arrayIndex = i;

            gridRectangle.setOnMousePressed(event -> {

                System.out.println("�������������������");
                if (isPlayer1Playing){
                    circleArray.get(arrayIndex).setVisible(true);
                    isPlayer1Playing = false;
                }else {
                    crossArray.get(arrayIndex).setVisible(true);
                    isPlayer1Playing = true;
                }



            });
            Circle test = new Circle();
            test.setRadius(80);
            test.setStroke(Color.WHITE);
            test.setStrokeWidth(20);
            test.setFill(Color.BLACK);
            test.setVisible(false);


            Text cross = new Text("X");
            cross.setStyle("-fx-font-size:150" );
            cross.setLineSpacing(0);
            cross.setVisible(false);
            cross.setFill(Color.RED);

            StackPane h = new StackPane();
            h.setPrefSize(100,100);
            h.getChildren().addAll(gridRectangle,test,cross);
            crossArray.add(cross);
            circleArray.add(test);
            rectangleArrayList.add(gridRectangle);



            grid.addRow(x,h);







            }


        return gameScene;

        }



    public void drawCross(){
        Circle test = new Circle();



    }
    public void drawCircle(){

    }
    public void game(){
        while (true){



        }

    }


}


	