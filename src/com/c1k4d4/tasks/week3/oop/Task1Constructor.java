package com.c1k4d4.tasks.week3.oop;

import com.c1k4d4.tasks.week3.oop.Architecture.*;
import java.util.Random;

public class Task1Constructor {

    static Building createBuilding(int number, Storey[] storeys) {
        return new Building(number, storeys);
    }

    static Storey[] createStoreys(int amount, Apartment[] apartments) {
        Storey[] result = new Storey[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = new Storey(i + 1, apartments);
        }
        return result;
    }

    static Apartment[] createApartments(int amount, Room[] rooms) {
        Apartment[] result = new Apartment[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = new Apartment(i + 1, rooms);
        }
        return result;
    }

    static Room[] createRooms(int amount) {
        Room[] result = new Room[amount];
        Random random = new Random(4192832L);
        for (int i = 0; i < amount; i++) {
            result[i] = new Room(random.nextBoolean());
        }
        return result;
    }
}
