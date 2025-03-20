package com.c1k4d4.tasks.week6;

/*
 * Дан список студентов с полями:
 * -Имя
 * -Фамилия
 * -Номер курса в университете
 * -Список оценок за учебу
 *
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса,
 * а значением:
 *
 * 1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * 2. Список студентов данного курса, но только с полями Имя и Фамилия.
 * 3. Список должен быть отсортированы по этим двум полям
 *
 * Объект с двумя полями:
 * -Отсортированный список студентов с пункта 2
 * -Средняя оценка этих студентов
 *
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */

import com.c1k4d4.tasks.week6.student.Course;
import com.c1k4d4.tasks.week6.student.Student;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.c1k4d4.tasks.week6.config.StudentConfig.AMOUNT_OF_STUDENTS;
import static com.c1k4d4.tasks.week6.config.StudentConfig.generateRandomStudents;
import static com.c1k4d4.tasks.week6.util.StudentUtils.*;

public class StudentRunner {
    public static void main(String[] args) {
        List<Student> students = generateRandomStudents(AMOUNT_OF_STUDENTS);
        System.out.println("\nПервоначальный список: ");
        printStudents(students);

        System.out.println("\nTASK-1");
        Map<Course, Double> averageCourseMap = new TreeMap<>(getAverageCoursesGrades(students));
        printAverageCourseMap(averageCourseMap);

        System.out.println("\nTASK-2");
        Map<Course, List<Student>> sortedStudentsMap = new TreeMap<>(getSortedStudents(students));
        printSortedStudentsMap(sortedStudentsMap);

        System.out.println("\nTASK-3");
        Map<Course, CourseInfo> courseInfoMap = new TreeMap<>(getCoursesInfo(students));
        printCourseInfoMap(courseInfoMap);
    }
}
