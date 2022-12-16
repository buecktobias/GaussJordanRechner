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
        Assertions.assertEquals(numberRounder.getNormalizedStringNumber("9987"), "9.987");
        Assertions.assertEquals(numberRounder.getNormalizedStringNumber("0.0001234"), "1.234");
        Assertions.assertEquals(numberRounder.getNormalizedStringNumber("0.0000001234"), "1.234");
        Assertions.assertEquals(numberRounder.getNormalizedStringNumber("90000"), "9.0");
        Assertions.assertEquals(numberRounder.getNormalizedStringNumber("90001"), "9.0001");
        Assertions.assertEquals(numberRounder.getNormalizedStringNumber("90001000"), "9.0001");
    }

    @Test
    void getNormalisedNumberWithExponent(){
        Assertions.assertEquals(
                numberRounder.getNormalisedNumberWithExponent("99.34"),
                new NormalisedNumber("9.934", 1)
        );
        Assertions.assertEquals(
                numberRounder.getNormalisedNumberWithExponent("199.34"),
                new NormalisedNumber("1.9934", 2)
        );
        Assertions.assertEquals(
                numberRounder.getNormalisedNumberWithExponent("-99.34"),
                new NormalisedNumber("-9.934", 1)
        );
        Assertions.assertEquals(
                numberRounder.getNormalisedNumberWithExponent("0.001"),
                new NormalisedNumber("1.0", -3)
        );
    }
    @Test
    void testRoundNumberTiesToEven(){
        Assertions.assertEquals(numberRounder.roundNormalisedNumber("1.25",2),"1.3");
        Assertions.assertEquals(numberRounder.roundNormalisedNumber("1.256",2),"1.3");
        Assertions.assertEquals(numberRounder.roundNormalisedNumber("1.201",2),"1.2");
    }
}