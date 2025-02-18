package com.c1k4d4.tasks.week3.strings.utils;

public final class Task1Util {

    public static String removeDuplicates(String original) {
        if (isNullOrEmpty(original)) {
            return original;
        }
        int bufferSize = original.length();
        StringBuilder result = new StringBuilder(bufferSize);
        for (int i = 0; i < original.length(); i++) {
            char originalChar = original.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < result.length(); j++) {
                char resultChar = result.charAt(j);
                if (resultChar == originalChar) {
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

    public static String removeSpaces(String original) {
        if (isNullOrEmpty(original)) {
            return original;
        }
        int bufferSize = original.length();
        StringBuilder result = new StringBuilder(bufferSize);
        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            if (ch != ' ') {
                result.append(ch);
            }
        }
        return result.toString().toUpperCase();
    }

    private static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    private Task1Util() {
    }
}
