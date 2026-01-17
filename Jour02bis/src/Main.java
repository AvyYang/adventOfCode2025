import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// C'est long et moche, mais ça marche ^^'
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
                // Déterminer les ids invalides (Plusieurs fois la même combinaison de chiffre)
                int idSize = String.valueOf(i).length();

                // Séparation des id
                if (idSize % 10 == 0) {
                    String idDebut = String.valueOf(i).substring(0, (idSize / 10));
                    String idMiddle1 = String.valueOf(i).substring(idSize / 10, (idSize / 10) * 2);
                    String idMiddle2 = String.valueOf(i).substring((idSize / 10 * 2), (idSize / 10) * 3);
                    String idMiddle3 = String.valueOf(i).substring((idSize / 10) * 3, (idSize / 10) * 4);
                    String idMiddle4 = String.valueOf(i).substring((idSize / 10) * 4, (idSize / 10) * 5);
                    String idMiddle5 = String.valueOf(i).substring((idSize / 10) * 5, (idSize / 10) * 6);
                    String idMiddle6 = String.valueOf(i).substring((idSize / 10) * 6, (idSize / 10) * 7);
                    String idMiddle7 = String.valueOf(i).substring((idSize / 10) * 7, (idSize / 10) * 8);
                    String idMiddle8 = String.valueOf(i).substring((idSize / 10) * 8, (idSize / 10) * 9);
                    String idEnd = String.valueOf(i).substring((idSize / 10) * 9, idSize);

                    // Si toutes les parties sont les mêmes, on concat pour former l'id invalide
                    if ((idDebut.equals(idMiddle1)) && (idDebut.equals(idMiddle2) && (idDebut.equals(idMiddle3))
                            && (idDebut.equals(idMiddle4)) && (idDebut.equals(idMiddle5)) && (idDebut.equals(idMiddle6))
                            && (idDebut.equals(idMiddle7)) && (idDebut.equals(idMiddle8)) && (idDebut.equals(idEnd)))) {
                        String id = idDebut.concat(idMiddle1).concat(idMiddle2).concat(idMiddle3).concat(idMiddle4)
                                .concat(idMiddle5).concat(idMiddle6).concat(idMiddle7).concat(idMiddle8).concat(idEnd);
                        sommeInvalidIds += Long.parseLong(id);
                        continue;
                    }
                }

                if (idSize % 9 == 0) {
                    String idDebut = String.valueOf(i).substring(0, (idSize / 9));
                    String idMiddle1 = String.valueOf(i).substring(idSize / 9, (idSize / 9) * 2);
                    String idMiddle2 = String.valueOf(i).substring((idSize / 9 * 2), (idSize / 9) * 3);
                    String idMiddle3 = String.valueOf(i).substring((idSize / 9) * 3, (idSize / 9) * 4);
                    String idMiddle4 = String.valueOf(i).substring((idSize / 9) * 4, (idSize / 9) * 5);
                    String idMiddle5 = String.valueOf(i).substring((idSize / 9) * 5, (idSize / 9) * 6);
                    String idMiddle6 = String.valueOf(i).substring((idSize / 9) * 6, (idSize / 9) * 7);
                    String idMiddle7 = String.valueOf(i).substring((idSize / 9) * 7, (idSize / 9) * 8);
                    String idEnd = String.valueOf(i).substring((idSize / 9) * 8, idSize);

                    // Si toutes les parties sont les mêmes, on concat pour former l'id invalide
                    if ((idDebut.equals(idMiddle1)) && (idDebut.equals(idMiddle2) && (idDebut.equals(idMiddle3))
                            && (idDebut.equals(idMiddle4)) && (idDebut.equals(idMiddle5)) && (idDebut.equals(idMiddle6))
                            && (idDebut.equals(idMiddle7)) && (idDebut.equals(idEnd)))) {
                        String id = idDebut.concat(idMiddle1).concat(idMiddle2).concat(idMiddle3).concat(idMiddle4)
                                .concat(idMiddle5).concat(idMiddle6).concat(idMiddle7).concat(idEnd);
                        sommeInvalidIds += Long.parseLong(id);
                        continue;
                    }

                }

                if (idSize % 8 == 0) {
                    String idDebut = String.valueOf(i).substring(0, (idSize / 8));
                    String idMiddle1 = String.valueOf(i).substring(idSize / 8, (idSize / 8) * 2);
                    String idMiddle2 = String.valueOf(i).substring((idSize / 8 * 2), (idSize / 8) * 3);
                    String idMiddle3 = String.valueOf(i).substring((idSize / 8) * 3, (idSize / 8) * 4);
                    String idMiddle4 = String.valueOf(i).substring((idSize / 8) * 4, (idSize / 8) * 5);
                    String idMiddle5 = String.valueOf(i).substring((idSize / 8) * 5, (idSize / 8) * 6);
                    String idMiddle6 = String.valueOf(i).substring((idSize / 8) * 6, (idSize / 8) * 7);
                    String idEnd = String.valueOf(i).substring((idSize / 8) * 7, idSize);

                    // Si toutes les parties sont les mêmes, on concat pour former l'id invalide
                    if ((idDebut.equals(idMiddle1)) && (idDebut.equals(idMiddle2) && (idDebut.equals(idMiddle3))
                            && (idDebut.equals(idMiddle4)) && (idDebut.equals(idMiddle5)) && (idDebut.equals(idMiddle6))
                            && (idDebut.equals(idEnd)))) {
                        String id = idDebut.concat(idMiddle1).concat(idMiddle2).concat(idMiddle3).concat(idMiddle4)
                                .concat(idMiddle5).concat(idMiddle6).concat(idEnd);
                        sommeInvalidIds += Long.parseLong(id);
                        continue;
                    }
                }

                if (idSize % 7 == 0) {
                    String idDebut = String.valueOf(i).substring(0, (idSize / 7));
                    String idMiddle1 = String.valueOf(i).substring(idSize / 7, (idSize / 7) * 2);
                    String idMiddle2 = String.valueOf(i).substring((idSize / 7 * 2), (idSize / 7) * 3);
                    String idMiddle3 = String.valueOf(i).substring((idSize / 7) * 3, (idSize / 7) * 4);
                    String idMiddle4 = String.valueOf(i).substring((idSize / 7) * 4, (idSize / 7) * 5);
                    String idMiddle5 = String.valueOf(i).substring((idSize / 7) * 5, (idSize / 7) * 6);
                    String idEnd = String.valueOf(i).substring((idSize / 7) * 6, idSize);

                    // Si toutes les parties sont les mêmes, on concat pour former l'id invalide
                    if ((idDebut.equals(idMiddle1)) && (idDebut.equals(idMiddle2) && (idDebut.equals(idMiddle3))
                            && (idDebut.equals(idMiddle4)) && (idDebut.equals(idMiddle5)) && (idDebut.equals(idEnd)))) {
                        String id = idDebut.concat(idMiddle1).concat(idMiddle2).concat(idMiddle3).concat(idMiddle4)
                                .concat(idMiddle5).concat(idEnd);
                        sommeInvalidIds += Long.parseLong(id);
                        continue;
                    }
                }

                if (idSize % 6 == 0) {
                    String idDebut = String.valueOf(i).substring(0, (idSize / 6));
                    String idMiddle1 = String.valueOf(i).substring(idSize / 6, (idSize / 6) * 2);
                    String idMiddle2 = String.valueOf(i).substring((idSize / 6 * 2), (idSize / 6) * 3);
                    String idMiddle3 = String.valueOf(i).substring((idSize / 6) * 3, (idSize / 6) * 4);
                    String idMiddle4 = String.valueOf(i).substring((idSize / 6) * 4, (idSize / 6) * 5);
                    String idEnd = String.valueOf(i).substring((idSize / 6) * 5, idSize);

                    // Si toutes les parties sont les mêmes, on concat pour former l'id invalide
                    if ((idDebut.equals(idMiddle1)) && (idDebut.equals(idMiddle2) && (idDebut.equals(idMiddle3))
                            && (idDebut.equals(idMiddle4)) && (idDebut.equals(idEnd)))) {
                        String id = idDebut.concat(idMiddle1).concat(idMiddle2).concat(idMiddle3).concat(idMiddle4).concat(idEnd);
                        sommeInvalidIds += Long.parseLong(id);
                        continue;
                    }
                }

                if (idSize % 5 == 0) {
                    String idDebut = String.valueOf(i).substring(0, (idSize / 5));
                    String idMiddle1 = String.valueOf(i).substring(idSize / 5, (idSize / 5) * 2);
                    String idMiddle2 = String.valueOf(i).substring((idSize / 5 * 2), (idSize / 5) * 3);
                    String idMiddle3 = String.valueOf(i).substring((idSize / 5) * 3, (idSize / 5) * 4);
                    String idEnd = String.valueOf(i).substring((idSize / 5) * 4, idSize);

                    // Si toutes les parties sont les mêmes, on concat pour former l'id invalide
                    if ((idDebut.equals(idMiddle1)) && (idDebut.equals(idMiddle2) && (idDebut.equals(idMiddle3))
                            && (idDebut.equals(idEnd)))) {
                        String id = idDebut.concat(idMiddle1).concat(idMiddle2).concat(idMiddle3).concat(idEnd);
                        sommeInvalidIds += Long.parseLong(id);
                        continue;
                    }
                }

                if (idSize % 4 == 0) {
                    String idDebut = String.valueOf(i).substring(0, (idSize/4));
                    String idMiddle1 = String.valueOf(i).substring(idSize/4, (idSize/4)*2);
                    String idMiddle2 = String.valueOf(i).substring((idSize/4)*2, (idSize/4)*3);
                    String idEnd = String.valueOf(i).substring((idSize/4)*3, idSize);

                     // Si toutes les parties sont les mêmes, on concat pour former l'id invalide
                     if ((idDebut.equals(idMiddle1)) && (idDebut.equals(idMiddle2)) && (idDebut.equals(idEnd))) {
                         String id = idDebut.concat(idMiddle1).concat(idMiddle2).concat(idEnd);
                         sommeInvalidIds += Long.parseLong(id);
                         continue;
                     }
                }

                if (idSize % 3 == 0) {
                    String idDebut = String.valueOf(i).substring(0, (idSize/3));
                    String idMiddle = String.valueOf(i).substring((idSize/3), ((idSize/3)*2));
                    String idEnd = String.valueOf(i).substring(((idSize/3)*2), idSize);

                     // Si toutes les parties sont les mêmes, on concat pour former l'id invalide
                     if ((idDebut.equals(idMiddle)) && (idDebut.equals(idEnd))) {
                         String id = idDebut.concat(idMiddle).concat(idEnd);
                         sommeInvalidIds += Long.parseLong(id);
                         continue;
                     }
                }

                if (idSize % 2 == 0) {
                    String idStart = String.valueOf(i).substring(0, (idSize/2));
                    String idEnd = String.valueOf(i).substring((idSize/2), idSize);
                    sommeInvalidIds = comparerID(idStart, idEnd, sommeInvalidIds);
                }
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