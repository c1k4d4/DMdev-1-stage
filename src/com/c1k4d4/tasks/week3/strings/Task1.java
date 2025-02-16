package com.c1k4d4.tasks.week3.strings;

/*
 * Неделя 3.
 * Задание 1.
 * Дана строка. Удалить из нее все повторяющиеся символы без учета регистра, если
 * они идут друг за другом. Также удалить пробелы. Результат привести к верхнему регистру.
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public class Task1 {
    public static void main(String[] args) {
        String testString = "abc Cpddd Dio OsfWw";
        System.out.println("Первоначальная строка: " + testString);
        System.out.println("Строка без дубликатов: " + removeDuplicates(testString));
    }

    private static String removeDuplicates(String original) {

        if (original == null || original.isEmpty()) {
            return original;
        }

        original = original.toUpperCase();
        int bufferSize = original.length();
        StringBuilder result = new StringBuilder(bufferSize);

        for (int i = 0; i < original.length(); i++) {
            char originalChar = original.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < result.length(); j++) {
                char resultChar = result.charAt(j);
                if (resultChar == originalChar || Character.isSpaceChar(originalChar)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                result.append(originalChar);
            }
        }
        return result.toString();
    }
}
