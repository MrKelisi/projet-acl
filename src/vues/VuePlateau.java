package vues;

import jeu.Jeu;

import javax.swing.*;
import java.awt.*;

public class VuePlateau extends JPanel implements Vue {

    private Fenetre fenetre;
    private Jeu jeu;
    private JLabel carte1, carte2, resultat, score;
    private JButton suivant, menu;

    public VuePlateau(Fenetre fenetre, Jeu jeu) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.fenetre = fenetre;
        this.jeu = jeu;

        carte1   = new JLabel("");
        carte2   = new JLabel("");
        resultat = new JLabel("");
        score    = new JLabel("");

        add(carte1);
        add(carte2);
        add(resultat);
        add(score);

        suivant = new JButton("Tour suivant");
        suivant.addActionListener(event -> {
            tourSuivant();
        });

        menu = new JButton("Menu principal");
        menu.addActionListener(event -> {
            saveScoreAndLeave();
        });
        add(menu);

        refreshLabels();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.clearRect(0,0, getWidth(), getHeight());
    }

    @Override
    public void miseAJour() {
        add(suivant);

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
        }
        catch (IndexOutOfBoundsException e) {
            return;
        }
        refreshLabels();
        repaint();
    }

    private void refreshLabels() {
        resultat.setText("" + jeu.resultat());

        carte1.setText(jeu.carte(1).toString());
        //carte1.setForeground(jeu.carte(1).getCouleur()); TODO: convertir les chaînes en couleur

        carte2.setText(jeu.carte(2).toString());
        //carte2.setForeground(jeu.carte(2).getCouleur());

        score.setText("Score : " + jeu.score());



        if(jeu.estTermine()) {
            remove(suivant);
            menu.setText("Menu principal");
        }
        else {
            menu.setText("Abandonner");
        }
    }

    private void saveScoreAndLeave() {
        if(jeu.estTermine()) {
            jeu.tableau().ajouter("Inconnu", jeu.score());
        }
        fenetre.chargerVue(fenetre.menu);
    }
}
