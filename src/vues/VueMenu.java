package vues;

import javax.swing.*;

public class VueMenu extends JPanel implements Vue {

    public VueMenu(Fenetre fenetre) {
        JButton jouer = new JButton("Jouer");
        jouer.addActionListener(event -> {
            fenetre.chargerVue(fenetre.pseudonyme);
        });
        add(jouer);

        JButton highscores = new JButton("Meilleurs scores");
        highscores.addActionListener(event -> {
            fenetre.chargerVue(fenetre.highscores);
        });
        add(highscores);

        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(event -> {
            System.exit(0);
        });
        add(quitter);
    }

    @Override
    public void miseAJour() {}
}
