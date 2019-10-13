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
                {YES, new int[]{25,25}},
                {YES, new int[]{25,50}}
        };
    }

    @Test
    public void execute() {
        assertThat(sellTicketFor(number)).isEqualTo(value);
    }

    private String sellTicketFor(int[] number) {
        if (number.length == DOLLARS_25) return NO;

        for (int dollars : number)
            if (dollars == 25)
                sum25Dollars();
            else if (dollars == 50 && num25Dollars()> DOLLARS_25)
                sum50Dollars();
            else
                return NO;
        return YES;
    }

    private void sum50Dollars() {
        billets[DOLLARS_50]++;
    }

    private int num25Dollars() {
        return billets[DOLLARS_25];
    }

    private void sum25Dollars() {
        billets[DOLLARS_25]++;
    }


}
