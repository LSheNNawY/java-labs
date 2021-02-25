package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
        String name = Thread.currentThread().getName();
        System.out.println("Constructor() method: current Thread: " + name);
    }

    @Override
    public void init() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("init() method: current Thread: " + name);
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        String name = Thread.currentThread().getName();
        System.out.println("start() method: current Thread: " + name);

        StackPane root = new StackPane();
        root.getChildren().add(new Text("Life Cycle"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("stop() method: current Thread: " + name);
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
