package vues;

import highscores.Score;
import jeu.Jeu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VueHighscores extends JPanel implements Vue {

    private Jeu jeu;
    private DefaultTableModel model;

    public VueHighscores(Fenetre fenetre, Jeu jeu) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.jeu = jeu;


        this.model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Nom");
        model.addColumn("Score");
        model.addColumn("Date");
        add(new JScrollPane(new JTable(model)));


        JButton menu = new JButton("Menu principal");
        menu.addActionListener(event -> {
            fenetre.chargerVue(fenetre.menu);
        });
        add(menu);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.clearRect(0,0, getWidth(), getHeight());
    }

    @Override
    public void miseAJour() {

        model.setRowCount(0);

        for(Score sc : jeu.tableau()) {
            model.addRow(new Object[]{ sc.getNom(), sc.getScore(), sc.getFormattedDate() });
        }

    }
}
