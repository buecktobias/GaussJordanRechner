package tobias_bueck.gauss_jordan_calculator.main.string_formatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFormatterTest {
    private StringFormatter stringFormatter;
    @BeforeEach
    void setUp() {
        stringFormatter = new StringFormatter();
    }
    @Test
    void testRemoveDotFromString(){
        Assertions.assertEquals(stringFormatter.removeDotFromString("1.0"), "10");
        Assertions.assertEquals(stringFormatter.removeDotFromString("10.0"), "100");
        Assertions.assertEquals(stringFormatter.removeDotFromString("0.01"), "001");
    }
    @Test
    void removeZerosFromStart(){
        Assertions.assertEquals(stringFormatter.removeZerosFromStart("0001"), "1");
        Assertions.assertEquals(stringFormatter.removeZerosFromStart("000123"), "123");
        Assertions.assertEquals(stringFormatter.removeZerosFromStart("0"), "0");
        Assertions.assertEquals(stringFormatter.removeZerosFromStart("000009"), "9");
        Assertions.assertEquals(stringFormatter.removeZerosFromStart("00000910"), "910");
        Assertions.assertEquals(stringFormatter.removeZerosFromStart("91"), "91");
        Assertions.assertEquals(stringFormatter.removeZerosFromStart("910"), "910");
        Assertions.assertEquals(stringFormatter.removeZerosFromStart("9101"), "9101");
    }
    @Test
    void removeZerosFromEnd(){
        Assertions.assertEquals(stringFormatter.removeZerosFromEnd("0001"), "0001");
        Assertions.assertEquals(stringFormatter.removeZerosFromEnd("1000"), "1");
        Assertions.assertEquals(stringFormatter.removeZerosFromEnd("0"), "0");
        Assertions.assertEquals(stringFormatter.removeZerosFromEnd("1010"), "101");
    }

    @Test
    void removeLastCharFromString(){
        Assertions.assertEquals(stringFormatter.removeLastChar("1234"), "123");
        Assertions.assertEquals(stringFormatter.removeLastChar("123"), "12");
    }

    @Test
    void removeZerosFromEndandStart(){
        Assertions.assertEquals(stringFormatter.removeZerosFromStartAndEnd("0001000"), "1");
        Assertions.assertEquals(stringFormatter.removeZerosFromStartAndEnd("10001"), "10001");
        Assertions.assertEquals(stringFormatter.removeZerosFromStartAndEnd("01010"), "101");
        Assertions.assertEquals(stringFormatter.removeZerosFromStartAndEnd("101010"), "10101");
        Assertions.assertEquals(stringFormatter.removeZerosFromStartAndEnd("000000"), "0");
        Assertions.assertEquals(stringFormatter.removeZerosFromStartAndEnd("1000000"), "1");
    }

    @Test
    void getLastChar(){
        Assertions.assertEquals(stringFormatter.getLastChar("test"), 't');
        Assertions.assertEquals(stringFormatter.getLastChar("1234"), '4');
        Assertions.assertEquals(stringFormatter.getLastChar("1"), '1');
    }

    @Test
    void insertDotAtPositionOne(){
        Assertions.assertEquals(stringFormatter.insertDotAtSecondPosition("123"), "1.23");
        Assertions.assertEquals(stringFormatter.insertDotAtSecondPosition("1"), "1.0");
        Assertions.assertEquals(stringFormatter.insertDotAtSecondPosition("198"), "1.98");
        Assertions.assertEquals(stringFormatter.insertDotAtSecondPosition("9"), "9.0");
    }
}