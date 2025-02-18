package com.c1k4d4.tasks.week3.oop.Architecture;

public class Storey {
    private int number;
    private Apartment[] apartments;

    public Storey(int number, Apartment[] apartments) {
        setNumber(number);
        setApartments(apartments);
    }

    public int getNumber() {
        return number;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    @Override
    public String toString() {
        return String.format("Этаж %d, кол-во квартир %d", getNumber(), getApartments().length);
    }

    public void print() {
        System.out.println(this);
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }
}
