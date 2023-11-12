package PONG;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameStart{

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    private FadeTransition fadeTransition;
    
    GameStart(){

        Button buttonPlayOne = new Button("SINGLE PLAYER");
        buttonPlayOne.setFont(new Font(20));
        buttonPlayOne.setPrefHeight(40);
        buttonPlayOne.setPrefWidth(280);
        buttonPlayOne.setLayoutY(316);
        buttonPlayOne.setLayoutX(260);

        Button buttonPlayTwo = new Button("TWO PLAYER");
        buttonPlayTwo.setFont(new Font(20));
        buttonPlayTwo.setPrefHeight(40);
        buttonPlayTwo.setPrefWidth(280);
        buttonPlayTwo.setLayoutY(378);
        buttonPlayTwo.setLayoutX(260);

        Button buttonSettings = new Button("HOW TO PLAY");
        buttonSettings.setFont(new Font(20));
        buttonSettings.setPrefHeight(40);
        buttonSettings.setPrefWidth(280);
        buttonSettings.setLayoutY(440);
        buttonSettings.setLayoutX(260);

        Text titleText = new Text();
        titleText.setFont(new Font(30));
        titleText.setText("PONG GAME");
        titleText.setFill(Color.WHITE);
        titleText.setScaleX(2);
        titleText.setScaleY(2);
        titleText.setStrokeType(StrokeType.OUTSIDE);
        titleText.setLayoutX(309);
        titleText.setLayoutY(158);

        Text creatorText = new Text();
        creatorText.setFont(new Font(25));
        creatorText.setText("By Gustavo7327");
        creatorText.setFill(Color.WHITE);
        creatorText.setScaleX(1);
        creatorText.setScaleY(1);
        creatorText.setStrokeType(StrokeType.OUTSIDE);
        creatorText.setLayoutX(300);
        creatorText.setLayoutY(200);

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #1B1818;");
        pane.getChildren().addAll(buttonPlayOne, buttonPlayTwo, buttonSettings, titleText, creatorText);

        pane.setOpacity(0);
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        Stage stage = new Stage();
        stage.setTitle("PONG GAME - MENU");
        stage.setScene(new Scene(pane, GAME_WIDTH, GAME_HEIGHT));
        stage.show();

        buttonPlayOne.setOnAction(event -> {
            fadeTransition = new FadeTransition();
            fadeTransition.setDuration(Duration.millis(1000));
            fadeTransition.setNode(pane);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                new GameSceneOnePlayer();
                stage.close();
            }
        }); 
            fadeTransition.play();
            
        });

        buttonPlayTwo.setOnAction(event -> {
            fadeTransition = new FadeTransition();
            fadeTransition.setDuration(Duration.millis(1000));
            fadeTransition.setNode(pane);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                new GameSceneTwoPlayer();
                stage.close();
            }
        }); 
            fadeTransition.play();
            
        });

        buttonSettings.setOnAction(event -> {
            fadeTransition = new FadeTransition();
            fadeTransition.setDuration(Duration.millis(1000));
            fadeTransition.setNode(pane);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                new GameSettings();
                stage.close();
            }
        }); 
            fadeTransition.play();
            
        });
    }

}
