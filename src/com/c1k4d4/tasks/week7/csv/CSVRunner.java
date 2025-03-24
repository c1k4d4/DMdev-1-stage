package com.c1k4d4.tasks.week7.csv;

/*
 * Задание 1
 *
 * Даны два файла в формате CSV.
 * CSV (Comma-Separated Values) файл - это обычный текстовый файл, где через запятую
 * (может использоваться и любой другой символ) перечислены значения. Также может быть
 * в первой строчке таких файлов заголовок с названием колонок.
 *
 * Формат первого файла items-price.csv:
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 *
 * Формат второго файла items-name.csv:
 *
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 *
 * Задача:
 *
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля:
 * ID,NAME,PRICE.
 *
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах, то записать их в один файл errors.csv,
 * где будет лишь одно поле ID.
 */

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static com.c1k4d4.tasks.week7.csv.config.CSVConfig.*;
import static com.c1k4d4.tasks.week7.csv.util.CSVUtils.*;

public class CSVRunner {
    public static void main(String[] args) {
        Map<Integer, String> names = new TreeMap<>(parse(ITEMS_NAME_PATH));
        System.out.println("names map: " + names + "\n");

        Map<Integer, String> prices = new TreeMap<>(parse(ITEMS_PRICE_PATH));
        System.out.println("prices map: " + prices + "\n");

        Map<Integer, String> merged = new TreeMap<>(mergeById(names, prices));
        System.out.println("merged map: " + merged + "\n");

        writeToCSV(merged, DATA_PATH);
        //результат см. в resources: result.csv & errors.csv
    }
}
