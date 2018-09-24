package kartollika.hw1_atm;

import java.util.Set;

public class Client {

    private int cashTotal;

    Client() {
        cashTotal = 0;
    }

    Client(int cashTotal) {
        this.cashTotal = cashTotal;
    }

    Set<String> requestCashVariants(ATM atm, int amount) {
        return atm.getVariantsOfOutput(amount);
    }

    public int getCashTotal() {
        return cashTotal;
    }
}
