package com.c1k4d4.tasks.week5.collections.cinema.classes;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.Objects;

public class Film {
    private static int UID = 0;

    private final int id;
    private final int year;
    private final int month;
    private final Genre genre;
    private final Rating rating;

    private Film(int id, YearMonth yearMonth, Genre genre, Rating rating) {
        this.id = id;
        this.year = yearMonth.getYear();
        this.month = yearMonth.getMonthValue();
        this.genre = genre;
        this.rating = rating;
    }

    public static Film create(YearMonth yearMonth, Genre genre, Rating rating) {
        return new Film(UID++, yearMonth, genre, rating);
    }

    public static class ComparatorByRating implements Comparator<Film> {
        @Override
        public int compare(Film f1, Film f2) {
            return f1.getRating().compareTo(f2.getRating());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && year == film.year && month == film.month && genre == film.genre && rating.equals(film.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, genre, rating);
    }

    @Override
    public String toString() {
        return String.format("ФИЛЬМ. id = %d, год: %d, месяц: %d, жанр: %s, рейтинг: %s",
                id, year, month, genre, rating);
    }

    public Rating getRating() {
        return rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }
}
