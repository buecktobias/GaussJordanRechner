package tobias_bueck.gauss_jordan_calculator.main;

public final class NumberRounder {
    private StringFormatter stringFormatter;

    public NumberRounder(StringFormatter stringFormatter) {
        this.stringFormatter = stringFormatter;
    }

    int getExponentOfNumber(String number){
        return 0;
    }
    boolean isAbsoluteNumberSmallerThanOne(String number){
        return Math.abs(Double.parseDouble(number)) < 1;
    }

    int getExponentForAbsoluteNumberBiggerThanOne(String number){
        final var absoluteNumber = stringFormatter.getStringWithoutMinus(number);
        return absoluteNumber.indexOf('.');
    }
}
