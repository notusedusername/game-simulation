package hu.unideb.inf.graphics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerUtil {

    public void loadStage(String fxmlPath, Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Simulation");
        stage.setScene(scene);
        stage.show();

    }
}
