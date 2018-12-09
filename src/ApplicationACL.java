import javafx.application.Application;
import javafx.stage.Stage;
import modele.jeu.JeuBelote;
import vues.*;

public class ApplicationACL extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Fenetre fenetre = new Fenetre(primaryStage);
        JeuBelote jeu     = new JeuBelote();

        fenetre.addVue("menu",       new VueBaseJeu("fxml/menu.fxml", jeu, fenetre));
        fenetre.addVue("highscores", new VueBaseJeu("fxml/highscores.fxml", jeu, fenetre));
        fenetre.addVue("pseudo",     new VueBaseJeu("fxml/pseudo.fxml", jeu, fenetre));
        fenetre.addVue("plateau",    new VueBaseJeu("fxml/plateau.fxml", jeu, fenetre));

        primaryStage.setTitle("Projet ACL");
        fenetre.setVue("menu");
        primaryStage.show();
    }

}
