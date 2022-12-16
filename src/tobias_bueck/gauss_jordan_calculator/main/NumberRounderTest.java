package tobias_bueck.gauss_jordan_calculator.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class NumberRounderTest {
    private NumberRounder numberRounder;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        final var stringFormatterMock = new StringFormatter();
        numberRounder = new NumberRounder(stringFormatterMock);
    }

    @Test
    void getExponentOfNumber(){
        Assertions.assertEquals(numberRounder.getExponentOfNumber(200), 2);
        Assertions.assertEquals(numberRounder.getExponentOfNumber(100), 2);
        Assertions.assertEquals(numberRounder.getExponentOfNumber(-100), 2);
        Assertions.assertEquals(numberRounder.getExponentOfNumber(-999), 2);
        Assertions.assertEquals(numberRounder.getExponentOfNumber(0.01), -2);
        Assertions.assertEquals(numberRounder.getExponentOfNumber(10), 1);
        Assertions.assertEquals(numberRounder.getExponentOfNumber(9), 0);
        Assertions.assertEquals(numberRounder.getExponentOfNumber(1), 0);
        Assertions.assertEquals(numberRounder.getExponentOfNumber(0.1), -1);
    }

    @Test
    void getNormalisedNumber(){
        Assertions.assertEquals(numberRounder.getNormalizedNumber("9987"), "9.987");
        Assertions.assertEquals(numberRounder.getNormalizedNumber("0.0001234"), "1.234");
        Assertions.assertEquals(numberRounder.getNormalizedNumber("0.0000001234"), "1.234");
        Assertions.assertEquals(numberRounder.getNormalizedNumber("90000"), "9.0");
        Assertions.assertEquals(numberRounder.getNormalizedNumber("90001"), "9.0001");
        Assertions.assertEquals(numberRounder.getNormalizedNumber("90001000"), "9.0001");
    }
}