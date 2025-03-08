package com.c1k4d4.tasks.week5.collections.cinema;

/*
 * Даны 2 класса:
 * -Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания,
 * Жанр и Рейтинг;
 * -Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив,
 * где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 *
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * -добавлять в него новый фильм
 * -получить все фильмы по переданному году
 * -получить все фильмы по переданному году и месяцу
 * -получить все фильмы по переданному жанру
 * -получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 *
 * Учесть следующее:
 * -в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть
 * порядок значения ассоциативного массива)
 * -не должен добавляться фильм, если такой уже есть в кинотеатре
 *
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */

import com.c1k4d4.tasks.week5.collections.cinema.classes.Cinema;
import com.c1k4d4.tasks.week5.collections.cinema.classes.Genre;

import static com.c1k4d4.tasks.week5.collections.cinema.utils.CinemaConfig.*;
import static com.c1k4d4.tasks.week5.collections.cinema.utils.CinemaUtils.*;

public class CinemaRunner {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(getRandomSetOfFilms(AMOUNT_OF_FILMS));

        System.out.println("-------- Весь каталог фильмов -------");
        printCatalog(cinema);

        System.out.println("-------- Фильмы за 2003 год -------- ");
        printFilms(cinema.getByYear(2003));

        System.out.println("Добавить фильм 2003-2\n");
        cinema.add(FILM_2003_2);

        System.out.println("-------- Фильмы за 2003 год, 2 месяц -------- ");
        printFilms(cinema.getByYearMonth(2003, 2));

        System.out.println("-------- Фильмы жанра КОМЕДИЯ -------- ");
        printFilms(cinema.getByGenre(Genre.COMEDY));

        System.out.println("-------- ТОП 10 фильмов -------- ");
        printFilms(cinema.getTopRating());
    }
}
