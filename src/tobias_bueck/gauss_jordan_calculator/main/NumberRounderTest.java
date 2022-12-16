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
    void testIsNumberSmallerOne(){
        Assertions.assertTrue(numberRounder.isAbsoluteNumberSmallerThanOne("0.1"));
        Assertions.assertTrue(numberRounder.isAbsoluteNumberSmallerThanOne("-0.1"));
        Assertions.assertFalse(numberRounder.isAbsoluteNumberSmallerThanOne("1.0"));
        Assertions.assertFalse(numberRounder.isAbsoluteNumberSmallerThanOne("-1.0"));
        Assertions.assertFalse(numberRounder.isAbsoluteNumberSmallerThanOne("100.0"));
        Assertions.assertFalse(numberRounder.isAbsoluteNumberSmallerThanOne("-100.0"));
        Assertions.assertFalse(numberRounder.isAbsoluteNumberSmallerThanOne("900.0"));
        Assertions.assertFalse(numberRounder.isAbsoluteNumberSmallerThanOne("-900.0"));
        Assertions.assertTrue(numberRounder.isAbsoluteNumberSmallerThanOne("0.009"));
        Assertions.assertTrue(numberRounder.isAbsoluteNumberSmallerThanOne("-0.009"));
    }

    @Test
    void testGetExponentAbsoluteNumberBiggerOne() {
        Assertions.assertEquals(numberRounder.getExponentOfNumber("-1.1"), 1);
        Assertions.assertEquals(numberRounder.getExponentOfNumber("-11.1"), 2);
        Assertions.assertEquals(numberRounder.getExponentOfNumber("11.1"), 2);
        Assertions.assertEquals(numberRounder.getExponentOfNumber("100.1"), 3);
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
}