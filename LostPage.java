package management.lostandfoundsystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LostPage {

    public static Scene getScene(Stage stage) {

        GridPane page2 = new GridPane();

        page2.setPadding(new Insets(30, 30, 30, 30));
        page2.setHgap(10);
        page2.setVgap(10);
        page2.setAlignment(Pos.CENTER);

        Label print1 = new Label();

        Label titleLost = new Label("Enter Details of Lost Item");
        titleLost.setFont(new Font("Arial", 25));

        Label name = new Label("Name:");
        name.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label location = new Label("Location:");
        location.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label description = new Label("Description:");
        description.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label time = new Label("Time:");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label phone = new Label("Phone:");
        phone.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        TextField nameField = new TextField();
        TextField locationField = new TextField();
        TextField descriptionField = new TextField();
        TextField timeField = new TextField();
        TextField phoneField = new TextField();

        Button lostBtn = new Button("Submit");
        Button backBtn = new Button("Back");

        Label feedbackText = new Label("Give Feedback");
        feedbackText.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        feedbackText.setStyle("-fx-text-fill: blue;");
        feedbackText.setCursor(Cursor.HAND);

        page2.add(titleLost, 0, 0, 2, 1);

        page2.add(name, 0, 1);
        page2.add(nameField, 1, 1);

        page2.add(location, 0, 2);
        page2.add(locationField, 1, 2);

        page2.add(description, 0, 3);
        page2.add(descriptionField, 1, 3);

        page2.add(time, 0, 4);
        page2.add(timeField, 1, 4);

        page2.add(phone, 0, 5);
        page2.add(phoneField, 1, 5);

        page2.add(backBtn, 0, 6);
        page2.add(lostBtn, 1, 6);

        page2.add(print1, 0, 7, 2, 1);

        page2.add(feedbackText, 1, 8);

        Scene lostScene = new Scene(page2, 600, 400);

        backBtn.setOnAction(e -> {
            stage.setScene(management.lostandfoundsystem.MenuPage.getScene(stage));
        });

        lostBtn.setOnAction(e -> {

            try {

                LostItem lost = new LostItem(
                        nameField.getText(),
                        locationField.getText(),
                        timeField.getText(),
                        descriptionField.getText(),
                        phoneField.getText()
                );

                CompareAndCheck.lostList.add(lost);

                String result = CompareAndCheck.searchMatchForLost(lost);

                print1.setText(result);
                print1.setWrapText(true);
                print1.setMaxWidth(350);

            } catch (Exception exp) {

                print1.setText(exp.getMessage());
            }
        });

        feedbackText.setOnMouseClicked(e -> {
            stage.setScene(FeedbackPage.getScene(stage));
            stage.setTitle("Feedback Form");
        });

        return lostScene;
    }
}