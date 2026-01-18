import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Stocker les voltages max additionnés dans une variable
        int totalVoltage = 0;

        // Scanner pour entrer les valeurs
        Scanner sc = new Scanner(new File("F:\\Documents\\10 - Advent of code\\AdventOfCode2025\\Jour03\\ressources\\AdventOfCode2025J03.txt"));

        while (sc.hasNextLine()) {
            String bank = sc.nextLine();
            // Stocker chaque caractère de la banque dans un tableau
            String[] bankString = bank.split("");
            List<Integer> bankInteger = Arrays.stream(bankString).map(Integer::parseInt).toList();

            // Trouver 1ère valeur max
            int max1 = 0;
            int max1Index = 0;
            for (int j = 1; j < bankInteger.size()-1; j++) {
                if (bankInteger.get(max1Index) >= bankInteger.get(j)) {
                    max1 = bankInteger.get(max1Index);
                } else {
                    max1 = bankInteger.get(j);
                    max1Index = j;
                }
            }

            // Trouver 2nde valeur max
            int max2Index = max1Index + 1;
            int max2 = bankInteger.get(max2Index);

            // Si max1 était l'avant-dernière valeur de la banque, max2 est la dernière valeur
            if (max2Index == bankInteger.size()-1) {
                max2 = bankInteger.getLast();
            }

            // Sinon
            for (int j = max2Index+1; j < bankInteger.size(); j++) {
                if (max2 >= bankInteger.get(j)) {
                    max2 = bankInteger.get(max2Index);
                } else {
                    max2 = bankInteger.get(j);
                    max2Index = j;
                }
            }

            // Concaténer max1 et max2 pour obtenir le voltage max
            String maxVoltageString = String.valueOf(max1).concat(String.valueOf(max2));

            //Additionner les voltages max
            totalVoltage += Integer.parseInt(maxVoltageString);
        }

        System.out.println(totalVoltage);
    }
}