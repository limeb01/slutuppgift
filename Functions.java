import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Functions {
    public static Scene gameScene(){
        StackPane stackPane = new StackPane();

        Main.grid = new GridPane();
        Main.grid.setMinSize(500,500);



        stackPane.getChildren().addAll(Main.grid,gameWon());
        Scene gameScene = new Scene(stackPane);
        Main.crossArray = new ArrayList<>();
        Main.circleArray = new ArrayList<>();
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
                System.out.println(arrayIndex);

                if (!Main.circleArray.get(arrayIndex).isVisible() && !Main.crossArray.get(arrayIndex).isVisible()){
                    if (Main.isPlayer1Playing){
                        Main.circleArray.get(arrayIndex).setVisible(true);
                        Main.isPlayer1Playing = false;

                    }else {
                        Main.crossArray.get(arrayIndex).setVisible(true);
                        Main.isPlayer1Playing = true;

                    }

                }
                checkIfThreeInARow();



            });
            Circle test = new Circle();
            test.setRadius(70);
            test.setStroke(Color.WHITE);
            test.setStrokeWidth(20);
            test.setFill(Color.BLACK);
            test.setVisible(false);


            Text cross = new Text("X");
            cross.setStyle("-fx-font-size:150" );
            cross.setLineSpacing(0);
            cross.setVisible(false);
            cross.setFill(Color.WHITE);

            StackPane h = new StackPane();
            h.setPrefSize(100,100);
            h.getChildren().addAll(gridRectangle,test,cross);
            Main.crossArray.add(cross);
            Main.circleArray.add(test);
            Main.rectangleArrayList.add(gridRectangle);



            Main.grid.addRow(x,h);


        }


        return gameScene;

    }


    // det grafiska när spelet är slut
    private static VBox gameWon(){
        Main.gameWon = new VBox();
        Main.gameWon.setStyle("-fx-background-color: transparent");
        Main.gameWon.setVisible(false);
        Main.gameWon.setMaxSize(300,300);
        Main.gameWon.setAlignment(Pos.CENTER);
        Main.gameWon.setSpacing(50);
        Text gameOverText = new Text("GAME OVER");
        Main.winnerText = new Text("dfsfsfdff");
        Main.winnerText.setFill(Color.GREEN);
        Main.winnerText.setStyle("-fx-font-size:70");
        gameOverText.setFill(Color.GREEN);
        gameOverText.setStyle("-fx-font-size:80" );

        Button playAgain = new Button("Play Again");

        playAgain.setOnAction(event -> { Main.mainStage.setScene(Functions.gameScene()); });

        Button exitGame = new Button("Exit");
        exitGame.setOnAction(event -> {
            Main.mainStage.close();

        });
        Main.gameWon.getChildren().addAll(gameOverText, Main.winnerText,playAgain,exitGame);
        Scene gameWonScene = new Scene(Main.gameWon);
        Main.mainStage.setScene(gameWonScene);

        return Main.gameWon;
    }


    private static void checkIfThreeInARow(){
        boolean crossThreeInARow = false;
        boolean circleThreeInARow = false;
        boolean draw = false;
        int countCross = 0;
        int countCircle = 0;
        int countIfGridFul = 0;


        // kollar de om någon rad är 3 i rad
        for (int j = 0; j < 9; j++) {

            if (j%3==0){
                countCircle=0;
                countCross = 0;
            }

            if (Main.crossArray.get(j).isVisible() ){
                countIfGridFul++;
                countCross++;

            }

            if (Main.circleArray.get(j).isVisible() ){
                countIfGridFul++;
                countCircle++;

            }

            if (countCircle == 3){
                circleThreeInARow = true;
            }
            if (countCross == 3){
                crossThreeInARow = true;
            }

            if (countIfGridFul==9){
                draw = true;
            }

        }
        countCircle = 0;
        countCross = 0;
        int count =0;
        // kollar om det är 3 i rad i kolumnerna
        for (int i = 0; i <3 ; i++) {
            for (int j = i; j <9 ; j++) {
                System.out.println(j+ " hej");
                count++;


                if (Main.circleArray.get(j).isVisible()){
                    countCircle++;
                }
                if (Main.crossArray.get(j).isVisible()){
                    countCross++;
                }

                j=j+2;
                if (count ==3){
                    break;
                }
            }
            if (countCircle == 3){
                circleThreeInARow = true;
            }
            if (countCross == 3){
                crossThreeInARow = true;
            }
            countCircle = 0;
            countCross = 0;
        }



        // kollar om diagonalerna är 3 i rad
        if (Main.circleArray.get(0).isVisible()){
            countCircle++;
        }
        if (Main.circleArray.get(4).isVisible()){
            countCircle++;
        }
        if (Main.circleArray.get(8).isVisible()){
            countCircle++;
        }

        if (Main.crossArray.get(0).isVisible()){
            countCross++;
        }
        if (Main.crossArray.get(4).isVisible()){
            countCross++;
        }
        if (Main.crossArray.get(8).isVisible()){
            countCross++;
        }

        if(countCircle==3){
            circleThreeInARow = true;
        }

        if(countCross==3){
            crossThreeInARow = true;
        }

        countCircle = 0;
        countCross = 0;

        if (Main.circleArray.get(2).isVisible()){
            countCircle++;
        }
        if (Main.circleArray.get(4).isVisible()){
            countCircle++;
        }
        if (Main.circleArray.get(6).isVisible()){
            countCircle++;
        }

        if (Main.crossArray.get(2).isVisible()){
            countCross++;
        }
        if (Main.crossArray.get(4).isVisible()){
            countCross++;
        }
        if (Main.crossArray.get(6).isVisible()){
            countCross++;
        }
        if(countCircle==3){
            circleThreeInARow = true;
        }

        if(countCross==3){
            crossThreeInARow = true;
        }








        if (crossThreeInARow){
            System.out.println("CROSS WIN");
            Main.winnerText.setText("CROSS WIN");
            Main.gameWon.setVisible(true);


        }
        if (circleThreeInARow){
            System.out.println("CIRCLE WIN");
            Main.winnerText.setText("CIRCLE WIN");
            Main.gameWon.setVisible(true);

        }
        if (draw && !circleThreeInARow && !crossThreeInARow){

            Main.winnerText.setText("DRAW");
            Main.gameWon.setVisible(true);
        }





    }

}
