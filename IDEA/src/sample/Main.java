package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Reflection reflection = new Reflection();
        // create stops
        Stop[] stops = new Stop[] {
            new Stop(0, Color.BLACK),
            new Stop(1, Color.WHITE),
        };
       LinearGradient gradient = new LinearGradient(0,0,0,0.5,true, CycleMethod.REFLECT, stops);
        reflection.setFraction(0.8);
        // button
        Text helloWorld = new Text("Hello world");
        helloWorld.setStyle("-fx-font: 30 manospaced;" + "-fx-fill: #ff0000");
        helloWorld.setEffect(reflection);
        // adding scene
        StackPane root = new StackPane();
        root.getChildren().add(helloWorld);

        Scene scene = new Scene(root, 300, 350, gradient);
        // adding scene to primary stage
        primaryStage.setTitle("First App. without css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
