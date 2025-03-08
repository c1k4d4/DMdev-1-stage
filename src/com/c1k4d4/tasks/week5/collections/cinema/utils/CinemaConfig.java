package com.c1k4d4.tasks.week5.collections.cinema.utils;

import com.c1k4d4.tasks.week5.collections.cinema.classes.Film;
import com.c1k4d4.tasks.week5.collections.cinema.classes.FivePointRating;
import com.c1k4d4.tasks.week5.collections.cinema.classes.Genre;
import com.c1k4d4.tasks.week5.collections.cinema.classes.Rating;

import java.time.YearMonth;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class CinemaConfig {
    public static final int AMOUNT_OF_FILMS = 50;
    public static final Film FILM_2003_2 = Film.create(
            YearMonth.of(2003, 2), Genre.COMEDY, FivePointRating.valueOf('4', '7')
    );

    private static final Random RANDOM = new Random(83459831928345L);
    private static final int FROM_YEAR = 2000;
    private static final int TO_YEAR = 2010;
    private static final int FIRST_MONTH = 1;
    private static final int LAST_MONTH = 12;
    private static final int CHAR_CODE_OF_ZERO = '0';
    private static final int AMOUNT_OF_STARS = 5;
    private static final int AMOUNT_OF_SUBSTARS = 10;

    public static Set<Film> getRandomSetOfFilms(int amount) {
        Set<Film> films = new LinkedHashSet<>(amount);
        while(films.size() < amount) {
            films.add(getRandomFilm());
        }
        return films;
    }

    private static Film getRandomFilm() {
        return Film.create(getRandomDate(FROM_YEAR, TO_YEAR), getRandomGenre(), getRandomRating());
    }

    private static YearMonth getRandomDate(int fromYear, int toYear) {
        return YearMonth.of(
                fromYear + RANDOM.nextInt(toYear - fromYear),
                FIRST_MONTH + RANDOM.nextInt(LAST_MONTH)
        );
    }

    private static Genre getRandomGenre() {
        return Genre.values()[RANDOM.nextInt(Genre.values().length)];
    }

    private static Rating getRandomRating() {
        return FivePointRating.valueOf(
                (char) (CHAR_CODE_OF_ZERO + RANDOM.nextInt(AMOUNT_OF_STARS)),
                (char) (CHAR_CODE_OF_ZERO + RANDOM.nextInt(AMOUNT_OF_SUBSTARS))
        );
    }

    private CinemaConfig() {}
}
