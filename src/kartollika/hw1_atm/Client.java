package kartollika.hw1_atm;

import java.util.Set;

public class Client {

    private int cashTotal;

    public Client() {
        cashTotal = 0;
    }

    Client(int cashTotal) {
        this.cashTotal = cashTotal;
    }

    public Set<String> requestCashVariants(ATM atm, int amount) {
        return atm.getVariantsOfOutput(amount);
    }

    public int getCashTotal() {
        return cashTotal;
    }
}
