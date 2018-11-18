package vues;

import jeu.Jeu;
import vues.boutons.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class VuePlateau extends JPanel implements Vue, ObserverBouton {

    private Fenetre fenetre;
    private Jeu jeu;
    private JLabel carte1, carte2, resultat, score;
    private Bouton suivant, menu;

    public VuePlateau(Fenetre fenetre, Jeu jeu) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.fenetre = fenetre;
        this.jeu = jeu;

        carte1   = new JLabel("");
        carte2   = new JLabel("");
        resultat = new JLabel("");
        score    = new JLabel("");
        refreshLabels();

        add(carte1);
        add(carte2);
        add(resultat);
        add(score);

        suivant = new BoutonSuivant();
        suivant.addObserver(this);
        add(suivant);

        menu = new BoutonMenu();
        menu.addObserver(this);
        add(menu);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.clearRect(0,0, getWidth(), getHeight());
    }

    @Override
    public void miseAJour() {
        jeu.demarrer();
        refreshLabels();

        /*
        createBufferStrategy(2);
        setIgnoreRepaint(true);

        BufferStrategy bs = getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        render(g);
        g.dispose();
        bs.show();
        */
    }

    private void tourSuivant() {
        try {
            jeu.tourSuivant();
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        refreshLabels();
    }

    private void refreshLabels() {
        resultat.setText("" + jeu.resultat());
        carte1.setText(jeu.carte(1).toString());
        carte2.setText(jeu.carte(2).toString());
        score.setText("Score : " + jeu.score());
    }

    @Override
    public void update(ObservableBouton ob, Object o) {
        if(ob instanceof BoutonSuivant)
            tourSuivant();
        else if(ob instanceof BoutonMenu)
            fenetre.chargerVue(fenetre.menu);
    }
}
