// Cohen Gallagher - 3/7/25

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {

    // Runs the fxml file to display a GUI

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ClientForm.fxml"));
        primaryStage.setTitle("Client Inventory Program");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}