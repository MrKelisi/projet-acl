import controleurs.ControleurJeu;
import controleurs.ControleurMenu;
import controleurs.ControleurPseudo;
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
        ControleurPseudo  controleurPseudo  = new ControleurPseudo(fenetre);
        ControleurJeu     controleurJeu     = new ControleurJeu(fenetre);
        ControleurTableau controleurTableau = new ControleurTableau(fenetre);

        fenetre.addVue("menu",    controleurMenu.getVue());
        fenetre.addVue("pseudo",  controleurPseudo.getVue());
        fenetre.addVue("jeu",     controleurJeu.getVue());
        fenetre.addVue("tableau", controleurTableau.getVue());

        fenetre.setVue("menu");

        primaryStage.setTitle("Projet ACL");
        primaryStage.show();
    }

}
