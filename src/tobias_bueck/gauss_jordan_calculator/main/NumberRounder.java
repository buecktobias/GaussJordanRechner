package tobias_bueck.gauss_jordan_calculator.main;

/**
 * 0.00256 2.56 * 10^-3 Manissen Länge 2 => 2.6
 *
 * normalisieren einer Zahl
 * . entfernen dann alle 0 vorne und am ende entfernen . an 2.Stelle einfügen
 */
final class NumberRounder {
    private StringFormatter stringFormatter;

    NumberRounder(StringFormatter stringFormatter) {
        this.stringFormatter = stringFormatter;
    }

    int getExponentOfNumber(String number){
        return getExponentOfNumber(Double.parseDouble(number));
    }
    int getExponentOfNumber(double number){
        if(number == 0){
            return 0;
        } else{
            final var numberLog10 = Math.log10(Math.abs(number));
            return (int) Math.floor(numberLog10);
        }
    }
}
