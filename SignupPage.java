package management.lostandfoundsystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SignupPage {

    public static Scene getScene(Stage stage) {

        GridPane signUp = new GridPane();

        signUp.setPadding(new Insets(30));
        signUp.setHgap(10);
        signUp.setVgap(10);
        signUp.setAlignment(Pos.CENTER);

        Label title = new Label("Create Account");
        title.setFont(new Font("Arial", 25));

        Label user = new Label("New Username");
        Label contact = new Label("Contact");
        Label pass = new Label("New Password");
        Label confirmPass = new Label("Confirm Password");

        TextField userField = new TextField();
        TextField contactField = new TextField();

        PasswordField passField = new PasswordField();
        PasswordField confirmPassField = new PasswordField();

        Button signupBtn = new Button("Create Account");
        Button backBtn = new Button("Back");

        signupBtn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        backBtn.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label msg = new Label();

        signUp.add(title, 0, 0);

        signUp.add(user, 0, 1);
        signUp.add(userField, 1, 1);

        signUp.add(contact, 0, 2);
        signUp.add(contactField, 1, 2);

        signUp.add(pass, 0, 3);
        signUp.add(passField, 1, 3);

        signUp.add(confirmPass, 0, 4);
        signUp.add(confirmPassField, 1, 4);

        signUp.add(signupBtn, 0, 5);
        signUp.add(backBtn, 1, 5);

        signUp.add(msg, 0, 6);

        Scene scene = new Scene(signUp, 600, 400);

        signupBtn.setOnAction(e -> {

            if (userField.getText().isEmpty()
                    || contactField.getText().isEmpty()
                    || passField.getText().isEmpty()
                    || confirmPassField.getText().isEmpty()) {

                msg.setStyle("-fx-text-fill:red;");
                msg.setText("Fields Can't Be Empty!");
            }

            else if (!passField.getText().equals(confirmPassField.getText())) {

                msg.setStyle("-fx-text-fill:red;");
                msg.setText("Passwords Do Not Match!");
            }

            else {

                MainSystem.savedUsername = userField.getText();
                MainSystem.savedPassword = passField.getText();
                MainSystem.savedContact = contactField.getText();

                msg.setStyle("-fx-text-fill:green;");
                msg.setText("Account Created Successfully!");
            }
        });

        backBtn.setOnAction(e -> {
            stage.setScene(LoginPage.getScene(stage));
        });

        return scene;
    }
}