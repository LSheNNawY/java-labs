package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFxWithCss extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Reflection reflection = new Reflection();
        // create stops
        reflection.setFraction(0.8);
        // button
        Text helloWorld = new Text("Hello world");

        helloWorld.setEffect(reflection);
        // adding scene
        StackPane root = new StackPane();
        root.getChildren().add(helloWorld);

        Scene scene = new Scene(root, 300, 350);

        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        helloWorld.getStyleClass().add("helloworld");

        // adding scene to primary stage
        primaryStage.setTitle("First App. with css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
