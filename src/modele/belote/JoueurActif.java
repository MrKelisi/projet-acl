package modele.belote;

import modele.Joueur;
import modele.highscores.TableauRecords;
import vues.Vue;

public class JoueurActif extends Joueur {
    private static JoueurActif instance;

    private JeuBelote jeu;
    private int tour;
    private int score;

    private JoueurActif(String nom) {
        super(nom);
        tour = 0;
        score = 0;
        jeu = new JeuBelote();
    }

    /**
     * Change le joueur actif
     * @param pseudonyme Nom du nouveau joueur
     */
    public static void nouveau(String pseudonyme, Vue vue) {
        instance = new JoueurActif(pseudonyme);
        instance.getJeu().addObserver(vue);
    }

    /**
     * @return Joueur actif actuel
     */
    public static JoueurActif getInstance() {
        if(instance == null) {
            nouveau("Joueur", null);
        }
        return instance;
    }

    /**
     * @return Tour du joueur
     */
    public int tour() {
        return tour;
    }

    /**
     * @return Score du joueur
     */
    public int score() {
        return score;
    }

    /**
     * @return Vrai si la partie est terminée (nombre de tours maximum atteint)
     */
    public boolean aTermine() {
        return tour >= JeuBelote.MAX_TOURS;
    }

    /**
     * Sauvegarde le record dans le tableau des records
     */
    public void sauvegarder() {
        TableauRecords.getInstance().ajouter(JoueurActif.getInstance());
    }

    /**
     * Joue un tour
     * @return Vrai si le tour s'est bien déroulé
     */
    public boolean tirer() {
        if(aTermine()) {
            return false;
        }

        jeu.tirer();

        score += jeu.getResultat();
        tour++;

        return true;
    }

    /**
     * @return Jeu associé au joueur
     */
    public JeuBelote getJeu() {
        return jeu;
    }

    /**
     * Supprime l'instance du joueur
     */
    public static void reset() {
        instance = null;
    }
}
