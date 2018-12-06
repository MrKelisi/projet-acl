package vues;

import javafx.scene.Scene;
import jeu.Jeu;

public interface Vue {
    int WIDTH = 600;
    int HEIGHT = 450;

    public Scene getScene();
    public Jeu getJeu();
}
