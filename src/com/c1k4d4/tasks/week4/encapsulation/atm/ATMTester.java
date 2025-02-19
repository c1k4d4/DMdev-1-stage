package com.c1k4d4.tasks.week4.encapsulation.atm;

public class ATMTester {

    private static final String MSG_ATM_STATE =
            "Остаток денег в банкомате: %d, купюр10: %d, купюр20: %d, купюр50: %d\n";


    public static void runPositiveTest1() {
        /*
         * Через конструктор поступает 800$, через deposit() 3200$
         * снимается 3091$ (1$ отлетает как "комиссия"; т.е. всё что меньше 10)
         */

        ATM atm = new ATM(10, 10, 10);
        atm.deposit(40, 40, 40);
        atm.withdraw(3091);
        printAtmState(atm);
    }

    public static void runPositiveTest2() {
        /*
         * Через конструктор поступает 0$, через deposit() 4000$
         * снимается 4000$
         */

        ATM atm = new ATM();
        atm.deposit(50, 50, 50);
        atm.withdraw(4000);
        printAtmState(atm);
    }

    public static void runNegativeTest1() {
        /*
         * попытка снять больше, чем имеется в банкомате
         * -в банкомате: cashStock = 4000$
         * -попытка снять 5000$ через withdraw()
         */

        ATM atm = new ATM(50, 50, 50);
        atm.withdraw(5000);
        printAtmState(atm);
    }

    public static void runNegativeTest2() {
        /*
         * денег в банкомате хватает, не хватает размена (только крупные купюры)
         * -в банкомате нет купюр по 10;
         * -попытка снять сумму, не кратную 50 и/или 20 (например, 2010$)
         */

        ATM atm = new ATM(0, 50, 50);
        atm.withdraw(2010);
        printAtmState(atm);
    }

    //для отладки
    public static void printAtmState(ATM atm) {
        System.out.printf(MSG_ATM_STATE,
                atm.getCashStock(),
                atm.getBanknoteStock10(),
                atm.getBanknoteStock20(),
                atm.getBanknoteStock50()
        );
    }
}