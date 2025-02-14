package functions;

/*
 * Неделя 1 (Computer Science, функции)
 * Домашнее задание "Условные операторы".
 * Задание 1: определение четверти часа по переменной minutes.
 */


public class QuarterDemo {

    //test field
    private static final int MINUTES = 50;

    private static final String FIRST_QUARTER = "1st quarter";
    private static final String SECOND_QUARTER = "2nd quarter";
    private static final String THIRD_QUARTER = "3rd quarter";
    private static final String FOURTH_QUARTER = "4th quarter";
    private static final String NOT_A_QUARTER = "no such quarter";

    public static void main(String[] args) {
        printQuarter(getQuarter(MINUTES));
    }

    private static int getQuarter(int minutes) {
        if (minutes < 0 || minutes > 59)
            throw new IllegalArgumentException("argument \"minutes\" must be 0 <= arg <= 59");
        return minutes / 15;
    }

    private static void printQuarter(int quarter) {
        String quarterMsg = switch (quarter) {
            case 0 -> FIRST_QUARTER;
            case 1 -> SECOND_QUARTER;
            case 2 -> THIRD_QUARTER;
            case 3 -> FOURTH_QUARTER;
            default -> NOT_A_QUARTER;
        };
        System.out.println(quarterMsg);
    }
}
