import Pair.Money;
import Pair.Fraction;
import Pair.Pair;

import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        String outputFilename = "C:\\Users\\SASHA\\github-classroom\\VLazorykOOP\\jlab5-Khoyskiy\\text\\Pair\\output.txt";
        List<Money> moneys = readMoney();
        List<Fraction> fractions = readFraction();
        for (Money mon :moneys) {
            System.out.println(mon + "\n--Next");
        }
        for (Fraction frac : fractions) {
            System.out.println(frac + "\n--Next");
        }
        Collections.sort(moneys);
        Collections.sort(fractions);
        System.out.println("\nPair after sorted: \n");
        for (Money mon : moneys) {
            System.out.println(mon + "\n--Next");
        }
        for (Fraction frac : fractions) {
            System.out.println(frac + "\n--Next");
        }

        addPair(moneys, fractions);
        Collections.sort(moneys);
        Collections.sort(fractions);
        System.out.println("\nPair after add : \n");
        for (Money mon : moneys) {
            System.out.println(mon + "\n--Next");
        }
        for (Fraction frac : fractions) {
            System.out.println(frac + "\n--Next");
        }
        List<Pair> pairs = new ArrayList<>();
        pairs.addAll(moneys);
        pairs.addAll(fractions);
        Collections.sort(pairs);
        for (Pair p : pairs) {
            System.out.println(p + "\n--Next");
        }
        Comparator<Pair> comparator = Comparator.comparing(Pair::getx);
        Collections.sort(pairs, comparator);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            for (Pair pair : pairs) {
                writer.write(pair + "\n--Next");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }

    static List<Money> readMoney() {
        List<Money> moneys = new ArrayList<>();
        String inputFileMoney = "C:\\Users\\SASHA\\github-classroom\\VLazorykOOP\\jlab5-Khoyskiy\\text\\Pair\\Money.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileMoney))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int dollar = Integer.parseInt(data[0]);
                int cents = Integer.parseInt(data[1]);
                Money money = new Money(dollar,cents);
                moneys.add(money);
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
        return moneys;
    }

    static List<Fraction> readFraction() {
        List<Fraction> fractions = new ArrayList<>();
        String inputFileFraction = "C:\\Users\\SASHA\\github-classroom\\VLazorykOOP\\jlab5-Khoyskiy\\text\\Pair\\Fraction.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileFraction))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int numerator = Integer.parseInt(data[0]);
                int denominator = Integer.parseInt(data[1]);
                Fraction fraction = new Fraction(numerator,denominator);
                fractions.add(fraction);
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
        return fractions;
    }

    static void addPair(List<Money> moneys, List<Fraction> fractions) {
        Scanner in = new Scanner(System.in);
        int t = 1;
        while (t != 4) {
            System.out.println("Choose a class to add a record:");
            System.out.println("1. Money");
            System.out.println("2. Fraction");
            System.out.println("3. Exit");
            System.out.print("Select option <<< ");
            t = in.nextInt();
            in.nextLine();
            switch (t) {
                case 1:
                    System.out.print("Enter Dollars $: ");
                    int dollar = in.nextInt();
                    System.out.print("Enter cents: ");
                    int cents = in.nextInt();
                    Money money = new Money(dollar, cents);
                    moneys.add(money);
                    break;
                case 2:
                    System.out.print("Enter Numerator: ");
                    int numerator = in.nextInt();
                    System.out.print("Enter Denominator: ");
                    int denominator = in.nextInt();
                    Fraction fraction = new Fraction(numerator,denominator);
                    fractions.add(fraction);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
            }
        }
    }


}
