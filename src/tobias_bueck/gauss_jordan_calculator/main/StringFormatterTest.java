package tobias_bueck.gauss_jordan_calculator.main;

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
    public void testGetStringWithoutMinus(){
        Assertions.assertEquals(stringFormatter.getStringWithoutMinus("-1"), "1");
        Assertions.assertEquals(stringFormatter.getStringWithoutMinus("1"), "1");
        Assertions.assertEquals(stringFormatter.getStringWithoutMinus("-1.000001"), "1.000001");
    }

}