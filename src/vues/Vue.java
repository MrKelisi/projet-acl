package vues;

import javafx.scene.Scene;
import jeu.Jeu;

public interface Vue {
    int WIDTH = 800;
    int HEIGHT = 600;

    public Scene getScene();
    public Jeu getJeu();
}
