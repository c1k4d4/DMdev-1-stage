package com.c1k4d4.tasks.week3.oop;

public class Building extends LivingModule {
    private Storey[] storeys;

    public Building(int number, Storey[] storeys) {
        super(number);
        setStoreys(storeys);
    }

    private void setStoreys(Storey[] storeys) {
        this.storeys = storeys;
    }

    public Storey[] getStoreys() {
        return storeys;
    }

    @Override
    public String toString() {
        return String.format("Дом %d, кол-во этажей %d", getNumber(), getStoreys().length);
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

}
