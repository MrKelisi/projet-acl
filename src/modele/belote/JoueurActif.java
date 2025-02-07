package modele.belote;

import modele.Joueur;
import modele.highscores.TableauRecords;

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
    public static void nouveau(String pseudonyme) {
        instance = new JoueurActif(pseudonyme);
    }

    /**
     * @return Joueur actif actuel
     */
    public static JoueurActif getInstance() {
        if(instance == null) {
            nouveau("Joueur");
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
    private void sauvegarder() {
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

        if(aTermine()) {
            sauvegarder();
        }

        setChanged();
        notifyObservers();

        return true;
    }

    /**
     * @return Jeu associé au joueur
     */
    public JeuBelote getJeu() {
        return jeu;
    }

}
