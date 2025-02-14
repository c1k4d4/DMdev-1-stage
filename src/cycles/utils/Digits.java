package cycles.utils;

/*
 * Служебный класс для работы с десятичными разрядами.
 */

public final class Digits {

    private static final int DIGIT = 10;

    private Digits() {
    }

    //Задача 1: OddAndEvenStarter
    public static int countOfEvenDigits(int value) {
        int count = 0;
        value = Math.abs(value);
        while (value > 0) {
            if (isEven(getLastDigit(value))) {
                count++;
            }
            value = dropLastDigit(value);
        }
        return count;
    }

    //Задача 1: OddAndEvenStarter
    public static int countOfOddDigits(int value) {
        int count = 0;
        value = Math.abs(value);
        while (value > 0) {
            if ( ! isEven(getLastDigit(value)) ) {
                count++;
            }
            value = dropLastDigit(value);
        }
        return count;
    }

    //Задача 2: ReverseIntStarter
    public static int reverse(int value) {
        int result = 0;
        boolean negative = isNegative(value);
        value = Math.abs(value);
        for (int i = countDigits(value) - 1; i >= 0; i--) {
            result += (int) (getLastDigit(value) * Math.pow(10, i));
            value = dropLastDigit(value);
        }
        return negative ? -result : result;
    }

    /*
     * Ниже служебные методы, общие для задач 1 (OddAndEven) и 2 (Reverse).
     */

    private static int getLastDigit(int value) {
        return value % DIGIT;
    }

    private static int dropLastDigit(int value) {
        return value / DIGIT;
    }

    private static int countDigits(int value) {
        value = Math.abs(value);
        int count = 0;
        while (value > 0) {
            value = dropLastDigit(value);
            count++;
        }
        return count;
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }

    private static boolean isNegative(int value) {
        return value < 0;
    }
}
