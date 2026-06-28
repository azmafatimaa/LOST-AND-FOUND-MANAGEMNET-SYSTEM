package management.lostandfoundsystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ThankYouPage {

    public static Scene getScene(Stage stage) {

        GridPane thankPane = new GridPane();

        thankPane.setPadding(new Insets(30));
        thankPane.setVgap(20);
        thankPane.setAlignment(Pos.CENTER);

        Label thankMsg = new Label("THANK YOU FOR YOUR FEEDBACK");
        thankMsg.setFont(new Font("Arial", 30));

        Label subMsg = new Label(
                "Your feedback will help us improve our service\n" +
                        "and provide a better experience in the future."
        );

        subMsg.setFont(new Font("Arial", 16));
        subMsg.setTextAlignment(TextAlignment.CENTER);

        Label visitMsg = new Label(
                "We appreciate your valuable time and suggestions."
        );

        visitMsg.setFont(new Font("Arial", 14));

        Button exitFinalBtn = new Button("Exit");
        exitFinalBtn.setPrefWidth(120);

        thankPane.add(thankMsg, 0, 0);
        thankPane.add(subMsg, 0, 1);
        thankPane.add(visitMsg, 0, 2);
        thankPane.add(exitFinalBtn, 0, 3);

        Scene thankScene = new Scene(thankPane, 600, 400);

        exitFinalBtn.setOnAction(e -> {
            System.exit(0);
        });

        return thankScene;
    }
}
