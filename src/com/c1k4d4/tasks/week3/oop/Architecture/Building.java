package com.c1k4d4.tasks.week3.oop.Architecture;

public class Building {
    private int number;
    private Storey[] storeys;

    public Building(int number, Storey[] storeys) {
        setNumber(number);
        setStoreys(storeys);
    }

    public int getNumber() {
        return number;
    }

    public Storey[] getStoreys() {
        return storeys;
    }

    @Override
    public String toString() {
        return String.format("Дом %d, кол-во этажей %d", getNumber(), getStoreys().length);
    }

    public void print() {
        System.out.println(this);
    }

    public static void printAllInformation(Building building) {
        building.print();
        for (Storey storey : building.getStoreys()) {
            storey.print();
            for (Apartment apartment : storey.getApartments()) {
                apartment.print();
                for (Room room : apartment.getRooms()) {
                    room.print();
                }
            }
        }
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setStoreys(Storey[] storeys) {
        this.storeys = storeys;
    }
}
