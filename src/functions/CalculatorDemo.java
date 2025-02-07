package functions;

/*
 * Неделя 1 (Computer Science, функции)
 * Домашнее задание "Условные операторы".
 * Задание 2: функция с двумя операндами и операцией.
 */

public class CalculatorDemo {

    //test fields
    private static double operand1 = 10.0;
    private static double operand2 = 5.0;
    private static char operation = '/';

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';
    public static final char MODULO = '%';

    public static void main(String[] args) {
        double result = calculate(operand1, operand2, operation);
        System.out.printf("%f %c %f = %f", operand1, operation, operand2, result);
    }

    private static double calculate(double operand1, double operand2, char operation)
            throws IllegalArgumentException, ArithmeticException {

        return switch (operation) {
            case ADDITION -> add(operand1, operand2);
            case SUBTRACTION -> subtract(operand1, operand2);
            case MULTIPLICATION -> multiply(operand1, operand2);
            case DIVISION -> divide(operand1, operand2);
            case MODULO -> mod(operand1, operand2);
            default -> throw new IllegalArgumentException("no such operation");
        };
    }

    private static double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private static double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private static double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private static double divide(double operand1, double operand2) throws ArithmeticException {
        if (operand2 == 0) throw new ArithmeticException("div by zero");
        return operand1 / operand2;
    }

    private static double mod(double operand1, double operand2) throws ArithmeticException {
        if (operand2 == 0) throw new ArithmeticException("mod by zero");
        return operand1 % operand2;
    }
}
