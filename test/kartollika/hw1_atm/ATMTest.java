package kartollika.atm;

import kartollika.hw1_atm.ATM;
import kartollika.hw1_atm.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ATMTest {

    @Test
    public void getVariantsOfOutput() {
        Set<String> expected = new HashSet<>();
        Set<String> result;
        ATM testATM = new ATM();
        testATM.setPapers(new Integer[]{3, 6, 8});
        Client testClient = new Client();

        result = testClient.requestCashVariants(testATM, 6);
        expected.add("6");
        expected.add("3 3");
        Assert.assertEquals(expected, result);

        expected.clear();

        testATM.setPapers(new Integer[]{4, 1, 2});
        result = testClient.requestCashVariants(testATM, 5);
        expected.add("4 1");
        expected.add("2 1 1 1");
        expected.add("2 2 1");
        expected.add("1 1 1 1 1");
        Assert.assertEquals(expected, result);
    }
}
