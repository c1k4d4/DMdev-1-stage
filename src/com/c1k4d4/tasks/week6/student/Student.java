package com.c1k4d4.tasks.week6.student;

import java.util.List;
import java.util.Objects;

public class Student {
    private final String name;
    private final String surname;
    private Course course;
    private List<Grade> grades;

    public Student(String name, String surname, Course course, List<Grade> grades) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && course == student.course && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course, grades);
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Фамилия: %s, курс: %s, кол-во оценок: %d",
                name,
                surname,
                course,
                grades.size()
        );
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Course getCourse() {
        return course;
    }

    public List<Grade> getGrades() {
        return grades;
    }
}
