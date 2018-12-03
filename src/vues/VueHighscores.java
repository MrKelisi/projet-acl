package vues;

import jeu.Jeu;

import javax.swing.*;
import java.awt.*;

public class VueHighscores extends JPanel implements Vue {

    private Fenetre fenetre;
    private Jeu jeu;
    private JButton menu;

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

        menu = new JButton("Menu principal");
        menu.addActionListener(event -> {
            fenetre.chargerVue(fenetre.menu);
        });
        add(menu);
    }
}
