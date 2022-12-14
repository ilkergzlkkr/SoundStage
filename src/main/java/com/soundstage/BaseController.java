package com.soundstage;

import javafx.fxml.FXML;

public class BaseController {

    @FXML
    public String appVersion = App.version;

    @FXML
    public void quit() {
        App.stage.close();
    }

    @FXML
    public void switchToBody() throws Exception {
        App.setRoot(false);
    }

    @FXML
    public void switchToMedia() throws Exception {
        App.setRoot(true);
    }
}
