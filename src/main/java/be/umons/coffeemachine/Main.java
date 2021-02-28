package be.umons.coffeemachine;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.view.CoffeeMachineGUI;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("scene.fxml")));
        Parent root = loader.load();

        CoffeeMachineGUI controller = loader.getController();
        controller.setCoffeeMachine(new CoffeeMachine(controller));


        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.setOnShowing(event -> controller.getCoffeeMachine().initState());
        stage.show();

    }
}
