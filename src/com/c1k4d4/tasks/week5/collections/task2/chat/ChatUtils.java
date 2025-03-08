package com.c1k4d4.tasks.week5.collections.task2.chat;

import com.c1k4d4.tasks.week5.collections.task2.user.User;

import java.util.ArrayList;
import java.util.List;

public class ChatUtils {

    public static List<User> getUsersByAge(List<Chat> chats, int lower_limit, int upper_limit) {
        List<User> users = new ArrayList<>();
        for (Chat chat : chats) {
            for (User user : chat.getUsers()) {
                if (user.getAge() > lower_limit && user.getAge() < upper_limit) {
                    users.add(user);
                }
            }
        }
        return users;
    }

    public static void printChats(List<? extends Chat> chats) {
        int i = 1;
        for (Chat chat : chats)
            System.out.println(i++ + ". " + chat);
        System.out.println();
    }

    private ChatUtils() {}
}
