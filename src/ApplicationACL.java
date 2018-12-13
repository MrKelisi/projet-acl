import controleurs.ControleurJeu;
import controleurs.ControleurMenu;
import controleurs.ControleurTableau;
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

        ControleurMenu    controleurMenu    = new ControleurMenu(fenetre);
        ControleurJeu     controleurJeu     = new ControleurJeu(fenetre);
        ControleurTableau controleurTableau = new ControleurTableau(fenetre);

        fenetre.addVue("menu",    controleurMenu.getVue());
        fenetre.addVue("jeu",     controleurJeu.getVue());
        fenetre.addVue("tableau", controleurTableau.getVue());

        fenetre.setVue("menu");

        primaryStage.setTitle("Projet ACL");
        primaryStage.show();
    }

}
