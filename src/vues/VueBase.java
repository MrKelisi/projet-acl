package vues;

import controleurs.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import modele.belote.JeuBelote;

public class VueBase implements Vue {

    private FXMLLoader loader;
    private Parent root;
    private Scene scene;

    protected BaseController controller;

    /**
     * Crée une vue à partir d'un fichier fxml
     * @param chemin Chemin du fichier fxml
     * @param fenetre Fenêtre associée à cette vue
     */
    public VueBase(String chemin, Fenetre fenetre) {
        try {
            loader = new FXMLLoader(getClass().getResource(chemin));
            root   = loader.load();
            scene  = new Scene(root, WIDTH, HEIGHT);

            controller = loader.getController();
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
    public BaseController getControleur() {
        return controller;
    }
}
