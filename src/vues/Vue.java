package vues;

import javafx.scene.Scene;

import java.util.Observer;

public abstract class Vue implements Observer {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 450;

    protected Scene scene;

    /**
     * @return La scène de la vue
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Initialise la vue
     */
    public void init() {}
}
