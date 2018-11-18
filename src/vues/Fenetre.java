package vues;

import java.awt.*;

import jeu.Jeu;
import vues.boutons.*;
import vues.outils.*;

public class Fenetre extends Frame {

    private Jeu jeu;

    protected Vue current, menu, plateau, highscores;

    public Fenetre(String titre, Jeu jeu) {
        super(titre);

        this.jeu = jeu;
        Outils.placer(this, 0.1,0.1,0.8,0.8);
        new EcouteurTerminaison(this);

        menu = new VueMenu(this);
        plateau = new VuePlateau(this, jeu);
        highscores = new VueHighscores(this, jeu);

        chargerVue(menu);
    }

    public void chargerVue(Vue vue) {
        removeAll();
        current = vue;
        add((Component) current);
        current.miseAJour();
        validate();
        repaint();
    }

    public void afficher() {
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }

}
