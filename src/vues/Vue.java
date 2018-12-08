package vues;

import controleurs.DefaultController;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public interface Vue {
    int WIDTH = 600;
    int HEIGHT = 450;

    Scene getScene();
    DefaultController getControleur(); //TODO: interface ici
}
