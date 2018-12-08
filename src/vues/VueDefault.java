package vues;

import controleurs.DefaultController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import modele.jeu.JeuBelote;

public class VueDefault implements Vue {

    private FXMLLoader loader;
    private Parent root;
    private Scene scene;

    protected DefaultController controller;

    /**
     * Crée une vue à partir d'un fichier fxml
     * @param chemin Chemin du fichier fxml
     * @param jeu Jeu à passer au controleur
     * @param fenetre Fenêtre associée à cette vue
     */
    public VueDefault(String chemin, JeuBelote jeu, Fenetre fenetre) {
        try {
            loader = new FXMLLoader(getClass().getResource(chemin));
            root   = loader.load();
            scene  = new Scene(root, WIDTH, HEIGHT);

            controller = loader.getController();
            controller.setJeu(jeu);
            controller.setFenetre(fenetre);
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
    public DefaultController getControleur() {
        return controller;
    }
}
