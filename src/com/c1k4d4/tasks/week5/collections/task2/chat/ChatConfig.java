package com.c1k4d4.tasks.week5.collections.task2.chat;

import static com.c1k4d4.tasks.week5.collections.task2.user.UserUtils.generateRandomUsers;

public class ChatConfig {

    public static final int LOWER_AGE_LIMIT = 18;
    public static final int UPPER_AGE_LIMIT = Integer.MAX_VALUE;

    private static final int NEWS_USERS_COUNT = 10;
    private static final int MOVIES_USERS_COUNT = 10;
    private static final int MUSIC_USERS_COUNT = 10;
    private static final int DMDEV_CHAT_USERS_COUNT = 11;

    public static final Chat[] CHATS = {
            new Chat("News", generateRandomUsers(NEWS_USERS_COUNT)),
            new Chat("Movies", generateRandomUsers(MOVIES_USERS_COUNT)),
            new Chat("Music", generateRandomUsers(MUSIC_USERS_COUNT)),
            new Chat("DMdev-chat", generateRandomUsers(DMDEV_CHAT_USERS_COUNT))
    };

    private ChatConfig() {}
}
