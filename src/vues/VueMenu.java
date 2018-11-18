package vues;

import vues.boutons.*;

import javax.swing.*;
import java.awt.*;

public class VueMenu extends JPanel implements Vue, ObserverBouton {

    private Fenetre fenetre;
    private Bouton jouer, highscores, quitter;

    public VueMenu(Fenetre fenetre) {
        this.fenetre = fenetre;

        jouer = new BoutonJouer();
        jouer.addObserver(this);
        add(jouer);

        highscores = new BoutonHighscores();
        highscores.addObserver(this);
        add(highscores);

        quitter = new BoutonQuitter();
        quitter.addObserver(this);
        add(quitter);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.clearRect(0,0, getWidth(), getHeight());
    }

    @Override
    public void miseAJour() {}

    @Override
    public void update(ObservableBouton ob, Object o) {
        if(ob instanceof BoutonJouer)
            fenetre.chargerVue(fenetre.plateau);
        else if(ob instanceof BoutonHighscores)
            fenetre.chargerVue(fenetre.highscores);
        else if(ob instanceof BoutonQuitter)
            System.exit(0);
    }
}
