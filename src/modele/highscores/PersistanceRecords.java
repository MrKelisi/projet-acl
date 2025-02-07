package modele.highscores;

import modele.Joueur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersistanceRecords {

    private static final String HIGHSCORES_FILE = "files/highscores.txt";
    private static final String PATTERN    = "^(.+)\t(-?[0-9]+)\t([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})$";

    /**
     * Lis une ligne du fichier et l'ajoute au tableau des records
     * @param ligne Ligne du fichier
     * @return Record lu à partir du fichier
     * @throws ParseException
     * @see TableauRecords
     */
    private static Record lire(String ligne)
            throws ParseException {

        final Pattern pattern = Pattern.compile(PATTERN);
        final Matcher matcher = pattern.matcher(ligne);
        matcher.find();

        return new Record(
                new Joueur(matcher.group(1)),
                Integer.valueOf(matcher.group(2)),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(matcher.group(3))
        );
    }

    /**
     * Charge un tableau des records à partir d'un fichier
     * @return Une ArrayList contenant les records du fichier
     */
    public static ArrayList<Record> charger() {

        ArrayList<Record> records = new ArrayList<>();

        try {
            File file = new File(HIGHSCORES_FILE);
            if(!file.exists()) {
                try {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    return records;
                }
            }
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                try {
                    records.add(lire(sc.nextLine()));
                } catch (Exception e) {
                    System.err.println("Erreur de lecture de la ligne");
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.err.println("Fichier des records introuvable");
            e.printStackTrace();
        }

        return records;
    }

    /**
     * Sauvegarde le tableau des records dans un fichier
     * @param tableauRecords Tableau des records
     * @see TableauRecords
     */
    public static void sauvegarder(TableauRecords tableauRecords) {
        File file = new File(HIGHSCORES_FILE);
        PrintWriter writer;

        try {
            if(!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            writer = new PrintWriter(file);
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(Record record : tableauRecords) {
            writer.print(record.getNom() + "\t" + record.getScore() + "\t" + sdf.format(record.getDate()) + "\n");
        }

        writer.close();
    }

}
