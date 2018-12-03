package vues;

import jeu.Jeu;

import javax.swing.*;
import java.awt.*;

public class VuePseudonyme extends JPanel implements Vue {
    private JTextField pseudonyme;
    private JButton valider;
    private JButton abandonner;

    public VuePseudonyme(Fenetre fenetre, Jeu jeu) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Pseudonyme:"));

        pseudonyme = new JTextField(jeu.getPseudonyme());
        add(pseudonyme);

        valider = new JButton("Valider");
        valider.addActionListener(event -> {
            jeu.setPseudonyme(pseudonyme.getText());
            fenetre.chargerVue(fenetre.plateau);
        });
        add(valider);

        abandonner = new JButton("Abandonner");
        abandonner.addActionListener(event -> fenetre.chargerVue(fenetre.menu));
        add(abandonner);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.clearRect(0,0, getWidth(), getHeight());
    }

    @Override
    public void miseAJour() {
        repaint();
    }
}
