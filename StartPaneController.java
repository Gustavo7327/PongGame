import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartPaneController implements Initializable{

    @FXML
    private Button but1player;

    @FXML
    private Button but2player;

    @FXML
    private Button butsettings;

    @FXML
    private AnchorPane startpane;

    @FXML
    private Text titlegametext;

    private static boolean SINGLEPLAYER;
    private Parent root;
    private Scene scene;
    private Stage stage;
    private FadeTransition fadeTransition;

    @FXML
    void newOnePlayer(ActionEvent event) {
        SINGLEPLAYER = true;
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(startpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("gamepane.fxml"));
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scene = new Scene(root);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }    
        });
        fadeTransition.play();
    }

    @FXML
    void newTwoPlayer(ActionEvent event) {
        SINGLEPLAYER = false;
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(startpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("gamepane.fxml"));
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scene = new Scene(root);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }    
        });
        fadeTransition.play();
    }

    @FXML
    void settings(ActionEvent event) {
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(startpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("gamesettings.fxml"));
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scene = new Scene(root);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });
        fadeTransition.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startpane.setOpacity(0);
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(startpane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

}
