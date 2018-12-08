package vues;

import javafx.stage.Stage;

import java.util.HashMap;

public class Fenetre {
    private Stage stage;
    private HashMap<String, Vue> vues;

    public Fenetre(Stage stage) {
        this.stage = stage;
        vues = new HashMap<>();
    }

    public void addVue(String nom, Vue vue) {
        if(vue == null) {
            throw new NullPointerException("Vue null");
        }

        vues.put(nom, vue);
    }

    public void setVue(String nom) {
        try {
            Vue vue = vues.get(nom);
            vue.getControleur().init();
            stage.setScene(vue.getScene());
        } catch (Exception e) {
            e.printStackTrace();
            stage.close();
        }
    }

    public void fermer() {
        stage.close();
    }
}
