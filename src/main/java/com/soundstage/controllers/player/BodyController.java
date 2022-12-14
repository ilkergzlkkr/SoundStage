package com.soundstage.controllers.player;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.soundstage.App;
import com.soundstage.BaseController;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class BodyController extends BaseController {

    public static File file;

    @FXML
    public void disposeMediaAction() {
        App.mediaController.disposeMedia();
    }

    @FXML
    public void openFileAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Media File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", supportedTypes),
                new FileChooser.ExtensionFilter("Audio Files", supportedAudioTypes),
                new FileChooser.ExtensionFilter("Media Files", supportedVideoTypes));
        file = fileChooser.showOpenDialog(App.stage);

        if (file != null) {
            try {
                switchToMedia();
            } catch (Exception e) {
                e.printStackTrace();
            }
            App.mediaController.setMedia(file.toURI());
        }
    }

    // supported file types
    public static List<String> supportedAudioTypes = Arrays
            .asList(new String[] { "*.mp3", "*.wav", "*.aac", "*.m4a", "*.ogg", "*.flac" });
    public static List<String> supportedVideoTypes = Arrays
            .asList(new String[] { "*.mp4", "*.mkv", "*.avi", "*.mov", "*.wmv", "*.flv" });
    public static List<String> supportedTypes = new ArrayList<String>() {
        {
            addAll(supportedAudioTypes);
            addAll(supportedVideoTypes);
        }
    };

}