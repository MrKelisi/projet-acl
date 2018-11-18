package vues;

import jeu.Jeu;
import vues.boutons.Bouton;
import vues.boutons.BoutonMenu;
import vues.boutons.ObservableBouton;
import vues.boutons.ObserverBouton;

import javax.swing.*;
import java.awt.*;

public class VueHighscores extends JPanel implements Vue, ObserverBouton {

    private Fenetre fenetre;
    private Jeu jeu;
    private Bouton menu;

    public VueHighscores(Fenetre fenetre, Jeu jeu) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.fenetre = fenetre;
        this.jeu = jeu;

        miseAJour();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.clearRect(0,0, getWidth(), getHeight());
    }

    @Override
    public void miseAJour() {
        removeAll();

        for(int i = 0; i < jeu.tableau().getSize(); i++) {
            JLabel label = new JLabel(jeu.tableau().getLigne(i));
            add(label);
        }

        menu = new BoutonMenu();
        menu.addObserver(this);
        add(menu);
    }

    @Override
    public void update(ObservableBouton ob, Object o) {
        if(ob instanceof BoutonMenu)
            fenetre.chargerVue(fenetre.menu);
    }
}
