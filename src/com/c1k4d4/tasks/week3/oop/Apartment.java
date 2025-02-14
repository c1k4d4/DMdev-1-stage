package com.c1k4d4.tasks.week3.oop;

public class Apartment extends LivingModule {
    private Room[] rooms;

    public Apartment(int number, Room[] rooms) {
        super(number);
        setRooms(rooms);
    }

    private void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return String.format("Квартира %d, кол-во комнат %d", getNumber(), getRooms().length);
    }
}
