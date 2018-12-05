package jfx;

import javafx.application.Application;
import javafx.stage.Stage;
import jeu.Jeu;

public class Main extends Application {

    private Jeu jeu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        jeu = new Jeu();

        VueMenu       menu       = new VueMenu(primaryStage, jeu);
        VueHighscores highscores = new VueHighscores(primaryStage, jeu);
        VuePseudo     pseudo     = new VuePseudo(primaryStage, jeu);
        VuePlateau    plateau    = new VuePlateau(primaryStage, jeu);


        menu.setPseudo(pseudo);
        menu.setHighscores(highscores);

        highscores.setMenu(menu);

        pseudo.setPlateau(plateau);
        pseudo.setMenu(menu);

        plateau.setMenu(menu);


        primaryStage.setTitle("Projet ACL");
        primaryStage.setScene(menu.getScene());
        primaryStage.show();

    }
}
