import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)

public class TicketSell_ {

    public static final String NO = "NO";
    public static final String YES = "YES";
    public static final int DOLLARS_25 = 0;
    public static final int DOLLARS_50 = 1;
    public static final int DOLLARS_100 = 2;
    private final String value;
    private final int[] number;
    private int[] billets = new int[3];

    public TicketSell_(String value, int[] number) {
        this.value = value;
        this.number = number;
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {
                {NO, new int[]{}},
                {YES, new int[]{25}},
                {NO, new int[]{50}},
                {NO, new int[]{100}},
                {YES, new int[]{25,25}},
                {YES, new int[]{25,50}},
                {YES, new int[]{25,25,50,100}},
                {NO, new int[]{25, 25, 50, 50, 100}}
        };
    }

    @Test
    public void execute() {
        assertThat(sellTicketFor(number)).isEqualTo(value);
    }

    private String sellTicketFor(int[] clientsQueue) {
        if (clientsQueue.length == 0) return NO;

        for (int bill : clientsQueue)
            if (bill == 25)
                add25Dollars();
            else if (bill == 50 && isChangeFor50Dollar()){
                sellTicketWith50Dollar();
            } else if (bill == 100 && isChangeFor100Dollar()) {
                sellTicketWith100Dollar();
            }
            else
                return NO;
        return YES;
    }

    private boolean isChangeFor50Dollar() {
        return get25Dollars()> 0;
    }

    private boolean isChangeFor100Dollar() {
        return get50Dollars() > 0 && get25Dollars()>0;
    }

    private void sellTicketWith100Dollar() {
        add100Dollars();
        rest50Dollars();
    }

    private void sellTicketWith50Dollar() {
        add50Dollars();
        rest25Dollars();
    }

    private void add100Dollars() {
        billets[DOLLARS_100]++;
    }

    private int get50Dollars() {
        return billets[DOLLARS_50];
    }

    private void add50Dollars() {
        billets[DOLLARS_50]++;
    }

    private void rest50Dollars() {
        billets[DOLLARS_50]--;
    }

    private int get25Dollars() {
        return billets[DOLLARS_25];
    }

    private void add25Dollars() {
        billets[DOLLARS_25]++;
    }

    private void rest25Dollars() {
        billets[DOLLARS_25]--;
    }


}
