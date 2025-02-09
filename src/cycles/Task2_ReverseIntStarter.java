package cycles;

/*
 * Неделя 2 (Циклы)
 *
 * Задание 2.
 * Дано целое число. Написать функцию, которая принимает целое
 * число, а возвращает целое число обратное этому (не строку!).
 */

import java.util.Scanner;

import static cycles.Digits.reverse;

public class Task2_ReverseIntStarter {

    public static void main(String[] args) {
        int number = intInput();
        System.out.println("Число после реверса: " + reverse(number));
    }

    private static int intInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        return in.nextInt();
    }
}
