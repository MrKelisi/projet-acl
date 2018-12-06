package jfx.controllers;

import cartes.Carte;
import files.ResourcesLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import jeu.Jeu;
import jfx.VueMenu;
import javafx.scene.image.ImageView;

public class PlateauController extends DefaultController {

    private VueMenu menu;
    private Jeu jeu;
    private String pseudonyme = "Joueur";
    private ResourcesLoader resourcesLoader;

    @FXML
    private Text resultat;
    @FXML
    private Text score;
    @FXML
    private Button toursuivant;
    @FXML
    private Button abandonner;
    @FXML
    private ImageView c1;
    @FXML
    private ImageView c2;

    public PlateauController() {
        resourcesLoader = ResourcesLoader.getInstance();
    }

    public void setMenu(VueMenu menu) {
        this.menu = menu;
        this.jeu = menu.getJeu();
    }

    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    @FXML
    protected void menu(ActionEvent event) {
        if(jeu.estTermine()) {
            jeu.tableau().ajouter(pseudonyme, jeu.score());
        }
        primaryStage.setScene(menu.getScene());
    }

    @FXML
    protected void prochainTour(ActionEvent event) {
        jeu.tourSuivant();
        refreshScene();
    }

    private void refreshScene() {
        Carte ca1 = jeu.carte(1);
        Carte ca2 = jeu.carte(2);

        c1.setViewport(resourcesLoader.getCarte(ca1));
        c2.setViewport(resourcesLoader.getCarte(ca2));

        resultat.setText((jeu.resultat() > 0 ? "+" : "") + jeu.resultat());
        score.setText("Votre score : " + jeu.score());

        toursuivant.setText("Tour suivant (" + jeu.tour() + ")");


        if(jeu.estTermine()) {
            toursuivant.setDisable(true);
            abandonner.setText("Menu principal");
        }
    }

    public void init() {
        jeu.demarrer();
        c1.setImage(resourcesLoader.getPaquet());
        c2.setImage(resourcesLoader.getPaquet());
        refreshScene();

        toursuivant.setDisable(false);
        toursuivant.setText("Tour suivant (1)");
        abandonner.setText("Abandonner");
    }

}
