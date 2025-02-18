package com.c1k4d4.tasks.week3.oop;

/*
 * Неделя 3.
 * Задание 1.
 * Представить в виде классов и их композиции следующую модель.
 * -Каждый дом содержит свой номер (int), и множество этажей (массив).
 * -Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * -Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * -Каждая комната содержит поле проходная она или нет (boolean).
 *
 * В каждом классе реализовать метод print, который на консоль выводит информацию
 * об объекте (должны присутствовать все поля объекта!). Например, метод print класса
 * этаж должен выводить на консоль:
 * “Этаж 2, количество квартир 18”
 * Создание всех объектов вынести в отдельный класс с методом main.
 * Там же реализовать метод printAllInformation, который на вход принимает объект
 * типа дом, и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая
 * методы print.
 */

import com.c1k4d4.tasks.week3.oop.Architecture.Building;
import static com.c1k4d4.tasks.week3.oop.Task1Constructor.*;
import static com.c1k4d4.tasks.week3.oop.Task1Config.*;

public class Task1Runner {
    public static void main(String[] args) {
        Building building =
                createBuilding(BUILDING_NUMBER,
                createStoreys(STOREYS_AMOUNT,
                createApartments(APARTMENTS_AMOUNT,
                createRooms(ROOMS_AMOUNT))));
        Building.printAllInformation(building);
    }
}
