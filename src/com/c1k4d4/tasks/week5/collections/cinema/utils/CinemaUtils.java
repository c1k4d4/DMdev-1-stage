package com.c1k4d4.tasks.week5.collections.cinema.utils;

import com.c1k4d4.tasks.week5.collections.cinema.classes.Cinema;
import com.c1k4d4.tasks.week5.collections.cinema.classes.Film;

import java.util.Collection;
import java.util.Set;

public class CinemaUtils {

    public static void printCatalog(Cinema cinema) {
        for (Set<Film> films : cinema.getCatalog().values()) {
            printFilms(films);
        }
    }

    public static void printFilms(Collection<Film> films) {
        for(Film film : films) {
            System.out.println(film);
        }
        System.out.println();
    }


    private CinemaUtils() {}
}
