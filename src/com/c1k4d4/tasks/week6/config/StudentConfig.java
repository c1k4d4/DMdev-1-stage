package com.c1k4d4.tasks.week6.config;

import com.c1k4d4.tasks.week6.student.Course;
import com.c1k4d4.tasks.week6.student.Grade;
import com.c1k4d4.tasks.week6.student.Student;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class StudentConfig {
    public static final int AMOUNT_OF_STUDENTS = 20;
    private static final Random RANDOM = new Random(98512983791512L);
    private static final int MIN_AMOUNT_OF_GRADES = 1;
    private static final int MAX_AMOUNT_OF_GRADES = 6;

    private static final String[] NAMES = {
            "Dmitry", "Alexey", "Alla", "Ekaterina", "Alexandra",
            "Maria", "Adam", "Vickor", "Natalya", "Ivan",
            "Vasiliy", "Alina", "Vladimir", "Grigoriy", "Michail",
            "Sergey", "Irina", "Ilya", "Gennadiy", "Nikita"
    };

    private static final String[] SURNAMES = {
            "Vasilyev", "Zaytsev", "Kuznetsov", "Karpov", "Dmitriev",
            "Medvedev", "Nikolaev", "Kryuchkov", "Burov", "Smirnov",
            "Ivanov", "Alekseev", "Korovin", "Nikitin", "Kalinin",
            "Titov", "Maslennikov", "Nikulin", "Melnikov", "Suharyov"
    };

    public static List<Student> generateRandomStudents(int amount) {
        return Stream.iterate(0, i -> i < amount, i -> i + 1)
                .map(i -> getRandomStudent())
                .collect(Collectors.toList());
    }

    private static Student getRandomStudent() {
        return new Student(
                getRandomName(),
                getRandomSurname(),
                getRandomCourse(),
                getRandomGrades()
        );
    }

    private static String getRandomName() {
        return NAMES[RANDOM.nextInt(NAMES.length)];
    }

    private static String getRandomSurname() {
        return SURNAMES[RANDOM.nextInt(SURNAMES.length)];
    }

    private static Course getRandomCourse() {
        return Course.values()[RANDOM.nextInt(Course.values().length)];
    }

    private static List<Grade> getRandomGrades() {
        int amount = MIN_AMOUNT_OF_GRADES + RANDOM.nextInt(MAX_AMOUNT_OF_GRADES);
        return Stream.iterate(0, i -> i < amount, i -> i + 1)
                .map(i -> getRandomGrade())
                .collect(Collectors.toList());
    }

    private static Grade getRandomGrade() {
        return Grade.values()[RANDOM.nextInt(Grade.values().length)];
    }

    private StudentConfig() {}
}
