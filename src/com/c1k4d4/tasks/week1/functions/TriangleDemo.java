package com.c1k4d4.tasks.week1.functions;

/*
 * Неделя 1 (Computer Science, функции)
 * Домашнее задание "Условные операторы".
 * Задание 3: два прямоугольных треугольника и их площади.
 */

public class TriangleDemo {
    public static void main(String[] args) {
        functions.Triangle tr1 = new functions.Triangle(5, 10);
        functions.Triangle tr2 = new functions.Triangle(10, 20);

        //setVolume() выполняется в конструкторе класса functions.Triangle
        tr1.printCompareVolume(tr2);
    }
}
