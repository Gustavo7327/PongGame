import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gamepane.setOpacity(0);
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(gamepane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

}
