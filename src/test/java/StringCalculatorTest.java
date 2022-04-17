import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void emptyStringTest() {
        assertEquals(0, StringCalculator.add(""));
    }
}
