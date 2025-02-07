package functions;

/*
 * Неделя 1 (Computer Science, функции)
 * Домашнее задание "Условные операторы".
 * Задание 3: два прямоугольных треугольника и их площади.
 */

public class TriangleDemo {
    public static void main(String[] args) {
        Triangle tr1 = new Triangle(5, 10);
        Triangle tr2 = new Triangle(10, 20);

        //setVolume() выполняется в конструкторе класса functions.Triangle
        tr1.printCompareVolume(tr2);
    }
}
