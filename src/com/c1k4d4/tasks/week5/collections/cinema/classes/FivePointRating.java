package com.c1k4d4.tasks.week5.collections.cinema.classes;

import java.util.Objects;

public class FivePointRating implements Rating {

    /*
     * Пятизвездочная система рейтинга.
     * Валидные значения - от 0 до 5 включительно (тип double),
     * формат "0.0". Например:
     * 3.1, 2.4, 5.0 и т.д.
     *
     * stars - старший коэффициент (цифра 3 в 3.1)
     * substars - младший коэффициент (цифра 1 в 3.1)
     */

    private static final int DEFAULT_RATING = 0;
    private static final int DECIMAL_RADIX = 10;

    private final double value;

    public static FivePointRating valueOf(char digit1, char digit2) {
        int star;
        int substar;

        if (Character.isDigit(digit1) && Character.isDigit(digit2)) {
            star = Character.digit(digit1, DECIMAL_RADIX);
            substar = Character.digit(digit2, DECIMAL_RADIX);
        }
        else {
            star = DEFAULT_RATING;
            substar = DEFAULT_RATING;
        }
        return new FivePointRating(star, substar);
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Rating r) {
        return Double.compare(this.getValue(), r.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FivePointRating that = (FivePointRating) o;
        return Double.compare(value, that.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private FivePointRating(int star, int substar) {
        value = star + ((double) substar / 10);
    }
}
