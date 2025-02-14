package arrays;

/*
 * Неделя 2 (Массивы)
 *
 * Задание 3.
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только
 * отрицательными числами, только положительными и только нули. Если для какого-то из
 * массивов не будет значений, то должен быть создан пустой массив. Возвращает функция
 * эти три массива в виде одного двумерного.
 */

import java.util.Arrays;

public class Task3_ArraySplittingStarter {

    public static final int NEGATIVE_INDEX = 0;
    public static final int POSITIVE_INDEX = 1;
    public static final int ZERO_INDEX = 2;

    public static void main(String[] args) {
        int[] TEST_ARRAY = { -12, 0, 14, 541, -684, -3, 0, 20, 85, -29 };
        int[][] array = splitArray(TEST_ARRAY);
        System.out.println("Первоначальный массив: " + Arrays.toString(TEST_ARRAY));
        System.out.println("Разделенный массив: " + Arrays.deepToString(array));
    }

    private static int[][] splitArray(int[] array) {
        int[][] result = new int[3][];
        result[NEGATIVE_INDEX] = getNegative(array);
        result[POSITIVE_INDEX] = getPositive(array);
        result[ZERO_INDEX] = getZero(array);
        return result;
    }

    private static int[] getNegative(int[] array) {
        int negative = 0;

        for (int value : array) {
            if (value < 0) negative++;
        }

        int[] result = new int[negative];
        int index = 0;
        for (int value : array) {
            if (value < 0) result[index++] = value;
        }

        return result;
    }

    private static int[] getPositive(int[] array) {
        int positive = 0;

        for (int value : array) {
            if (value < 0) positive++;
        }

        int[] result = new int[positive];
        int index = 0;
        for (int value : array) {
            if (value > 0) result[index++] = value;
        }

        return result;
    }

    private static int[] getZero(int[] array) {
        int zero = 0;

        for (int value : array) {
            if (value == 0) zero++;
        }

        int[] result = new int[zero];
        Arrays.fill(result, 0);
        return result;
    }
}
