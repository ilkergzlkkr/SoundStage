package com.soundstage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import com.soundstage.controllers.player.MediaController;

public class App extends Application {

    public static Stage stage;
    public static Scene scene;
    public static VBox root;

    public static MediaController mediaController = new MediaController();

    public static Parent[] elements = new Parent[3];

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        System.out.println("SoundStage");
        stage.setTitle("SoundStage");

        root = new VBox();
        root.setAlignment(Pos.CENTER);
        elements[0] = loadFXML("player/body");
        elements[1] = loadFXML("player/media", mediaController);
        elements[2] = loadFXML("player/navigation");
        setRoot(false);

        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(Boolean isLoaded) throws IOException {
        root.getChildren().setAll(isLoaded ? elements[1] : elements[0], elements[2]);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        return loadFXML(fxml, null);
    }

    private static Parent loadFXML(String fxml, BaseController controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        if (controller != null)
            fxmlLoader.setController(controller);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static String version = App.class.getPackage().getImplementationVersion();

}