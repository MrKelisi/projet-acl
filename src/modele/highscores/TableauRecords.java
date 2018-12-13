package modele.highscores;

import modele.Joueur;
import modele.belote.JoueurActif;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Observable;

public class TableauRecords extends Observable implements Iterable<Record> {
    private static final int MAX_SCORES = 10;
    private static TableauRecords instance;

    private ArrayList<Record> records;

    /**
     * Tableau des records, chargé à partir d'un fichier
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

    public Record findRecordOf(Joueur joueur) {
        for(Record record : records) {
            if(record.getJoueur().equals(joueur)) {
                return record;
            }
        }

        throw new NoSuchElementException("Le joueur n'a pas été trouvé");
    }

    /**
     * Retourne l'indice auquel devra être placé le record
     * @param score Score du joueur
     * @return Indice
     */
    private int getIndex(int score) {
        int index = 0;

        for(Record record : records) {
            if(record.getScore() <= score) {
                index++;
            }
        }

        return index;
    }

    /**
     * Ajoute un nouveau record au tableau des records à la date d'exécution
     * @param joueurActif JoueurActif
     */
    public void ajouter(JoueurActif joueurActif) {
        try {
            Record recherche = findRecordOf(joueurActif);
            if(recherche.getScore() <= joueurActif.score()) {
                return;
            }
            records.remove(recherche);
        }
        catch (NoSuchElementException e) {

        }

        records.add(getIndex(joueurActif.score()), new Record(joueurActif, joueurActif.score()));
        setChanged();
        notifyObservers();

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
