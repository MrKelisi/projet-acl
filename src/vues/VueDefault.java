package vues;

import controleurs.DefaultController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.jeu.JeuBelote;

import java.util.HashMap;

public abstract class VueDefault implements Vue {

    private FXMLLoader loader;
    private Parent root;
    private Scene scene;

    private Stage primaryStage;
    private HashMap<String, Vue> vues;
    protected DefaultController controller;

    protected VueDefault(String chemin, JeuBelote jeu) {

        try {
            loader = new FXMLLoader(getClass().getResource(chemin));
            root   = loader.load();
            scene  = new Scene(root, WIDTH, HEIGHT);

            controller = loader.getController();
            controller.setJeu(jeu);
            controller.setVue(this);
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
    public void changerVue(String nom) {
        try {
            Vue vue = vues.get(nom);
            vue.init();
            primaryStage.setScene(vue.getScene());
        } catch (Exception e) {
            primaryStage.close();
        }
    }

    @Override
    public void init() {}



    @Override
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @Override
    public void setVues(HashMap<String, Vue> vues) {
        this.vues = vues;
    }

}
