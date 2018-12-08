package vues;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public interface Vue {
    int WIDTH = 600;
    int HEIGHT = 450;

    public Scene getScene();
    public void init();
}
