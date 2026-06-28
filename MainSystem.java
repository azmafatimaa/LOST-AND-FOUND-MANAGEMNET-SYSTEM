package management.lostandfoundsystem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSystem extends Application {

    public static String savedUsername = "";
    public static String savedPassword = "";
    public static String savedContact="";


    @Override
    public void start(Stage stage) {

        Scene firstScene = FirstPage.getScene(stage);
        stage.setTitle("Welcome");
        stage.setScene(firstScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
