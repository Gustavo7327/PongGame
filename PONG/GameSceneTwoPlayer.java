package PONG;

import java.io.File;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameSceneTwoPlayer {
    
    private BooleanProperty keyW = new SimpleBooleanProperty();
    private BooleanProperty keyZ = new SimpleBooleanProperty();
    private BooleanProperty keyUP = new SimpleBooleanProperty();
    private BooleanProperty keyDOWN = new SimpleBooleanProperty();
    private BooleanBinding keyPressed = keyW.or(keyZ).or(keyUP).or(keyDOWN);
    private boolean gameStarted = false;

    private int ballYSpeed = 1;
    private int ballXSpeed = 1;
    private double playerOneYPos = GameStart.GAME_HEIGHT / 2 - 50;
    private double playerTwoYPos = GameStart.GAME_HEIGHT / 2 - 50;
    private double ballXPos = GameStart.GAME_WIDTH / 2;
    private double ballYPos = GameStart.GAME_HEIGHT / 2;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private double playerOneXPos = 0;
    private double playerTwoXPos = GameStart.GAME_WIDTH - PLAYER_WIDTH;
    private static final int PLAYER_WIDTH = 15;
    private static final int PLAYER_HEIGHT = 100;
    private static final double BALL_R = 15;

    File file = new File("PONG/Pongsong.mp3");
    private Media media = new Media(file.toURI().toString());
    private MediaPlayer mp = new MediaPlayer(media);

    AnimationTimer at = new AnimationTimer(){

        @Override
        public void handle(long arg0) {

            if(keyW.get()){
                if(playerOneYPos < 0){
                    playerOneYPos = playerOneYPos + 0;
                } else{
                    playerOneYPos -= 5;
                }
            }

            if(keyZ.get()){
                if(playerOneYPos > GameStart.GAME_HEIGHT - PLAYER_HEIGHT){
                    playerOneYPos = playerOneYPos + 0;
                } else{
                    playerOneYPos += 5;
                }
            }

            if(keyUP.get()){
                if(playerTwoYPos < 0){
                    playerTwoYPos = playerTwoYPos + 0;
                } else{
                    playerTwoYPos -= 5;
                }
            }

            if(keyDOWN.get()){
                if(playerTwoYPos > GameStart.GAME_HEIGHT - PLAYER_HEIGHT){
                    playerTwoYPos = playerTwoYPos + 0;
                } else{
                    playerTwoYPos += 5;
                } 
            }

        }
    };

    private void run(GraphicsContext gc){
        
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,GameStart.GAME_WIDTH,GameStart.GAME_HEIGHT);

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        if(gameStarted){

            ballXPos+=ballXSpeed;
            ballYPos+=ballYSpeed;
            
            gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);

        } else{
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("On click",GameStart.GAME_WIDTH/2, GameStart.GAME_HEIGHT/2);

            ballXPos = GameStart.GAME_WIDTH/2;
            ballYPos = GameStart.GAME_HEIGHT/2;

            ballXSpeed = new Random().nextInt(2) == 0? 1:-1;
            ballYSpeed = new Random().nextInt(2) == 0? 1:-1;

        }
        
        if(ballYPos > GameStart.GAME_HEIGHT || ballYPos < 0){ 
            ballYSpeed *= -1;
            mp.play();
            mp.seek(Duration.ZERO);
        }

        if(ballXPos < playerOneXPos - PLAYER_WIDTH){
            scoreP2++;
            gameStarted = false;
        }

        if(ballXPos > playerTwoXPos + PLAYER_WIDTH){
            scoreP1++;
            gameStarted = false;
        }

        if((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT || ((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)){
            mp.play();
            mp.seek(Duration.ZERO);
            ballYSpeed += 1 * Math.signum(ballYSpeed);
            ballXSpeed += 1 * Math.signum(ballXSpeed);
            ballXSpeed *= -1;
            ballYSpeed *= -1;
        }

        gc.strokeLine(GameStart.GAME_WIDTH/2,0,GameStart.GAME_WIDTH/2, GameStart.GAME_HEIGHT);
        gc.fillText("SCORE "+scoreP1+"\t\t\t\t"+scoreP2+" SCORE",GameStart.GAME_WIDTH/2, 60);
        gc.setFill(Color.BLUE);
        gc.fillRect(playerOneXPos,playerOneYPos,PLAYER_WIDTH,PLAYER_HEIGHT);
        gc.setFill(Color.RED);
        gc.fillRect(playerTwoXPos,playerTwoYPos,PLAYER_WIDTH,PLAYER_HEIGHT);

    }

    private Scene scene;
    GameSceneTwoPlayer(){
        Canvas canvas = new Canvas(GameStart.GAME_WIDTH, GameStart.GAME_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e->run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        scene = new Scene(new StackPane(canvas));
        canvas.setOnMouseClicked(e -> gameStarted = true);
        scene.setOnKeyPressed( e -> {
            if(e.getCode() == KeyCode.W){
                keyW.set(true);
            }
            if(e.getCode() == KeyCode.Z){
                keyZ.set(true);
            }
            if(e.getCode() == KeyCode.UP){
                keyUP.set(true);
            }
            if(e.getCode() == KeyCode.DOWN){
                keyDOWN.set(true);
            }
        });

        scene.setOnKeyReleased( e -> {
            if(e.getCode() == KeyCode.W){
                keyW.set(false);
            }
            if(e.getCode() == KeyCode.Z){
                keyZ.set(false);
            }
            if(e.getCode() == KeyCode.UP){
                keyUP.set(false);
            }
            if(e.getCode() == KeyCode.DOWN){
                keyDOWN.set(false);
            }
        });
        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                at.start();
            } else{
                at.stop();
            }
        }));

        Stage stage = new Stage();
        stage.setTitle("PONG GAME - TWO PLAYERS");
        stage.setScene(scene);
        stage.show();
        tl.play();
    }
}
