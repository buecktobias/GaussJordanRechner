package tobias_bueck.gauss_jordan_calculator.main.string_formatter;

public final class StringFormatter {
    public String removeDotFromString(String number) {
        return number.replace(".", "");
    }

    public String removeMinusFromString(String number) {
        return number.replace("-", "");
    }

    public String removeZerosFromStart(String string) {
        if (string.length() == 1) {
            return string;
        } else if (string.charAt(0) != '0') {
            return string;
        } else {
            return removeZerosFromStart(string.substring(1));
        }
    }

    char getLastChar(String string) {
        return string.charAt(string.length() - 1);
    }

    String removeLastChar(String string) {
        return string.substring(0, string.length() - 1);
    }

    String removeZerosFromEnd(String string) {
        if (string.length() == 1) {
            return string;
        } else if (getLastChar(string) != '0') {
            return string;
        } else {
            return removeZerosFromEnd(removeLastChar(string));
        }
    }

    public String removeZerosFromStartAndEnd(String string) {
        if (string.length() == 0) {
            throw new RuntimeException("String is Empty! String can not be Empty!");
        }
        return removeZerosFromEnd(removeZerosFromStart(string));
    }

    public String insertDotAtSecondPosition(String string) {
        if (string.length() == 0) {
            throw new RuntimeException("String is Empty! String can not be Empty!");
        } else if (string.length() == 1) {
            return string.charAt(0) + ".0";
        }
        return string.charAt(0) + "." + string.substring(1);
    }

    public String increaseStringValue(char c) {
        return String.valueOf(Integer.parseInt(String.valueOf(c)) + 1);
    }

    public boolean isCharEven(char c) {
        return Integer.parseInt(String.valueOf(c)) % 2 == 0;
    }
}
