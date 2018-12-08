package vues;

import controleurs.DefaultController;
import javafx.scene.Scene;

public interface Vue {
    int WIDTH = 600;
    int HEIGHT = 450;

    /**
     * Retoune la scène de la vue
     * @return scene
     */
    Scene getScene();

    /**
     * Retourne le controleur associé à la vue
     * @return controller
     */
    DefaultController getControleur(); //TODO: interface ici
}
