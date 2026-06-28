package management.lostandfoundsystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ForgetPage {

    public static Scene getScene(Stage stage) {

        GridPane forgot = new GridPane();

        forgot.setPadding(new Insets(30));
        forgot.setHgap(10);
        forgot.setVgap(10);
        forgot.setAlignment(Pos.CENTER);

        Label title = new Label("Forgot Password");
        title.setFont(new Font("Arial", 25));

        Label enter = new Label("Enter Username");
        Label phone = new Label("Enter Phone Number");

        TextField userField = new TextField();
        TextField phoneField = new TextField();

        Button recoverBtn = new Button("Recover Password");
        Button backBtn = new Button("Back");

        Label result = new Label();

        forgot.add(title, 0, 0);

        forgot.add(enter, 0, 1);
        forgot.add(userField, 1, 1);

        forgot.add(phone, 0, 2);
        forgot.add(phoneField, 1, 2);

        forgot.add(recoverBtn, 0, 3);
        forgot.add(backBtn, 1, 3);

        forgot.add(result, 0, 4);

        Scene scene = new Scene(forgot, 600, 400);

        recoverBtn.setOnAction(e -> {

            if (userField.getText().equals(management.lostandfoundsystem.MainSystem.savedUsername)
                    &&
                    phoneField.getText().equals(management.lostandfoundsystem.MainSystem.savedContact)) {

                result.setStyle("-fx-text-fill: green;");

                result.setText(
                        "Your Password is: "
                                + management.lostandfoundsystem.MainSystem.savedPassword
                );

            } else {

                result.setStyle("-fx-text-fill: red;");

                result.setText("Username or Phone Number not found!");
            }
        });

        backBtn.setOnAction(e -> {
            stage.setScene(management.lostandfoundsystem.LoginPage.getScene(stage));
        });

        return scene;
    }
}