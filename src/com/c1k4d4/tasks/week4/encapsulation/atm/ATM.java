package com.c1k4d4.tasks.week4.encapsulation.atm;

public class ATM {

    private static final int DENOMINATION_TEN = 10;
    private static final int DENOMINATION_TWENTY = 20;
    private static final int DENOMINATION_FIFTY = 50;
    private static final int TENS_INDEX = 0;
    private static final int TWENTIES_INDEX = 1;
    private static final int FIFTIES_INDEX = 2;


    private static final String MSG_NOT_ENOUGH_MONEY = "Причина: слишком большая сумма.\n";
    private static final String MSG_NO_CHANGE_NOTES = "Причина: нет купюр для размена.\n";
    private static final String MSG_WITHDRAWAL_IS_NOT_POSSIBLE =
            "Банкомат не может выдать " +
            "вам нужную сумму, приносим извиниения.\n";
    private static final String MSG_SUCCESS_WITHDRAWAL =
            "Сумма выдачи: %d. " +
            "Выдано купюр по 10: %d, " +
            "купюр по 20: %d, " +
            "купюр по 50: %d. " +
            "Коммиссия составила: %d\n";

    private int banknoteStock10;
    private int banknoteStock20;
    private int banknoteStock50;
    private int cashStock;

    public ATM(int banknoteStock10, int banknoteStock20, int banknoteStock50) {
        this.banknoteStock10 = validateAmount(banknoteStock10);
        this.banknoteStock20 = validateAmount(banknoteStock20);
        this.banknoteStock50 = validateAmount(banknoteStock50);
        calculateCashStock();
    }

    public ATM() {
        this(0, 0, 0);
    }

    public void deposit(int amountOf10, int amountOf20, int amountOf50) {
        addBanknote10(amountOf10);
        addBanknote20(amountOf20);
        addBanknote50(amountOf50);
        calculateCashStock();
    }

    public boolean withdraw(int withdrawSum) {
        //всё что меньше 10 уходит на комиссию банку
        int commission = withdrawSum % DENOMINATION_TEN;
        withdrawSum -= commission;

        //расчет: хватает ли денег в банкомате
        if (withdrawSum > cashStock) {
            System.out.print(MSG_WITHDRAWAL_IS_NOT_POSSIBLE + MSG_NOT_ENOUGH_MONEY);
            return false;
        }

        //рассчитать набор банкнот для выдачи (-1 если выдать не получится)
        int[] banknotes = getSetOfBanknotes(withdrawSum);
        if (banknotes[TENS_INDEX] == -1) {
            return false;
        }
        else {
            System.out.printf(MSG_SUCCESS_WITHDRAWAL,
                    withdrawSum,
                    banknotes[TENS_INDEX],
                    banknotes[TWENTIES_INDEX],
                    banknotes[FIFTIES_INDEX],
                    commission
            );
            pullBanknotes(banknotes[TENS_INDEX], banknotes[TWENTIES_INDEX], banknotes[FIFTIES_INDEX]);
            return true;
        }
    }

    private int[] getSetOfBanknotes(int exchangeAmount) {
        int[] banknotes = { 0, 0, 0 };

        banknotes[FIFTIES_INDEX] = exchangeAmount / DENOMINATION_FIFTY;
        if (banknoteStock50 < banknotes[FIFTIES_INDEX]) {
            banknotes[FIFTIES_INDEX] = banknoteStock50;
        }
        exchangeAmount -= banknotes[FIFTIES_INDEX] * DENOMINATION_FIFTY;
        if (exchangeAmount == 0) {
            return banknotes;
        }

        banknotes[TWENTIES_INDEX] = exchangeAmount / DENOMINATION_TWENTY;
        if (banknoteStock20 < banknotes[TWENTIES_INDEX]) {
            banknotes[TWENTIES_INDEX] = banknoteStock20;
        }
        exchangeAmount -= banknotes[TWENTIES_INDEX] * DENOMINATION_TWENTY;
        if (exchangeAmount == 0) {
            return banknotes;
        }

        banknotes[TENS_INDEX] = exchangeAmount / DENOMINATION_TEN;
        if (banknoteStock10 < banknotes[TENS_INDEX]) {
            System.out.print(MSG_WITHDRAWAL_IS_NOT_POSSIBLE + MSG_NO_CHANGE_NOTES);
            return new int[]{ -1, -1, -1 };
        }
        return banknotes;
    }

    private void pullBanknotes(int amountOf10, int amountOf20, int amountOf50) {
        banknoteStock50 -= amountOf50;
        banknoteStock20 -= amountOf20;
        banknoteStock10 -= amountOf10;
        calculateCashStock();
    }

    private void addBanknote10(int amount) {
        banknoteStock10 += validateAmount(amount);
    }

    private void addBanknote20(int amount) {
        banknoteStock20 += validateAmount(amount);
    }

    private void addBanknote50(int amount) {
        banknoteStock50 += validateAmount(amount);
    }

    private int validateAmount(int amount) {
        return amount > 0 ? amount : 0;
    }

    private void calculateCashStock() {
        cashStock = banknoteStock10 * DENOMINATION_TEN;
        cashStock += banknoteStock20 * DENOMINATION_TWENTY;
        cashStock += banknoteStock50 * DENOMINATION_FIFTY;
    }

    int getBanknoteStock10() {
        return banknoteStock10;
    }

    int getBanknoteStock20() {
        return banknoteStock20;
    }

    int getBanknoteStock50() {
        return banknoteStock50;
    }

    int getCashStock() {
        return cashStock;
    }
}
