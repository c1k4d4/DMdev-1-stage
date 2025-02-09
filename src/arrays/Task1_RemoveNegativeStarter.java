package arrays;

/*
 * Неделя 2 (Массивы)
 *
 * Задание 1.
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать
 * новый массив с только положительными элементами). После удаления - умножить каждый
 * элемент массива на его длину.
 */

import java.util.Arrays;

public class Task1_RemoveNegativeStarter {

    private static final int[] TEST_ARRAY = { -12, 0, 14, 541, -684, -3, 51, 20, 85, -29 };

    public static void main(String[] args) {
        System.out.println("Первоначальный массив: " + Arrays.toString(TEST_ARRAY));
        int[] array = removeNegativeElements(TEST_ARRAY);
        System.out.println("После удаления отриц. эл-ов: " + Arrays.toString(array));
        array = multiplyByLength(array);
        System.out.println("После умножения каждого эл-та на длину массива: " + Arrays.toString(array));
    }

    private static int[] removeNegativeElements(int[] array) {
        int[] result = new int[array.length];
        int index = 0;
        for (int value : array) {
            if (value >= 0)
                result[index++] = value;
        }
        return Arrays.copyOf(result, index);
    }

    private static int[] multiplyByLength(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            array[i] *= length;
        }
        return array;
    }
}
