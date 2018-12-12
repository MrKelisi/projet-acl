import controleurs.Plateau2Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import vues.*;

public class ApplicationACL extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Fenetre fenetre = new Fenetre(primaryStage);

        fenetre.addVue("menu",       new VueBase("fxml/menu.fxml", fenetre));
        fenetre.addVue("highscores", new VueBase("fxml/highscores.fxml", fenetre));
        fenetre.addVue("pseudo",     new VueBase("fxml/pseudo.fxml", fenetre));
        fenetre.addVue("plateau",    new VueBase("fxml/plateau.fxml", fenetre));

        Plateau2Controller p2contr = new Plateau2Controller(primaryStage);
        p2contr.show();

        primaryStage.setTitle("Projet ACL");
        //fenetre.setVue("menu");
        primaryStage.show();
    }

}
