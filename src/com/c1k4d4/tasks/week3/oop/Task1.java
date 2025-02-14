package com.c1k4d4.tasks.week3.oop;

import com.c1k4d4.tasks.week3.oop.Apartment;
import com.c1k4d4.tasks.week3.oop.Building;
import com.c1k4d4.tasks.week3.oop.Room;
import com.c1k4d4.tasks.week3.oop.Storey;

import java.util.Random;

;

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
