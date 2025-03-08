package com.c1k4d4.tasks.week5.collections.task2.chat;

import com.c1k4d4.tasks.week5.collections.task2.user.User;

import java.util.List;

public class Chat implements Comparable<Chat> {
    private final String name;
    private final List<User> users;

    public Chat(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public int compareTo(Chat chat) {
        return getName().compareTo(chat.getName());
    }

    @Override
    public String toString() {
        return "Название: " + getName() + ", кол-во пользователей: " + users.size();
    }
}