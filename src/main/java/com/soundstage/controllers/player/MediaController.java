package com.soundstage.controllers.player;

import java.net.URI;

import com.soundstage.App;
import com.soundstage.BaseController;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaController extends BaseController {

    @FXML
    public MediaView view = new MediaView();

    @FXML
    public MediaPlayer player;

    @FXML
    public void initialize() {
        view.fitWidthProperty().bind(App.root.widthProperty());
        view.fitHeightProperty().bind(App.root.heightProperty());
    }

    public void setMedia(URI uri) {
        removePlayer();
        Media media = new Media(uri.toString());
        player = new MediaPlayer(media);
        player.setAutoPlay(true);
        view.setMediaPlayer(player);
        VBox mediaNode = (VBox) App.elements[1];
        App.root.widthProperty().addListener((obs, oldVal, newVal) -> {
            mediaNode.setPrefWidth(newVal.doubleValue() - getNavigatorNode().getBoundsInParent().getWidth());
        });
        App.root.heightProperty().addListener((obs, oldVal, newVal) -> {
            mediaNode.setPrefHeight(newVal.doubleValue() - getNavigatorNode().getBoundsInParent().getHeight());
        });
        player.play();
    }

    public void removePlayer() {
        if (player != null && player.getStatus() != MediaPlayer.Status.DISPOSED) {
            player.stop();
            player.dispose();
            player = null;
        }
    }

    public void disposeMedia() {
        removePlayer();
        try {
            switchToBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Parent getNavigatorNode() {
        return App.elements[2];
    }

}
