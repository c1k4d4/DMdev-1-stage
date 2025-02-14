package com.c1k4d4.tasks.week3.oop;

import com.c1k4d4.tasks.week3.oop.Apartment;
import com.c1k4d4.tasks.week3.oop.LivingModule;

;

public class Storey extends LivingModule {
    private Apartment[] apartments;

    public Storey(int number, Apartment[] apartments) {
        super(number);
        setApartments(apartments);
    }

    private void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    @Override
    public String toString() {
        return String.format("Этаж %d, кол-во квартир %d", getNumber(), getApartments().length);
    }
}
