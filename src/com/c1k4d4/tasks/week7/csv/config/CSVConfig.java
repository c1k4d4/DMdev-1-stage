package com.c1k4d4.tasks.week7.csv.config;

import java.nio.file.Path;

public final class CSVConfig {

    public static final String DATA_PATH = "./src/com/c1k4d4/tasks/week7/csv/resources";
    public static final Path ITEMS_PRICE_PATH = Path.of(DATA_PATH, "items-price.csv");
    public static final Path ITEMS_NAME_PATH = Path.of(DATA_PATH, "items-name.csv");

    private CSVConfig() {}
}
