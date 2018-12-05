package jfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import jeu.Jeu;

public abstract class VueDefault implements Vue {

    protected FXMLLoader loader;
    protected Parent root;
    protected Scene scene;

    protected Jeu jeu;

    protected VueDefault(String chemin, Jeu jeu) {

        this.jeu = jeu;

        try {
            loader = new FXMLLoader(getClass().getResource(chemin));
            root   = loader.load();
            scene  = new Scene(root, WIDTH, HEIGHT);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public Jeu getJeu() {
        return jeu;
    }

}
