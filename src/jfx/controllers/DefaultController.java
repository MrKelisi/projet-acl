package jfx.controllers;

import javafx.stage.Stage;

public abstract class DefaultController {

    protected Stage primaryStage;

    public void setPrimaryScene(Stage stage) {
        primaryStage = stage;
    }

}
