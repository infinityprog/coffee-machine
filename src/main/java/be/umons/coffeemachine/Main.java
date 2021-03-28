package be.umons.coffeemachine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Configurator.setRootLevel(Level.DEBUG);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("scene.fxml")));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

        stage.setTitle("Machine coffee");
        stage.setScene(scene);
        stage.show();
    }
}
