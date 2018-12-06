import javafx.application.Application;
import javafx.stage.Stage;
import modele.jeu.JeuBelote;
import vues.*;

import java.util.HashMap;

public class Main extends Application {

    private JeuBelote jeu;
    private HashMap<String, Vue> vues;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        jeu     = new JeuBelote();
        vues    = new HashMap<>();

        vues.put("menu",       new VueMenu(jeu));
        vues.put("highscores", new VueHighscores(jeu));
        vues.put("pseudo",     new VuePseudo(jeu));
        vues.put("plateau",    new VuePlateau(jeu));

        for(Vue vue : vues.values()) {
            vue.setPrimaryStage(primaryStage);
            vue.setVues(vues);
        }

        primaryStage.setTitle("Projet ACL");
        primaryStage.setScene(vues.get("menu").getScene());
        primaryStage.show();
    }

}
