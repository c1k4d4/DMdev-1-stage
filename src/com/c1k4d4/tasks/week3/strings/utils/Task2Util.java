package com.c1k4d4.tasks.week3.strings.utils;

public final class Task2Util {

    private static final int CODE_POINT_OF_ZERO = 48;
    public static final int CODE_POINT_OF_NINE = 57;

    public static int[] parseInts(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (isDigit(ch)) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (isDigit(ch)) {
                result[index++] = toDigit(ch);
            }
        }
        return result;
    }

    public static int sumValues(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    private static boolean isDigit(char ch) {
        int codePoint = ch;
        return (CODE_POINT_OF_ZERO <= codePoint && codePoint <= CODE_POINT_OF_NINE);
    }

    private static int toDigit(char ch) {
        return (int) ch - CODE_POINT_OF_ZERO;
    }

    private Task2Util() {
    }

}
