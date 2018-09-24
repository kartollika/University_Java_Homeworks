package kartollika.hw1_atm;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IOManager {

    Pair<Integer, Integer[]> inputData() {
        int sum = 0;
        Set<Integer> papers = new HashSet<>();

        try (Scanner scanner = new Scanner(System.in)) {
            String inputLine = scanner.nextLine();
            String[] inputIntsAsStrings = inputLine.split(" ");
            sum = Integer.parseInt(inputIntsAsStrings[0]);
            if (sum <= 0) {
                throw new NumberFormatException("Sum has not positive sign!");
            }

            for (int i = 1; i < inputIntsAsStrings.length; ++i) {
                Integer nextPaper = Integer.valueOf(inputIntsAsStrings[i]);
                if (nextPaper <= 0) {
                    throw new NumberFormatException("Paper #" + i + " has not positive sign!");
                }
                papers.add(Integer.valueOf(inputIntsAsStrings[i]));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return new Pair<>(sum, papers.toArray(new Integer[]{}));
    }

    void outputCollection(Set<String> variants) {
        System.out.println(variants.size());
        for (String variant : variants) {
            System.out.println(variant);
        }
    }
}
