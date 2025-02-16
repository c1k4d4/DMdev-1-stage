package com.c1k4d4.tasks.week3.strings;

/* Неделя 3.
 * Задание 2.
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * -возвращающий массив цифр из переданной строки
 * -возвращающий сумму цифр из переданного целочисленного массива
 *
 * Посчитать сумму всех чисел из строки. Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */

import java.util.Arrays;

public class Task2 {

    private static final int RADIX = 10;

    public static void main(String[] args) {
        String testString = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        System.out.println("Первоначальная строка: " + testString);
        System.out.println("Массив цифр из строки: " + Arrays.toString(parseInts(testString)));
        System.out.println("Сумма цифр массива: " + sumValues(parseInts(testString)));
    }

    private static int[] parseInts(String line) {

        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isDigit(ch)) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isDigit(ch)) {
                result[index++] = Character.digit(ch, RADIX);
            }
        }
        return result;
    }

    private static int sumValues(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
