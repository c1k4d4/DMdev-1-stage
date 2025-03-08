package com.c1k4d4.tasks.week5.collections.cinema.classes;

import java.util.*;

public class Cinema {
    private static final Set<Film> EMPTY_FILMS_SET = new LinkedHashSet<>();

    private final Map<Integer, Set<Film>> catalog;

    public Cinema(Set<Film> films) {
        this.catalog = new TreeMap<>();
        for (Film film : films) {
            add(film);
        }
    }

    public void add(Film film) {
        if (catalog.containsKey(film.getYear())) {
            addToSet(film.getYear(), film);
        }
        else {
            catalog.put(film.getYear(), new LinkedHashSet<>());
            addToSet(film.getYear(), film);
        }
    }

    public Set<Film> getByYear(int year) {
        return catalog.getOrDefault(year, EMPTY_FILMS_SET);
    }

    public Set<Film> getByYearMonth(int year, int month) {
        if (catalog.containsKey(year)) {
            Set<Film> result = new LinkedHashSet<>();
            for (Film film : catalog.get(year)) {
                if(month == film.getMonth()) {
                    result.add(film);
                }
            }
            return result;
        }
        else {
            return EMPTY_FILMS_SET;
        }
    }

    public Set<Film> getByGenre(Genre genre) {
        Set<Film> result = new LinkedHashSet<>();
        for (Set<Film> films : catalog.values()) {
            for (Film film : films) {
                if (genre.equals(film.getGenre())) {
                    result.add(film);
                }
            }
        }
        return result;
    }

    public Set<Film> getTopRating() {
        return getTopRating(10);
    }

    public Set<Film> getTopRating(int amount) {
        return getTopRating(amount, true);
    }

    public Set<Film> getTopRating(int amount, boolean reverse) {
        List<Film> allFilms = new LinkedList<>();
        for (Set<Film> films : catalog.values()) {
            allFilms.addAll(films);
        }

        if (reverse) {
            allFilms.sort(Collections.reverseOrder(new Film.ComparatorByRating()));
        }
        else {
            allFilms.sort(new Film.ComparatorByRating());
        }

        return (amount > allFilms.size())
                ? new LinkedHashSet<>(allFilms.subList(0, allFilms.size()))
                : new LinkedHashSet<>(allFilms.subList(0, amount));

    }

    //for using in CinemaUtils
    public Map<Integer, Set<Film>> getCatalog() {
        return catalog;
    }

    private void addToSet(int key, Film film) {
        catalog.get(key).add(film);
    }
}
