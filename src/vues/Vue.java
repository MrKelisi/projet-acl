package vues;

import javafx.scene.Scene;

public abstract class Vue {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 450;

    protected Scene scene;

    public Scene getScene() {
        return scene;
    }

}
