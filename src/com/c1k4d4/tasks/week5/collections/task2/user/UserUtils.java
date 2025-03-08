package com.c1k4d4.tasks.week5.collections.task2.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class UserUtils {

    private static final long RAND_SEED = 92449039841L;
    private static final int LOWER_AGE_LIMIT = 12;
    private static final int UPPER_AGE_LIMIT = 55 - LOWER_AGE_LIMIT;

    private static final String[] NAMES = {
            "Dmitry", "Alexey", "Alla", "Ekaterina", "Alexandra",
            "Maria", "Adam", "Vickor", "Natalya", "Ivan",
            "Vasiliy", "Alina", "Vladimir", "Grigoriy", "Michail",
            "Sergey", "Irina", "Ilya", "Gennadiy", "Nikita"
    };

    public static List<User> generateRandomUsers(int usersCount) {
        List<User> users = new ArrayList<>(usersCount);
        Random random = new Random(RAND_SEED);
        for (int i = 0; i < usersCount; i++) {
            String name = NAMES[random.nextInt(NAMES.length)];
            int age = LOWER_AGE_LIMIT + random.nextInt(UPPER_AGE_LIMIT);
            users.add(new User(i, name, age));
        }
        return users;
    }

    public static double getAverageUsersAge(List<User> users) {
        double average = 0;

        //по заданию, с помощью итератора
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User next = iterator.next();
            average += next.getAge();
        }
        return average / users.size();
    }

    public static void printUsers(List<? extends User> users) {
        int i = 1;
        for (User user : users)
            System.out.println(i++ + ". " + user);
        System.out.println();
    }

    private UserUtils() {}
}
