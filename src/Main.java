import javafx.application.Application;
import javafx.stage.Stage;
import modele.jeu.JeuBelote;
import vues.*;

import java.util.HashMap;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Fenetre fenetre = new Fenetre(primaryStage);
        JeuBelote jeu     = new JeuBelote();

        fenetre.addVue("menu",       new VueMenu(jeu, fenetre));
        fenetre.addVue("highscores", new VueHighscores(jeu, fenetre));
        fenetre.addVue("pseudo",     new VuePseudo(jeu, fenetre));
        fenetre.addVue("plateau",    new VuePlateau(jeu, fenetre));

        primaryStage.setTitle("Projet ACL");
        fenetre.setVue("menu");
        primaryStage.show();
    }

}
