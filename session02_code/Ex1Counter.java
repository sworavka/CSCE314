import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Example 1: Everything in One Code (Monolithic JavaFX)
 * 
 * - UI creation, layout, state, and event handling all live in this single file.
 * - Simple to write for small programs, but hard to test and maintain as apps grow.
 */
public class Ex1Counter extends Application {

    // 1. STATE (Data/Model trapped inside the GUI class)
    private int count = 0;

    @Override
    public void start(Stage stage) {
        // 2. VIEW: Create UI controls in Java code
        Label titleLabel = new Label("Example 1: Single-File Counter");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #500000;");

        Label countLabel = new Label("Count: 0");
        countLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        Button incrementButton = new Button("Count (+1)");
        Button resetButton = new Button("Reset");

        // 3. CONTROLLER: Event handling wired with lambdas
        incrementButton.setOnAction(e -> {
            count++;
            countLabel.setText("Count: " + count);
        });

        resetButton.setOnAction(e -> {
            count = 0;
            countLabel.setText("Count: 0");
        });

        // 4. LAYOUT: Arrange controls in layout containers
        HBox buttonBox = new HBox(10, incrementButton, resetButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, titleLabel, countLabel, buttonBox);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20px; -fx-background-color: #f7f9fa;");

        // 5. STAGE & SCENE: Put root node on Scene, and Scene on Stage
        Scene scene = new Scene(root, 320, 200);
        stage.setTitle("Ex1: Single-File Counter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
