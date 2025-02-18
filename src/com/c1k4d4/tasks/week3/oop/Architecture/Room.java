package com.c1k4d4.tasks.week3.oop.Architecture;

public class Room {
    boolean isWalkTrough;

    public Room(boolean isWalkTrough) {
        setIsWalkTrough(isWalkTrough);
    }

    private void setIsWalkTrough(boolean isWalkTrough) {
        this.isWalkTrough = isWalkTrough;
    }

    public boolean getIsWalkTrough() {
        return isWalkTrough;
    }

    @Override
    public String toString() {
        return String.format("Комната проходная: %b", getIsWalkTrough());
    }

    public void print() {
        System.out.println(this);
    }
}
