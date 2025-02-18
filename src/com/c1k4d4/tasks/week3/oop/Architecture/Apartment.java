package com.c1k4d4.tasks.week3.oop.Architecture;

public class Apartment {
    private int number;
    private Room[] rooms;

    public Apartment(int number, Room[] rooms) {
        setNumber(number);
        setRooms(rooms);
    }

    public int getNumber() {
        return number;
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return String.format("Квартира %d, кол-во комнат %d", getNumber(), getRooms().length);
    }

    public void print() {
        System.out.println(this);
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}
