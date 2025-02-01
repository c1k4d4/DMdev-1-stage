/*
 * Неделя 1 (Computer Science, функции)
 * Домашнее задание "Условные операторы".
 * Задание 2: функция с двумя операндами и операцией.
 */

public class CalculatorDemo {

    private static double operand1 = 10;
    private static double operand2 = 5;
    private static char operation = '/';

    public static void main(String[] args) {
        double result = calculate(operand1, operand2, operation);
        System.out.printf("%f %c %f = %f", operand1, operation, operand2, result);
    }

    private static double calculate(double operand1, double operand2, char operation)
            throws IllegalArgumentException, ArithmeticException {

        return switch (operation) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> {
                if (operand2 == 0) throw new ArithmeticException("div by zero");
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("no such operation");
        };

    }
}
