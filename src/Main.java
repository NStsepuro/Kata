import java.io.IOException;
import java.util.Scanner;

class Calc {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2, result;
    static char operation;
    static String string00, string01, string02;

    public static void main (String[] args) {
        System.out.println("Example: 2 + 2 -> Enter ");
        while(true) {
            String userInput = scanner.nextLine();

            String under_charString = String.valueOf(userInput);

            String[] blacks = under_charString.split(" ");

            try {
                string00 = blacks[0];
                string01 = blacks[1];
                string02 = blacks[2];
                string02 = string02.trim();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Data entered incorrectly. Ex.: 2 + 2");
                System.exit(1);
            }

            if (blacks.length >= 4) {
                try {
                    throw new ArrayIndexOutOfBoundsException();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Data entered incorrectly");
                    System.exit(1);
                }
            }

            try {
                number1 = Integer.parseInt(string00);
                number2 = Integer.parseInt(string02);
            } catch (NumberFormatException e) {
                System.out.println("Number 1 or 2 does not meet the requirements (point 2 or 4)");
                System.exit(1);
            }

            if (number1 < 1 | number2 < 1) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Number 1 or 2 does not meet the requirements (point 3). Num < 1");
                    System.exit(1);
                }
            } else if (number1 > 10 | number2 > 10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Number 1 or 2 does not meet the requirements (point 3). Num > 10");
                    System.exit(1);
                }
            }

            if (string01.length() >= 2) {
                try {
                    throw new ArrayIndexOutOfBoundsException();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Operator entered incorrectly");
                    System.exit(1);
                }
            } else operation = string01.charAt(0);

            result = calculated(number1, number2, operation);
            System.out.println(result);
        }
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid operation sign");
                    System.exit(1);
                }
            }
        }
        return result;
    }
}