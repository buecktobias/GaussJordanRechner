package tobias_bueck.gauss_jordan_calculator.main;

public final class NumberRounder {
    private StringFormatter stringFormatter;

    public NumberRounder(StringFormatter stringFormatter) {
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
    boolean isAbsoluteNumberSmallerThanOne(String number){
        return Math.abs(Double.parseDouble(number)) < 1;
    }

    int getExponentForAbsoluteNumberBiggerThanOne(String number){
        final var absoluteNumber = stringFormatter.getStringWithoutMinus(number);
        return absoluteNumber.indexOf('.');
    }
}
