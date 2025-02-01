/*
 * Неделя 1 (Computer Science, функции)
 * Домашнее задание "Условные операторы".
 * Задание 1: определение четверти часа по переменной minutes.
 */


public class QuarterDemo {

    private static int minutes = 60;

    public static void main(String[] args) {
        printQuarter(minutes);
    }

    private static void printQuarter(int minutes) {
        String quarter;
        if (minutes == 0)
            quarter = "first";
        else {
            quarter = switch (minutes / 15) {
                case 0 -> "first";
                case 1 -> "second";
                case 2 -> "third";
                case 3 -> "fourth";
                default -> "no such";
            };
        }
        System.out.println(quarter + " quarter");
    }
}
