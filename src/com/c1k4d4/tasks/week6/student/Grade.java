package com.c1k4d4.tasks.week6.student;

public enum Grade {
    A(5),
    B(4),
    C(3),
    D(2);

    final Integer grade;

    public Integer getGrade() {
        return grade;
    }

    Grade(Integer grade) {
        this.grade = grade;
    }
}
