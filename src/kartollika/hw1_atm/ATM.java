package kartollika.hw1_atm;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ATM implements CashOutput {

    private Integer[] papers;

    public static void main(String[] args) {
        IOManager ioManager = new IOManager();
        Pair<Integer, Integer[]> inputData = ioManager.inputData();
        ATM atm = new ATM();
        atm.setPapers(inputData.getValue());
        Client client = new Client();
        Set<String> availableVariants = client.requestCashVariants(atm, inputData.getKey());
        ioManager.outputCollection(availableVariants);
    }

    @Override
    public Set<String> getVariantsOfOutput(int amount) {
        Set<String> variants = new HashSet<>();

        for (int i = 0; i < papers.length; ++i) {
            Set<String> variantsForPaper = getVariantsForPaper(amount - papers[i], i, papers[i] + " ");
            if (variantsForPaper == null) {
                continue;
            }
            variants.addAll(variantsForPaper);
        }
        return variants;
    }

    private Set<String> getVariantsForPaper(int amount, int paperInd, String curCombination) {
        Set<String> variants = new HashSet<>();

        if (amount == 0) {
            variants.add(curCombination.substring(0, curCombination.length() - 1));
            return variants;
        } else if (amount > 0) {
            for (int i = paperInd; i < papers.length; ++i) {
                Set<String> oneVariant = getVariantsForPaper(amount - papers[i], i,
                        curCombination + papers[i] + " ");
                if (oneVariant.isEmpty()) {
                    continue;
                }
                variants.addAll(oneVariant);
            }
        }
        return variants;
    }

    @Override
    public int[] releaseCash(String cashVariant) {
        return new int[0];
    }

    void setPapers(Integer[] papers) {
        this.papers = papers;
        Arrays.sort(papers, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.equals(o2) ? 0 : (o1 > o2 ? -1 : 1);
            }
        });
    }
}
