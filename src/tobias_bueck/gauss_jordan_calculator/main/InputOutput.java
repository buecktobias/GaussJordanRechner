package tobias_bueck.gauss_jordan_calculator.main;

import java.util.Scanner;

public class InputOutput {
    private NumberRounder numberRounder;

    public InputOutput() {
        numberRounder = new NumberRounder(new StringFormatter());
    }

    public void start(){
        System.out.println("ZU welcher Mantissenlänge willst du runden?");
        Scanner scanner = new Scanner(System.in);
        var mantissenLength = scanner.nextInt();
        System.out.println("Es wird mit Mantissenlänge: " + mantissenLength + "  gerundet.");
        System.out.println("Gebe die zu rundende Zahl ein!");
        while(scanner.hasNext()){
            var line = scanner.next();
            var result = numberRounder.normaliseAndRoundTiesToEven(String.valueOf(line), mantissenLength);
            System.out.println("Das Ergebnis ist " + result.value() + "* 10^" + result.exponent());
            System.out.println("Gebe die zu rundende Zahl ein!");
        }
    }
}
