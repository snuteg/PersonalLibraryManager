import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не числовое значение");
            }
        }
    }

    public double readDouble(String message) {
        while (true) {
            System.out.print(message);

            try {
                String input = scanner.nextLine();
                double value = Double.parseDouble(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не числовое значение");
            }
        }
    }
}
