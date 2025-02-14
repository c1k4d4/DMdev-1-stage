package cycles;

/*
 * Неделя 2 (Циклы)
 *
 * Задание 1.
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число,
 * а возвращать количество четных цифр (вторая функция - нечетных).
 */

import java.util.Scanner;
import static cycles.utils.Digits.countOfEvenDigits;
import static cycles.utils.Digits.countOfOddDigits;

public class Task1_OddAndEvenStarter {

    public static void main(String[] args) {
        int number = intInput();
        System.out.println("Кол-во четных цифр: " + countOfEvenDigits(number));
        System.out.println("Кол-во нечетных цифр: " + countOfOddDigits(number));
    }

    private static int intInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        return in.nextInt();
    }
}
