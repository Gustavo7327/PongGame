package PONG;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameStart extends Application{

    public static boolean ONE_PLAYER;
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    
    @Override
    public void start(Stage stage) throws Exception {

        Button buttonPlayOne = new Button("1P PLAYER");
        buttonPlayOne.setFont(new Font(20));
        buttonPlayOne.setPrefHeight(40);
        buttonPlayOne.setPrefWidth(280);
        buttonPlayOne.setLayoutY(316);
        buttonPlayOne.setLayoutX(260);

        Button buttonPlayTwo = new Button("2P PLAYER");
        buttonPlayTwo.setFont(new Font(20));
        buttonPlayTwo.setPrefHeight(40);
        buttonPlayTwo.setPrefWidth(280);
        buttonPlayTwo.setLayoutY(378);
        buttonPlayTwo.setLayoutX(260);

        Button buttonSettings = new Button("SETTINGS");
        buttonSettings.setFont(new Font(20));
        buttonSettings.setPrefHeight(40);
        buttonSettings.setPrefWidth(280);
        buttonSettings.setLayoutY(440);
        buttonSettings.setLayoutX(260);

        Text titleText = new Text();
        titleText.setFont(new Font(30));
        titleText.setText("PONG GAME");
        titleText.setFill(Color.WHITE);
        titleText.setLayoutX(GAME_WIDTH/4);
        titleText.setLayoutY(158);

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #1B1818;");
        pane.getChildren().addAll(buttonPlayOne, buttonPlayTwo, buttonSettings, titleText);

        stage.setTitle("PONG GAME");
        stage.setScene(new Scene(pane, GAME_WIDTH, GAME_HEIGHT));
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
