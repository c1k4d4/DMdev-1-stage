package com.c1k4d4.tasks.week2.arrays;

/*
 * Неделя 2 (Массивы)
 *
 * Задание 2.
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой
 * символ - это число в памяти компьютера). Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’]
 * -> [97, 54, 121, 80, 84, 113, 57, 43]
 *
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести
 * на консоль только те элементы, которые больше этого среднего арифметического.
 */

import java.util.Arrays;

public class Task2_CharToIntStarter {

    public static void main(String[] args) {
        char[] TEST_ARRAY = { 'A', 'B', 'C', 'D', '!', '7', '@', '9', '0', ']' };
        //тестирование методов
        System.out.println("Первоначальный массив: " + Arrays.toString(TEST_ARRAY));
        System.out.println("Массив кодов символов: " + Arrays.toString(charToInt(TEST_ARRAY)));
        System.out.println("Среднее арифметическое: " + getArithmeticalMean(charToInt(TEST_ARRAY)));
        System.out.print("Далее элементы массива, больше этого ср.арифм.: ");

        //по условиям задачи
        int[] array = charToInt(TEST_ARRAY);
        int median = (int) getArithmeticalMean(array);
        printElements(getGreaterElements(array, median));
    }

    private static int[] charToInt(char[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    private static double getArithmeticalMean(int[] array) {
        long sum = 0L;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }

    private static int[] getGreaterElements(int[] array, int median) {
        int greaterCount = 0;
        for (int value : array) {
            if (value > median) {
                greaterCount++;
            }
        }

        int index = 0;
        int[] result = new int[greaterCount];
        for (int value : array) {
            if (value > median) {
                result[index++] = value;
            }
        }
        return result;
    }

    private static void printElements(int[] array) {
        for (int value : array)
            System.out.print(value + " ");
    }
}
