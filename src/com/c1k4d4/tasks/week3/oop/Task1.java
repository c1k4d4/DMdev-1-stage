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

import com.c1k4d4.tasks.week3.oop.Apartment;
import com.c1k4d4.tasks.week3.oop.Building;
import com.c1k4d4.tasks.week3.oop.Room;
import com.c1k4d4.tasks.week3.oop.Storey;

import java.util.Random;

public class Task1 {

    private static final int BUILDING_NUMBER = 47;
    private static final int STOREYS_AMOUNT = 5;
    private static final int APARTMENTS_AMOUNT = 3;
    private static final int ROOMS_AMOUNT = 3;

    public static void main(String[] args) {
        Building building =
                createBuilding(BUILDING_NUMBER,
                createStoreys(STOREYS_AMOUNT,
                createApartments(APARTMENTS_AMOUNT,
                createRooms(ROOMS_AMOUNT))));
        Building.printAllInformation(building);
    }

    private static Building createBuilding(int number, Storey[] storeys) {
        return new Building(number, storeys);
    }

    private static Storey[] createStoreys(int amount, Apartment[] apartments) {
        Storey[] result = new Storey[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = new Storey(i + 1, apartments);
        }
        return result;
    }

    private static Apartment[] createApartments(int amount, Room[] rooms) {
        Apartment[] result = new Apartment[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = new Apartment(i + 1, rooms);
        }
        return result;
    }

    private static Room[] createRooms(int amount) {
        Room[] result = new Room[amount];
        Random random = new Random(4192832L);
        for (int i = 0; i < amount; i++) {
            result[i] = new Room(random.nextBoolean());
        }
        return result;
    }
}
