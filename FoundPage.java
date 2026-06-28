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

public class FoundPage {

    public static Scene getScene(Stage stage) {

        GridPane page3 = new GridPane();

        page3.setPadding(new Insets(30, 30, 30, 30));
        page3.setHgap(10);
        page3.setVgap(10);
        page3.setAlignment(Pos.CENTER);

        Label print2 = new Label();

        Label titleFound = new Label("Enter Details of Found Item");
        titleFound.setFont(new Font("Arial", 25));

        Label name1 = new Label("Name:");
        name1.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label location1 = new Label("Location:");
        location1.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label description1 = new Label("Description:");
        description1.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label time1 = new Label("Time:");
        time1.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label phone1 = new Label("Phone:");
        phone1.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        TextField nameField1 = new TextField();
        TextField locationField1 = new TextField();
        TextField descriptionField1 = new TextField();
        TextField timeField1 = new TextField();
        TextField phoneField1 = new TextField();

        Button foundBtn = new Button("Submit");
        Button backBtn1 = new Button("Back");

        Label feedbackText1 = new Label("Give Feedback");
        feedbackText1.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        feedbackText1.setStyle("-fx-text-fill: blue;");
        feedbackText1.setCursor(Cursor.HAND);

        page3.add(titleFound, 0, 0, 2, 1);

        page3.add(name1, 0, 1);
        page3.add(nameField1, 1, 1);

        page3.add(location1, 0, 2);
        page3.add(locationField1, 1, 2);

        page3.add(description1, 0, 3);
        page3.add(descriptionField1, 1, 3);

        page3.add(time1, 0, 4);
        page3.add(timeField1, 1, 4);

        page3.add(phone1, 0, 5);
        page3.add(phoneField1, 1, 5);

        page3.add(backBtn1, 0, 6);
        page3.add(foundBtn, 1, 6);

        page3.add(print2, 0, 7, 2, 1);

        page3.add(feedbackText1, 1, 8);

        Scene foundScene = new Scene(page3, 600, 400);

        backBtn1.setOnAction(e -> {
            stage.setScene(MenuPage.getScene(stage));
        });

        foundBtn.setOnAction(e -> {

            try {

                FoundItem found = new FoundItem(
                        nameField1.getText(),
                        locationField1.getText(),
                        timeField1.getText(),
                        descriptionField1.getText(),
                        phoneField1.getText()
                );

                CompareAndCheck.foundList.add(found);

                String result = CompareAndCheck.searchMatchForFound(found);

                print2.setText(result);
                print2.setWrapText(true);
                print2.setMaxWidth(350);

            } catch (Exception exp) {

                print2.setText(exp.getMessage());
            }
        });

        feedbackText1.setOnMouseClicked(e -> {
            stage.setScene(FeedbackPage.getScene(stage));
            stage.setTitle("Feedback Form");
        });

        return foundScene;
    }
}