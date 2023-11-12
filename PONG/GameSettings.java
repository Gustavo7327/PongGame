package PONG;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameSettings {

    private FadeTransition fadeTransition;
    GameSettings(){

        Button button = new Button("BACK TO MENU");
        button.setFont(new Font(20));
        button.setPrefHeight(40);
        button.setPrefWidth(260);
        button.setLayoutX(270);
        button.setLayoutY(480);

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #1B1818;");
        pane.getChildren().addAll(button);

        pane.setOpacity(0);
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        Stage stage = new Stage();
        stage.setTitle("PONG GAME - HOW TO PLAY");
        stage.setScene(new Scene(pane, GameStart.GAME_WIDTH, GameStart.GAME_HEIGHT));
        stage.show();

        button.setOnAction(event -> {
            fadeTransition = new FadeTransition();
            fadeTransition.setDuration(Duration.millis(1000));
            fadeTransition.setNode(pane);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                new GameStart();
                stage.close();
            }
        }); 
            fadeTransition.play();

        });

    }
}
