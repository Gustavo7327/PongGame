import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GamePanelController implements Initializable{

    @FXML
    private Circle ball;

    @FXML
    private Rectangle bluerectangle;

    @FXML
    private AnchorPane gamepane;

    @FXML
    private Text playerbluescore;

    @FXML
    private Text playerredscore;

    @FXML
    private Rectangle redrectangle;

    private FadeTransition fadeTransition;
    private AnimationTimer loop;
    private int bluescore;
    private int redscore;
    private double ballYVelocity = 2.5;
    private double ballXVelocity = 5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gamepane.setOpacity(0);
        bluescore = 0;
        redscore = 0;
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(gamepane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        playerbluescore.setText("Score "+bluescore);
        playerredscore.setText(redscore+" Score");
        
        redrectangle.setOnMouseMoved(event ->{
            redrectangle.setLayoutY(event.getScreenY());
        });

        loop = new AnimationTimer() {
            double control = 0;
            @Override
            public void handle(long time) {
                control += 0.15;
                checkColissions();
                
                if(control > 1){
                    ball.setLayoutY(ball.getLayoutY()+ballYVelocity);
                    ball.setLayoutX(ball.getLayoutX()+ballXVelocity);
                    control = 0;
                }   
            }
            
        };
        loop.start();
        
    }

    private void checkColissions(){
        
        if(redrectangle.getBoundsInParent().intersects(ball.getBoundsInParent())){
            ballXVelocity *= -1.01;
            ballYVelocity *= -1.01;
            

        } if(bluerectangle.getBoundsInParent().intersects(ball.getBoundsInParent())){
            ballXVelocity *= -1.01;
            ballYVelocity *= -1.01;
            
            
        } if(ball.getLayoutY() - ball.getRadius() < 0){
            ballXVelocity *= -1.01;
            ballYVelocity *= -1.01;
            

        } if(ball.getLayoutY() + ball.getRadius() > 500){
            ballXVelocity *= -1.01;
            ballYVelocity *= -1.01;
            

        } if(ball.getLayoutX() + ball.getRadius() > 764){
            ballXVelocity = 5;
            ballYVelocity = 3;
            bluescore++;
            playerbluescore.setText("Score "+bluescore);
            ball.setLayoutX(380);
            ball.setLayoutY(250);
            
        } if(ball.getLayoutX() - ball.getRadius() < 0){
            ballXVelocity = 5;
            ballYVelocity = 3;
            redscore++;
            playerredscore.setText(redscore+" Score");
            ball.setTranslateX(380);
            ball.setTranslateY(250);
        }
    }
}
