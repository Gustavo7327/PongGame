import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SettingsController implements Initializable{

    @FXML
    private Button butback;

    @FXML
    private CheckBox checkmusic;

    @FXML
    private AnchorPane settingspane;

    @FXML
    private Slider volumeslider;

    private Parent root;
    private Scene scene;
    private Stage stage;
    private FadeTransition fadeTransition;

    @FXML
    void backToMenu(ActionEvent event) {
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(settingspane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("gamestart.fxml"));
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
    void disableMusic(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settingspane.setOpacity(0);
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(settingspane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

}
