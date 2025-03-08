package com.c1k4d4.tasks.week5.collections.cinema.classes;

public enum Genre {
    DRAMA("Драма"),
    COMEDY("Комедия"),
    ADVENTURE("Приключения"),
    ACTION("Боевик"),
    TRILLER("Триллер"),
    DOCUMENTARY("Документальный"),
    HORROR("Ужасы"),
    SCIENCE_FICTION("Научная фантастика"),
    ROMCOM("Романтическая комедия");

    private final String description;

    @Override
    public String toString() {
        return description;
    }

    Genre(String description) {
        this.description = description;
    }
}
