import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Création du "verrou" avec les valeurs de 0 à 99
        List<Integer> verrou = new ArrayList<>();
        for (int i=0; i<100; i++) {
            verrou.add(i);
        }

        // Le "code" du verrou commence à 50
        int code = 50;

        // Création de l'Arraylist qui stockera les valeurs de "code" obtenues à chaque itération
        List<Integer> stockCode = new ArrayList<>();

        // Scanner pour entrer les valeurs
        Scanner sc = new Scanner(new File("F:/Documents/10 - Advent of code/AdventOfCode2025/Jour01/src/resources/donnees.txt"));


        while (sc.hasNextLine()) {
            String entree = sc.nextLine();
            code = tournerVerrou(entree, stockCode, verrou, code);
            System.out.println("Entrée : " + entree);
            System.out.println("Code : " + code);

        }

        sc.close();

        System.out.println("Nombre d'arrêts sur '0': " + compterZeroArret(stockCode));

    }

    // Méthode principale
    public static int tournerVerrou(String valeur, List<Integer> stockCode, List<Integer> verrou, int code) {
        // Séparation de la lettre + les chiffres de la valeur donnée dans un tableau
        String[] valeurSplit = valeur.split("");

        // Récupération de la lettre dans la variable "lettre"
        String lettre = valeurSplit[0];

        // Récupération du nombre dans la variable "nombre"
        int nombre =0;
        if (valeur.length() == 3) {
            nombre = Integer.parseInt(valeurSplit[1].concat(valeurSplit[2]));
        } else if (valeur.length() == 2) {
            nombre = Integer.parseInt(valeurSplit[1]);
        } else if (valeur.length() == 4) {
            nombre = Integer.parseInt(valeurSplit[1].concat(valeurSplit[2]).concat(valeurSplit[3]));
        }

        // Tourner le verrou autant de fois que le "nombre" en fonction de la "lettre"
        if (Objects.equals(lettre, "L")) {    // Si lettre "L" -> tourner à gauche
            if (code - nombre < 0) {                // Le verrou fait plus d'un tour
                if (Math.abs((code - nombre)%100) != 0) {
                    code = verrou.get(100 - (Math.abs((code - nombre) % 100)));
                } else {
                    code = verrou.get((Math.abs((code - nombre) % 100)));
                }
            } else {                                // Le verrou fait moins d'un tour
                code = verrou.get(code - nombre);
            }
        }  else if (Objects.equals(lettre, "R")) {      // Si lettre "R" -> tourner à droite
            if (code + nombre >= verrou.size()) {   // Le verrou fait plus d'un tour
                code = verrou.get((Math.abs((code + nombre)%100)));
            } else {                                // Le verrou fait moins d'un tour
                code = verrou.get(code + nombre);
            }
        }

        // Stockage du "code" dans l'Arraylist "stockCode"
        stockCode.add(code);

        return code;
    }


    // Calculer le nombre de fois où "0" est stocké dans l'ArrayList "stockCode"
    public static int compterZeroArret(List<Integer> liste) {
        int result = 0;
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i) == 0) {
                result++;
            }
        }
        return result;
    }




}

