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

        fenetre.addVue("menu",       new VueDefault("fxml/menu.fxml", jeu, fenetre));
        fenetre.addVue("highscores", new VueDefault("fxml/highscores.fxml", jeu, fenetre));
        fenetre.addVue("pseudo",     new VueDefault("fxml/pseudo.fxml", jeu, fenetre));
        fenetre.addVue("plateau",    new VueDefault("fxml/plateau.fxml", jeu, fenetre));

        primaryStage.setTitle("Projet ACL");
        fenetre.setVue("menu");
        primaryStage.show();
    }

}
