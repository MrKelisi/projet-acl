package vues;

import javafx.stage.Stage;

import java.util.HashMap;

public class Fenetre {

    private Stage primaryStage;
    private HashMap<String, Vue> vues;

    /**
     * Crée une nouvelle fenêtre
     * @param stage Stage de la fenêtre
     */
    public Fenetre(Stage stage) {
        primaryStage = stage;
        vues = new HashMap<>();
    }

    /**
     * Ajoute une vue à la fenêtre et l'associe à un getNom
     * @param nom Nom usuelle de la vue
     * @param vue Une vue de la fenêtre
     */
    public void addVue(String nom, Vue vue) {
        if(vue == null) {
            throw new NullPointerException("Vue null");
        }

        vues.put(nom, vue);
    }

    /**
     * Définie la vue à afficher dans la fenêtre
     * @param nom Nom usuelle de la vue à afficher
     */
    public void setVue(String nom) {
        try {
            Vue vue = vues.get(nom);
            //vue.init();
            primaryStage.setScene(vue.getScene());
        } catch (Exception e) {
            e.printStackTrace();
            primaryStage.close();
        }
    }

    /**
     * Ferme la fenêtre
     */
    public void fermer() {
        primaryStage.close();
    }
}
