package vues;

import jeu.Jeu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VuePseudonyme extends JPanel implements Vue {

    public VuePseudonyme(Fenetre fenetre, Jeu jeu) {
        setBorder(new EmptyBorder(30,50,30,50));

        GridLayout gl = new GridLayout(0,1);
        gl.setHgap(50);
        gl.setVgap(80);
        setLayout(gl);

        add(new JLabel("Pseudonyme:", SwingConstants.CENTER));

        JTextField pseudonyme = new JTextField(jeu.getPseudonyme());
        add(pseudonyme);

        JButton valider = new JButton("Valider");
        valider.addActionListener(event -> {
            jeu.setPseudonyme(pseudonyme.getText());
            fenetre.chargerVue(fenetre.plateau);
        });
        add(valider);

        JButton abandonner = new JButton("Abandonner");
        abandonner.addActionListener(event -> fenetre.chargerVue(fenetre.menu));
        add(abandonner);
    }

    @Override
    public void miseAJour() {
        repaint();
    }
}
