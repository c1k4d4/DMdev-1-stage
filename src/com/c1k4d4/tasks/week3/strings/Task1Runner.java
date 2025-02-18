package com.c1k4d4.tasks.week3.strings;

/*
 * Неделя 3.
 * Задание 1.
 * Дана строка. Удалить из нее все повторяющиеся символы без учета регистра, если
 * они идут друг за другом. Также удалить пробелы. Результат привести к верхнему регистру.
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

import static com.c1k4d4.tasks.week3.strings.utils.Task1Util.*;

public class Task1Runner {

    public static void main(String[] args) {
        String testString = "abc Cpddd Dio OsfWw";
        System.out.println("Первоначальная строка: " + testString);
        System.out.println("Строка без дубликатов: " + removeDuplicates(removeSpaces(testString)));
    }
}
