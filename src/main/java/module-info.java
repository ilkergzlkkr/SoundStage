module com.soundstage {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;
    requires transitive javafx.graphics;

    opens com.soundstage to javafx.fxml;
    opens com.soundstage.controllers.player to javafx.fxml;

    exports com.soundstage;
    exports com.soundstage.controllers.player;
}
