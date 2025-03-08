package com.c1k4d4.tasks.week5.collections.task1;

/*
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 *
 * Задача:
 * -Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * -Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * -Также предоставить сортировку чатов по названию по умолчанию.
 */

import com.c1k4d4.tasks.week5.collections.task1.chat.Chat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.c1k4d4.tasks.week5.collections.task1.chat.ChatConfig.*;
import static com.c1k4d4.tasks.week5.collections.task1.chat.ChatUtils.*;

public class ChatRunner {

    public static void main(String[] args) {
        System.out.println("Первоначальный лист: ");
        List<Chat> chatList = new ArrayList<>(List.of(CHATS));
        printChats(chatList);

        System.out.println("Удалить чаты < 1000 пользователей");
        removeChatsLessUsersCount(chatList, FILTER_LESS_USERS_COUNT);
        printChats(chatList);

        System.out.println("Сортировка по убыванию по кол-ву пользователей");
        chatList.sort(Collections.reverseOrder(new ReverseUserCountComparator()));
        printChats(chatList);

        System.out.println("Сортировка по-умолчанию (по названию)");
        Collections.sort(chatList);
        printChats(chatList);
    }
}
