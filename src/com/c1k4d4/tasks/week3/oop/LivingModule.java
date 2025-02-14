package com.c1k4d4.tasks.week3.oop;

public abstract class LivingModule {
    int number;

    public LivingModule(int number) {
        setNumber(number);
    }

    protected void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void print() {
        System.out.println(this);
    }

}
