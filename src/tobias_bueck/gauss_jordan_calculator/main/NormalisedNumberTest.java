package tobias_bueck.gauss_jordan_calculator.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalisedNumberTest {

    @Test
    void getDoubleValue() {
        Assertions.assertEquals(
                new NormalisedNumber("1.45", 3).getDoubleValue(), 1450d, 0.001
        );
        Assertions.assertEquals(
                new NormalisedNumber("1.45", 0).getDoubleValue(), 1.45d, 0.001
        );
        Assertions.assertEquals(
                new NormalisedNumber("1.45", -1).getDoubleValue(), 0.145d, 0.001
        );
        Assertions.assertEquals(
                new NormalisedNumber("1.45", -2).getDoubleValue(), 0.0145d, 0.001
        );
    }
}