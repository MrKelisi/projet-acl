package vues;

import cartes.Carte;
import jeu.Jeu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VuePlateau extends JPanel implements Vue {

    private Fenetre fenetre;
    private Jeu jeu;
    private JLabel carte1, carte2, resultat, score;
    private JButton suivant, menu;

    public VuePlateau(Fenetre fenetre, Jeu jeu) {
        setBorder(new EmptyBorder(30,50,30,50));

        GridLayout gl = new GridLayout(0,3);
        gl.setHgap(50);
        gl.setVgap(80);
        setLayout(gl);

        this.fenetre = fenetre;
        this.jeu = jeu;
        JPanel tempPanel;

        carte1 = new JLabel("", SwingConstants.CENTER);
        carte1.setFont(new Font("sans-serif", Font.PLAIN, 56));

        carte2 = new JLabel("", SwingConstants.CENTER);
        carte2.setFont(new Font("sans-serif", Font.PLAIN, 56));

        resultat = new JLabel("", SwingConstants.CENTER);
        resultat.setFont(new Font("sans-serif", Font.PLAIN, 36));
        resultat.setForeground(Color.BLUE);

        score = new JLabel("", SwingConstants.CENTER);
        score.setFont(new Font("sans-serif", Font.PLAIN, 24));
        score.setForeground(Color.BLUE);

        tempPanel = new JPanel();
        tempPanel.setBackground(Color.WHITE);
        tempPanel.add(carte1);
        add(tempPanel);

        add(resultat);

        tempPanel = new JPanel();
        tempPanel.setBackground(Color.WHITE);
        tempPanel.add(carte2);
        add(tempPanel);

        add(score);

        suivant = new JButton("Tour suivant");
        suivant.addActionListener(event -> {
            tourSuivant();
        });
        add(suivant);

        menu = new JButton("Abandonner");
        menu.addActionListener(event -> {
            saveScoreAndLeave();
        });
        add(menu);

        refreshScene();
    }

    @Override
    public void miseAJour() {
        jeu.demarrer();
        refreshScene();
    }

    private void tourSuivant() {
        try {
            jeu.tourSuivant();
            refreshScene();
        }
        catch (IndexOutOfBoundsException e) {}
    }

    private String getSymbol(String categorie) {
        switch(categorie) {
            case "pique":   return "♠";
            case "trèfle":  return "♣";
            case "carreau": return "♦";
            case "coeur":   return "♥";
            default:        return "?";
        }
    }

    private void refreshScene() {

        Carte c1 = jeu.carte(1);
        carte1.setText(c1.getFigure().getNom() + getSymbol(c1.getCategorie().getNom()));
        carte1.setForeground(c1.getCategorie().getCouleur().equals("rouge") ? Color.RED : Color.BLACK);

        Carte c2 = jeu.carte(2);
        carte2.setText(c2.getFigure().getNom() + getSymbol(c2.getCategorie().getNom()));
        carte2.setForeground(c2.getCategorie().getCouleur().equals("rouge") ? Color.RED : Color.BLACK);

        resultat.setText((jeu.resultat() > 0 ? "+" : "") + jeu.resultat());

        score.setText("Votre score : " + jeu.score());

        if(jeu.estTermine()) {
            suivant.setEnabled(false);
            menu.setText("Menu principal");
        }

        repaint();
    }

    private void saveScoreAndLeave() {
        if(jeu.estTermine()) {
            jeu.tableau().ajouter(jeu.getPseudonyme(), jeu.score());
            suivant.setEnabled(true);
            menu.setText("Abandonner");
        }
        fenetre.chargerVue(fenetre.menu);
    }
}
