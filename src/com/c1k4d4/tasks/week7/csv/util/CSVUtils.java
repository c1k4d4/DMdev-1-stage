package com.c1k4d4.tasks.week7.csv.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CSVUtils {
    private static final Map<Integer, String> EMPTY_MAP = new TreeMap<>();
    private static final String DEFAULT_DELIMITER = ",";
    private static final String RESULT_FILENAME = "result.csv";
    private static final String ERRORS_FILENAME = "errors.csv";
    private static final String RESULT_HEADER = "ID,NAME,PRICE\n";
    private static final int TWO_FIELDS = 2;
    private static final int ID_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private static final int FIRST_FIELD_INDEX = 0;
    private static final int SECOND_FIELD_INDEX = 1;
    private static final int NO_LIMIT = -1;

    public static Map<Integer, String> parse(Path path) {
        return parse(path, DEFAULT_DELIMITER);
    }

    public static Map<Integer, String> parse(Path path, String delimiter) {
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                reader.readLine(); //skip csv-header
                return reader.lines()
                        .map(line -> line.split(delimiter, NO_LIMIT))
                        .filter(array -> array.length >= TWO_FIELDS)
                        .collect(Collectors.toMap(
                                array -> Integer.parseInt(array[ID_INDEX]),
                                array -> array[VALUE_INDEX],
                                (existing, replacement) -> replacement,
                                TreeMap::new
                        ));
            }
            catch (IOException e) {
                System.out.println(e + ": file read error");
                return EMPTY_MAP;
            }
        }
        else {
            return EMPTY_MAP;
        }
    }

    public static Map<Integer, String> mergeById(Map<Integer, String> first, Map<Integer, String> second) {
        return Stream.concat(first.entrySet().stream(), second.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> value1 + DEFAULT_DELIMITER + value2,
                        TreeMap::new
                ));
    }

    public static void writeToCSV(Map<Integer, String> map, String path) {
        try (BufferedWriter resultCSV = Files.newBufferedWriter(Path.of(path, RESULT_FILENAME));
             BufferedWriter errorsCSV = Files.newBufferedWriter(Path.of(path, ERRORS_FILENAME)))
        {
            resultCSV.write(RESULT_HEADER);
            errorsCSV.write(RESULT_HEADER);
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (isValidField(entry.getValue())) {
                    resultCSV.write(String.join(
                            DEFAULT_DELIMITER,
                            String.valueOf(entry.getKey()),
                            entry.getValue()) + "\n");
                }
                else {
                    errorsCSV.write(String.join(
                            DEFAULT_DELIMITER,
                            String.valueOf(entry.getKey()),
                            entry.getValue()) + "\n");
                }
            }
        }
        catch (IOException e) {
            System.out.println(e + ": file write error");
        }
    }

    private static boolean isValidField(String field) {
        if (field.contains(DEFAULT_DELIMITER)) {
            String[] fields = field.split(DEFAULT_DELIMITER, NO_LIMIT);
            return (!fields[FIRST_FIELD_INDEX].isEmpty() && !fields[SECOND_FIELD_INDEX].isEmpty());
        }
        else {
            return false;
        }
    }

    private CSVUtils() {}
}
