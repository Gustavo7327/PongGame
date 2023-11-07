package PONG;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameSettings {

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

        Stage stage = new Stage();
        stage.setTitle("PONG GAME - HOW TO PLAY");
        stage.setScene(new Scene(pane, GameStart.GAME_WIDTH, GameStart.GAME_HEIGHT));
        stage.show();

        button.setOnAction(event -> {
            new GameStart();
            stage.close();
        });

    }
}
