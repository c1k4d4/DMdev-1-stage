package com.c1k4d4.tasks.week5.collections.task1.chat;

public class Chat implements Comparable<Chat> {
    private final String name;
    private final int usersCount;

    public Chat(String name, int usersCount) {
        this.name = name;
        this.usersCount = usersCount;
    }

    public int compareTo(Chat chat) {
        return getName().compareTo(chat.getName());
    }

    @Override
    public String toString() {
        return "Название: " + getName() + ", кол-во пользователей: " + getUsersCount();
    }

    public String getName() {
        return name;
    }

    public int getUsersCount() {
        return usersCount;
    }
}
