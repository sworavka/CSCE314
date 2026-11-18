import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Example 2: Clean MVC JavaFX Application
 * 
 * - Ex2App: Launches the application and handles events as the Controller.
 * - Ex2View.fxml: Layout designed in SceneBuilder (View).
 * - style.css: Visual styling externalized (CSS).
 */
public class Ex2App extends Application {

    // View component injected by JavaFX matching fx:id="countLabel" in Ex2View.fxml
    @FXML
    private Label countLabel;

    // Model: State of the counter
    private int count = 0;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ex2View.fxml"));
        loader.setControllerFactory(type -> this);
        Parent root = loader.load();

        Scene scene = new Scene(root, 320, 200);
        stage.setTitle("Ex2: MVC Counter");
        stage.setScene(scene);
        stage.show();
    }

    // Triggered by onAction="#handleIncrement" in SceneBuilder
    @FXML
    private void handleIncrement() {
        count++;
        countLabel.setText("Count: " + count);
    }

    // Triggered by onAction="#handleReset" in SceneBuilder
    @FXML
    private void handleReset() {
        count = 0;
        countLabel.setText("Count: 0");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
