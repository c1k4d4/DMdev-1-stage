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
import static com.c1k4d4.tasks.week3.strings.utils.Task2Util.*;

public class Task2Runner {

    public static void main(String[] args) {
        String testString = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        System.out.println("Первоначальная строка: " + testString);
        System.out.println("Массив цифр из строки: " + Arrays.toString(parseInts(testString)));
        System.out.println("Сумма цифр массива: " + sumValues(parseInts(testString)));
    }
}
