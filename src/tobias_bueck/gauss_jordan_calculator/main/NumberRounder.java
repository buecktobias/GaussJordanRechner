package tobias_bueck.gauss_jordan_calculator.main;

/**
 * 0.00256 2.56 * 10^-3 Manissen Länge 2 => 2.6
 * <p>
 * normalisieren einer Zahl
 * . entfernen dann alle 0 vorne und am ende entfernen . an 2.Stelle einfügen
 * <p>
 * Normalisierte Zahl auf bestimmte Mantissenlänge runden
 * 1.358 => 1.4
 * 2.9 => 2.9
 * round(number, mantissenLänge){
 * if(number.length <= mantissenLänge){
 * return number
 * }else{
 * if(number >= (number[0..mantissenlänge] + '5'))
 * return number[0 ..mantissenlänge-1] + (number[mantissenlänge]+1)
 * else{
 * return number[0 ..mantissenlänge]
 * }
 * }
 * }
 */
final class NumberRounder {
    private StringFormatter stringFormatter;

    NumberRounder(final StringFormatter stringFormatter) {
        this.stringFormatter = stringFormatter;
    }

    boolean isPositiveNumber(final String number) {
        return Double.parseDouble(number) > 0;
    }

    boolean isPositiveNumber(final double number) {
        return number > 0;
    }

    int getExponentOfNumber(final String number) {
        return getExponentOfNumber(Double.parseDouble(number));
    }

    int getExponentOfNumber(final double number) {
        if (number == 0) {
            return 0;
        } else {
            final var numberLog10 = Math.log10(Math.abs(number));
            return (int) Math.floor(numberLog10);
        }
    }

    String getNormalizedStringNumber(final String number) {
        final var numberWithoutDot = stringFormatter.removeDotFromString(number);
        final var numberWithoutZeros = stringFormatter.removeZerosFromStartAndEnd(numberWithoutDot);
        return stringFormatter.insertDotAtSecondPosition(numberWithoutZeros);
    }

    NormalisedNumber getNormalisedNumberWithExponent(final String number) {
        final var isPositive = isPositiveNumber(number);
        final var absoluteNumber = stringFormatter.removeMinusFromString(number);
        final var normalisedNumber = getNormalizedStringNumber(absoluteNumber);
        final String normalisedNumberMinus;
        if (isPositive) {
            normalisedNumberMinus = normalisedNumber;
        } else {
            normalisedNumberMinus = "-" + normalisedNumber;
        }

        return new NormalisedNumber(normalisedNumberMinus, getExponentOfNumber(number));
    }

    NormalisedNumber getNormalisedNumberWithExponent(final double number) {
        return getNormalisedNumberWithExponent(String.valueOf(number));
    }

    double getNormalisedNumberAverage(String normalisedNumber, int mantissenLengthIncreased) {
        return Double.parseDouble(normalisedNumber.substring(0, mantissenLengthIncreased) + "5");
    }

    String roundNumberAwayFromZero(String normalisedNumber, int mantissenLength){
        return normalisedNumber.substring(0, mantissenLength) +
                stringFormatter.increaseStringValue(normalisedNumber.charAt(mantissenLength));
    }
    String roundNumberToZero(String normalisedNumber, int mantissenLengthIncreased){
        return normalisedNumber.substring(0, mantissenLengthIncreased);
    }

    String roundNormalisedNumber(String normalisedNumber, int mantissenLength) {
        final var mantissenLengthIncreased = mantissenLength + 1;

        assert mantissenLength >= 1 && normalisedNumber.length() >= 1;
        if (normalisedNumber.length() <= mantissenLengthIncreased) {
            return normalisedNumber;
        }
        final var lastInMantisse = normalisedNumber.charAt(mantissenLength);
        final var isEven = stringFormatter.isCharEven(lastInMantisse);

        final var normalisedNumberDouble = Double.parseDouble(normalisedNumber);
        final var normalisedNumberPlusFive = getNormalisedNumberAverage(normalisedNumber, mantissenLengthIncreased);

        final var isBigger = normalisedNumberDouble > normalisedNumberPlusFive;
        final var isTie = normalisedNumberDouble == normalisedNumberPlusFive;

        if (isBigger || (isTie && !isEven)) {
            return roundNumberAwayFromZero(normalisedNumber, mantissenLength);
        } else {
            return roundNumberToZero(normalisedNumber, mantissenLengthIncreased);
        }
    }
    NormalisedNumber normaliseAndRoundTiesToEven(String number, int mantissenLength){
        final var normalisedNumber = getNormalisedNumberWithExponent(number);
        final var roundedTiesToEven = roundNormalisedNumber(normalisedNumber.value(), mantissenLength);
        return new NormalisedNumber(roundedTiesToEven, normalisedNumber.exponent());
    }
}
