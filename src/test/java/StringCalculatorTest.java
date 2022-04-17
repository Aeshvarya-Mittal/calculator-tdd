import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void emptyStringTest() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void oneNumberTest() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void twoNumbersTest(){
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void threeNumbersTest(){
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
    @Test
    public void newLineTest(){
        assertEquals(6,  StringCalculator.add("1\n2,3"));
    }

    @Test
    public void otherDelimiterTest(){
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void negativeNumberTest(){
        try {
            StringCalculator.add("-2,3");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -2");
        }

        try {
            StringCalculator.add("1,-8,9,-5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -8,-5");
        }
    }
}
