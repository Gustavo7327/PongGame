package PONG;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage arg0) throws Exception {
        new GameStart();
    }
    
    public static void main(String[]args){
        launch(args);
    }
}
