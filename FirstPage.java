package management.lostandfoundsystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FirstPage {

    public static Scene getScene(Stage stage) {

        GridPane firstPage = new GridPane();
        firstPage.setPadding(new Insets(30));
        firstPage.setVgap(20);
        firstPage.setAlignment(Pos.CENTER);

        Label firstTitle = new Label("WELCOME TO\nLOST AND FOUND SYSTEM");
        firstTitle.setFont(new Font("Arial", 30));
        firstTitle.setTextAlignment(TextAlignment.CENTER);

        Button firstLoginBtn = new Button("Login");
        Button firstSignupBtn = new Button("Sign Up");
        Button firstExitBtn = new Button("Exit");

        firstLoginBtn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        firstSignupBtn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        firstExitBtn.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        VBox box = new VBox(15);

        box.getChildren().addAll(
                firstLoginBtn,
                firstSignupBtn,
                firstExitBtn
        );

        box.setAlignment(Pos.CENTER);

        firstPage.add(firstTitle, 0, 0);
        firstPage.add(box, 0, 1);

        Scene scene = new Scene(firstPage, 600, 400);

        firstLoginBtn.setOnAction(e -> {
            stage.setScene(management.lostandfoundsystem.LoginPage.getScene(stage));
        });

        firstSignupBtn.setOnAction(e -> {
            stage.setScene(SignupPage.getScene(stage));
        });

        firstExitBtn.setOnAction(e -> System.exit(0));

        return scene;
    }
}