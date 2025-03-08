package com.c1k4d4.tasks.week5.collections.task2;

/*
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей”
 * будет список объектов типа Пользователь, который имеет 3 поля: id (целочисленный
 * идентификатор), имя и возраст.
 *
 * Задача:
 * -Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * -С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */

import com.c1k4d4.tasks.week5.collections.task2.chat.Chat;
import com.c1k4d4.tasks.week5.collections.task2.user.User;
import java.util.ArrayList;
import java.util.List;

import static com.c1k4d4.tasks.week5.collections.task2.chat.ChatConfig.*;
import static com.c1k4d4.tasks.week5.collections.task2.chat.ChatUtils.*;
import static com.c1k4d4.tasks.week5.collections.task2.user.UserUtils.getAverageUsersAge;
import static com.c1k4d4.tasks.week5.collections.task2.user.UserUtils.printUsers;

public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>(List.of(CHATS));
        printChats(chats);

        List<User> users = getUsersByAge(chats, LOWER_AGE_LIMIT, UPPER_AGE_LIMIT);
        printUsers(users);

        System.out.println("Средний возраст пользователей: " + getAverageUsersAge(users));
    }
}
