import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Variable qui va contenir le nombre d'id invalides
        Long sommeInvalidIds = 0L;

        // Scanner pour entrer les valeurs
        Scanner sc = new Scanner(new File("F:/Documents/10 - Advent of code/AdventOfCode2025/Jour02/src/resources/AdventOfCode2025J02.txt"));
        sc.useDelimiter(",");

        while (sc.hasNext()) {
            String entree = sc.next();

            // Séparation de "firstID" et "lastID"
            String[] tabID = entree.split("-");
            long firstID = Long.parseLong(tabID[0]);
            long lastID = Long.parseLong(tabID[1]);

            // Déroule les nombres dans le range de firstId -> lastID
            for (long i = firstID; i <= lastID; i++) {
                // Déterminer les ids invalides (2 fois la même combinaison de chiffre)
                // Séparation en 2 etc.
                int idSize = String.valueOf(i).length();
                String idDebut = String.valueOf(i).substring(0, (idSize/2));
                String idFin = String.valueOf(i).substring((idSize/2), idSize);

                // Comparer les id séparés en 2
                sommeInvalidIds = comparerID(idDebut, idFin, sommeInvalidIds);

            }
        }

        System.out.println(sommeInvalidIds);
    }

    // Comparateur d'id
    public static Long comparerID(String idDebut, String idFin, Long sommeInvalidIds) {
        if (idDebut.equals(idFin)) {
            String id = idDebut.concat(idFin);
            sommeInvalidIds += Long.parseLong(id);
        }
        return sommeInvalidIds;
    }
}