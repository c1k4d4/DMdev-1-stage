package com.c1k4d4.tasks.week5.collections.task1.chat;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ChatUtils {

    public static void removeChatsLessUsersCount(List<? extends Chat> chatList, int less) {
        for (Iterator<? extends Chat> iterator = chatList.iterator(); iterator.hasNext(); ) {
            Chat next = iterator.next();
            if (next.getUsersCount() < less)
                iterator.remove();
        }
    }

    public static class ReverseUserCountComparator implements Comparator<Chat> {

        @Override
        public int compare(Chat o1, Chat o2) {
            if (o1.getUsersCount() == o2.getUsersCount()) {
                return o2.getName().compareTo(o1.getName());
            }
            else {
                return Integer.compare(o1.getUsersCount(), o2.getUsersCount());
            }
        }
    }

    public static void printChats(List<? extends Chat> chats) {
        int i = 1;
        for (Chat chat : chats)
            System.out.println(i++ + ". " + chat);
        System.out.println();
    }

    private ChatUtils() {}
}
