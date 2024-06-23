package at.ftmahringer.lazyae2macalc;

import javafx.application.Application;
import javafx.stage.Stage;

public class Starter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager sceneManager = new SceneManager(primaryStage);
        sceneManager.setScene(Scenes.CALC);
        sceneManager.showScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
