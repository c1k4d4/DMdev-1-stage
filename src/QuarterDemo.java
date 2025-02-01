/*
 * Неделя 1 (Computer Science, функции)
 * Домашнее задание "Условные операторы".
 * Задание 1: определение четверти часа по переменной minutes.
 */


public class QuarterDemo {

    private static int minutes = 50;

    public static void main(String[] args) {
        printQuarter(minutes);
    }

    private static void printQuarter(int minutes) {
        String quarter;
        if (minutes == 0)
            quarter = "1st";
        else {
            quarter = switch (minutes / 15) {
                case 0 -> "1st";
                case 1 -> "2nd";
                case 2 -> "3rd";
                case 3 -> "4th";
                default -> "no such";
            };
        }
        System.out.println(quarter + " quarter");
    }
}
