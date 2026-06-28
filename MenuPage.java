package management.lostandfoundsystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MenuPage {

    public static Scene getScene(Stage stage) {

        GridPane grid = new GridPane();

        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Label title = new Label("WELCOME TO LOST AND FOUND MANAGEMENT SYSTEM");

        title.setFont(new Font("Arial", 24));
        title.setTextAlignment(TextAlignment.CENTER);
        title.setWrapText(true);

        Label optionLost = new Label("Report Lost Item");
        optionLost.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        Label optionFound = new Label("Report Found Item");
        optionFound.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        Label optionExit = new Label("Exit");
        optionExit.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        RadioButton optLost = new RadioButton();
        RadioButton optFound = new RadioButton();
        RadioButton optExit = new RadioButton();

        ToggleGroup group = new ToggleGroup();

        optLost.setToggleGroup(group);
        optFound.setToggleGroup(group);
        optExit.setToggleGroup(group);

        grid.add(title, 0, 0, 2, 1);

        grid.add(optionLost, 0, 1);
        grid.add(optLost, 1, 1);

        grid.add(optionFound, 0, 2);
        grid.add(optFound, 1, 2);

        grid.add(optionExit, 0, 3);
        grid.add(optExit, 1, 3);

        Scene menuScene = new Scene(grid, 600, 400);

        optLost.setOnAction(e -> {
            stage.setScene(LostPage.getScene(stage));
            stage.setTitle("Lost Page");
        });

        optFound.setOnAction(e -> {
            stage.setScene(FoundPage.getScene(stage));
            stage.setTitle("Found Page");
        });

        optExit.setOnAction(e -> {
            stage.setScene(LoginPage.getScene(stage));
        });

        return menuScene;
    }
}