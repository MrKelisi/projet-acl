package vues;

import javax.swing.*;
import java.awt.*;

public class VueMenu extends JPanel implements Vue {
    private Fenetre fenetre;
    private JButton jouer, highscores, quitter;

    public VueMenu(Fenetre fenetre) {
        this.fenetre = fenetre;

        jouer = new JButton("Jouer");
        jouer.addActionListener(event -> {
            fenetre.chargerVue(fenetre.plateau);
        });
        add(jouer);

        highscores = new JButton("Meilleurs scores");
        highscores.addActionListener(event -> {
            fenetre.chargerVue(fenetre.highscores);
        });
        add(highscores);

        quitter = new JButton("Quitter");
        quitter.addActionListener(event -> {
            System.exit(0);
        });
        add(quitter);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.clearRect(0,0, getWidth(), getHeight());
    }

    @Override
    public void miseAJour() {}
}
