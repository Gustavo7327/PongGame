import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.stage.Stage;

public class StartPaneController {

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

    @FXML
    void newOnePlayer(ActionEvent event) {
        SINGLEPLAYER = true;
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

    @FXML
    void newTwoPlayer(ActionEvent event) {
        SINGLEPLAYER = false;
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

    @FXML
    void settings(ActionEvent event) {
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

}
