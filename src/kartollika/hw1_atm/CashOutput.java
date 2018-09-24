package kartollika.hw1_atm;

import java.util.Set;

public interface CashOutput {

    Set<String> getVariantsOfOutput(int amount);

    int[] releaseCash(String cashVariant);
}
