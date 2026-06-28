package management.lostandfoundsystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FeedbackPage {

    public static Scene getScene(Stage stage) {

        GridPane feedBack = new GridPane();

        feedBack.setPadding(new Insets(30, 30, 30, 30));
        feedBack.setHgap(10);
        feedBack.setVgap(10);
        feedBack.setAlignment(Pos.CENTER);

        Label feedTitle = new Label(
                "Thank You for using Lost and Found Management System."
                        + "\n Please give your Feedback"
        );

        feedTitle.setFont(new Font("Arial", 25));
        feedTitle.setWrapText(true);

        Label helpFul = new Label("Was this system Helpful");

        RadioButton yes = new RadioButton("YES");
        RadioButton no = new RadioButton("NO");

        ToggleGroup feedBackGroup = new ToggleGroup();

        yes.setToggleGroup(feedBackGroup);
        no.setToggleGroup(feedBackGroup);

        Label rating = new Label("Give Rating");

        RadioButton rating1 = new RadioButton("1");
        RadioButton rating2 = new RadioButton("2");
        RadioButton rating3 = new RadioButton("3");
        RadioButton rating4 = new RadioButton("4");
        RadioButton rating5 = new RadioButton("5");

        ToggleGroup ratingGroup = new ToggleGroup();

        rating1.setToggleGroup(ratingGroup);
        rating2.setToggleGroup(ratingGroup);
        rating3.setToggleGroup(ratingGroup);
        rating4.setToggleGroup(ratingGroup);
        rating5.setToggleGroup(ratingGroup);

        HBox ratingBox = new HBox(15);

        ratingBox.getChildren().addAll(
                rating1,
                rating2,
                rating3,
                rating4,
                rating5
        );

        Label remarks = new Label("Give Remarks");

        TextField remarksArea = new TextField();
        remarksArea.setFont(new Font("Arial", 15));

        Button submitFeedback = new Button("Submit");

        Label thanksLabel = new Label();

        feedBack.add(feedTitle, 0, 0, 2, 1);

        feedBack.add(helpFul, 0, 1);

        feedBack.add(yes, 0, 2);
        feedBack.add(no, 1, 2);

        feedBack.add(rating, 0, 3);

        feedBack.add(ratingBox, 0, 4, 2, 1);

        feedBack.add(remarks, 0, 5);
        feedBack.add(remarksArea, 0, 6, 3, 1);

        feedBack.add(submitFeedback, 0, 7);

        feedBack.add(thanksLabel, 0, 8, 2, 1);

        Scene feedBackScene = new Scene(feedBack, 600, 400);

        submitFeedback.setOnAction(e -> {

            thanksLabel.setText("THANK YOU FOR YOUR FEEDBACK");

            stage.setScene(management.lostandfoundsystem.ThankYouPage.getScene(stage));
            stage.setTitle("Thank You");
        });


        return feedBackScene;
    }
}
