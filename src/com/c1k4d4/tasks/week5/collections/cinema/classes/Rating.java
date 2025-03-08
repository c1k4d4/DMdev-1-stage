package com.c1k4d4.tasks.week5.collections.cinema.classes;

public interface Rating extends Comparable<Rating> {
    double getValue();
    boolean equals(Object o);
    int hashCode();
    String toString();
}
