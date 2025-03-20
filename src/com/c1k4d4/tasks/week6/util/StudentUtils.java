package com.c1k4d4.tasks.week6.util;

import com.c1k4d4.tasks.week6.student.Course;
import com.c1k4d4.tasks.week6.student.Grade;
import com.c1k4d4.tasks.week6.student.Student;

import java.util.*;
import java.util.stream.Collectors;

public final class StudentUtils {
    private static final double NULL_AVERAGE_GRADE = 0.0;

    /* public methods for tasks 1, 2, 3 */

    //1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
    public static Map<Course, Double> getAverageCoursesGrades(List<Student> students) {
        return students.stream()
                .filter(student -> student.getGrades().size() > 3)
                .collect(Collectors.
                        groupingBy(
                                Student::getCourse,
                                TreeMap::new,
                                Collectors.averagingDouble(StudentUtils::getAverageStudentGrade)
                        )
                );
    }

    // 2. Отсортированный (по имени и фамилии) список студентов
    public static Map<Course, List<Student>> getSortedStudents(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getName).thenComparing(Student::getSurname))
                .collect(Collectors.
                        groupingBy(
                                Student::getCourse,
                                TreeMap::new,
                                Collectors.toList()
                        )
                );
    }

    // 3. Объект CourseInfo с двумя полями (сортед список студентов и средняя оценка)
    public static Map<Course, CourseInfo> getCoursesInfo(List<Student> students) {
        Map<Course, Double> averageCourseMap = new TreeMap<>(getAverageCoursesGrades(students));
        Map<Course, List<Student>> sortedStudentsMap = new TreeMap<>(getSortedStudents(students));
        return averageCourseMap.entrySet().stream()
                .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> new CourseInfo(
                                        sortedStudentsMap.get(entry.getKey()),
                                        entry.getValue()
                                )
                        ));
    }


    /* util class for task-3 */

    public static class CourseInfo {
        private List<Student> students;
        private Double averageGrade;

        protected CourseInfo(List<Student> students, Double averageGrade) {
            this.students = students;
            this.averageGrade = averageGrade;
        }

        public List<Student> getStudents() {
            return students;
        }

        public Double getAverageGrade() {
            return averageGrade;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            CourseInfo that = (CourseInfo) o;
            return Objects.equals(students, that.students) && Objects.equals(averageGrade, that.averageGrade);
        }

        @Override
        public int hashCode() {
            return Objects.hash(students, averageGrade);
        }
    }


    /* print utils */

    public static void printStudents(List<Student> students) {
        students.forEach(System.out::println);
    }

    public static void printAverageCourseMap(Map<Course, Double> averageCourseMap) {
        for (Map.Entry<Course, Double> entry : averageCourseMap.entrySet()) {
            System.out.println(
                    "key (курс): " + entry.getKey() +
                            ", value (ср.оценка студентов): " + entry.getValue()
            );
        }
    }

    public static void printSortedStudentsMap(Map<Course, List<Student>> sortedStudentsMap) {
        for (Map.Entry<Course, List<Student>> entry : sortedStudentsMap.entrySet()) {
            System.out.println(
                    "key (курс): " + entry.getKey() + ", values (сортированные студенты): "
            );
            printStudents(entry.getValue());
        }
    }

    public static void printCourseInfoMap(Map<Course, CourseInfo> courseInfoMap) {
        for (Map.Entry<Course, CourseInfo> entry : courseInfoMap.entrySet()) {
            System.out.println("key (курс): " + entry.getKey() + ", value: ");
            printCourseInfo(entry.getValue());
        }
    }


    /* private methods */

    private static void printCourseInfo(CourseInfo info) {
        System.out.println("Средняя оценка курса: " + info.getAverageGrade());
        System.out.println("Список студентов: ");
        printStudents(info.getStudents());
    }

    private static double getAverageStudentGrade(Student student) {
        return student.getGrades().stream()
                .mapToInt(Grade::getGrade)
                .average()
                .orElse(NULL_AVERAGE_GRADE);
    }

    private StudentUtils() {}
}
