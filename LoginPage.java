package management.lostandfoundsystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginPage {

    public static Scene getScene(Stage stage) {

        GridPane layout = new GridPane();

        layout.setPadding(new Insets(30));
        layout.setHgap(10);
        layout.setVgap(15);
        layout.setAlignment(Pos.CENTER);

        Label welcome = new Label("Login Page");
        welcome.setFont(new Font("Arial", 25));

        Label userName = new Label("User Name");
        Label password = new Label("Password");

        TextField userField = new TextField();
        PasswordField passField = new PasswordField();

        Button loginBtn = new Button("Login");
        Button backBtn = new Button("Back");

        // Bold Buttons
        loginBtn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        backBtn.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label forgotText = new Label("Forgot Password?");
        forgotText.setStyle("-fx-text-fill: blue;");
        forgotText.setCursor(Cursor.HAND);

        Label msg = new Label();

        HBox buttonBox = new HBox(15);
        buttonBox.getChildren().addAll(loginBtn, backBtn);

        layout.add(welcome, 0, 0);

        layout.add(userName, 0, 1);
        layout.add(userField, 1, 1);

        layout.add(password, 0, 2);
        layout.add(passField, 1, 2);

        layout.add(buttonBox, 1, 3);

        layout.add(forgotText, 1, 4);

        layout.add(msg, 0, 5, 2, 1);

        Scene scene = new Scene(layout, 600, 400);

        loginBtn.setOnAction(e -> {

            if (userField.getText().equals(management.lostandfoundsystem.MainSystem.savedUsername)
                    &&
                    passField.getText().equals(management.lostandfoundsystem.MainSystem.savedPassword)) {

                stage.setScene(MenuPage.getScene(stage));

            } else {

                msg.setStyle("-fx-text-fill:red;");
                msg.setText("Invalid Username or Password!");
            }
        });

        forgotText.setOnMouseClicked(e -> {
            stage.setScene(ForgetPage.getScene(stage));
        });

        backBtn.setOnAction(e -> {
            stage.setScene(FirstPage.getScene(stage));
        });

        return scene;
    }
}