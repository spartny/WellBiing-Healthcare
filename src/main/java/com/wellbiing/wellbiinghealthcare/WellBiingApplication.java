package com.wellbiing.wellbiinghealthcare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WellBiingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WellBiingApplication.class.getResource("patient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        stage.setTitle("WellBiing Healthcare Management ");
        stage.setScene(scene);
//        stage.setMaxHeight(1080);
//        stage.setMaxWidth(1920);
//        stage.setMinHeight(1080);
//        stage.setMinWidth(1920);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}