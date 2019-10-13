import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)

public class TicketSell_ {

    private final String value;
    private final int[] number;

    public TicketSell_(String value, int[] number) {
        this.value = value;
        this.number = number;
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {
                {"YES", new int[]{25}}

        };
    }

    @Test
    public void execute() {
        assertThat(sellTicketFor(number)).isEqualTo(value);
    }

    private String sellTicketFor(int[] number) {
        return null;
    }

}
