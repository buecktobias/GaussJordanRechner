package tobias_bueck.gauss_jordan_calculator.main;

import tobias_bueck.gauss_jordan_calculator.main.number_rounder.NumberRounder;
import tobias_bueck.gauss_jordan_calculator.main.string_formatter.StringFormatter;

import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public record NormalisedNumber(String value, int exponent) {
    public double getDoubleValue(){
        final var doubleValue = Double.parseDouble(value);
        final var exponentPow10 = Math.pow(10,  exponent);
        return doubleValue * exponentPow10;
    }
}
