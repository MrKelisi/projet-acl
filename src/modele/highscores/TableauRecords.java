package modele.highscores;

import modele.joueurs.JoueurActif;

import java.util.ArrayList;
import java.util.Iterator;

public class TableauRecords implements Iterable<Record> {
    private static final int MAX_SCORES = 10;
    private static TableauRecords instance;

    private ArrayList<Record> records;

    /**
     * TableauRecords des scores, chargé à partir d'un fichier
     * @see PersistanceRecords
     */
    private TableauRecords() {
        records = PersistanceRecords.charger();
    }

    /**
     * Retourne l'instance du singleton TableauRecords et, si elle n'existe pas, la crée
     * @return instance
     */
    public static TableauRecords getInstance() {
        if (instance == null) {
            instance = new TableauRecords();
        }
        return instance;
    }

    /**
     * Ajoute un nouveau record au tableau des records à la date d'exécution
     * @param joueurActif JoueurActif
     */
    public void ajouter(JoueurActif joueurActif) {

        int index = 0;

        for(Record record : records) {
            if(record.getJoueur().equals(joueurActif)) {
                if(joueurActif.score() >= record.getScore()) {
                    return;
                }
                records.remove(record);
                break;
            }
            if(record.getScore() <= joueurActif.score()) {
                index++;
            }
        }

        records.add(index, new Record(joueurActif, joueurActif.score()));

        if(records.size() > MAX_SCORES) {
            records.remove(records.size() - 1);
        }

        PersistanceRecords.sauvegarder(this);
    }

    @Override
    public Iterator<Record> iterator() {
        return records.iterator();
    }
}
