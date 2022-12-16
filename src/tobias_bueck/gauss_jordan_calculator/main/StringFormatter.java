package tobias_bueck.gauss_jordan_calculator.main;

class StringFormatter {
    String removeDotFromString(String number){
        return number.replace(".", "");
    }
    String removeZerosFromStart(String string){
        if(string.length() == 1){
            return string;
        } else if(string.charAt(0) != '0'){
            return string;
        }else{
            return removeZerosFromStart(string.substring(1));
        }
    }
    char getLastChar(String string){
        return string.charAt(string.length()-1);
    }
    String removeLastChar(String string){
        return string.substring(0, string.length() - 1);
    }
    String removeZerosFromEnd(String string){
        if(string.length() == 1) {
            return string;
        }else if(getLastChar(string) != '0'){
            return string;
        }else{
            return removeZerosFromEnd(removeLastChar(string));
        }
    }
    String removeZerosFromStartAndEnd(String string){
        if(string.length() == 0){
            throw new RuntimeException("String is Empty! String can not be Empty!");
        }
        return removeZerosFromEnd(removeZerosFromStart(string));
    }

}
