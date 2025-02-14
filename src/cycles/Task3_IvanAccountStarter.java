package cycles;

/*
 * Неделя 2 (Циклы)
 *
 * Задание 3.
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию
 * Junior Java Developer с зарплатой 600$ в месяц. Ему обещали, что будут поднимать
 * зарплату на 400$ каждые 6 месяцев. 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции
 * с доходностью 2% в месяц.
 *
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года
 * и 2 месяца (= 38 месяцев).
 */

public class Task3_IvanAccountStarter {

    private static double bankBalance = 0.0;
    private static double brokerBalance = 0.0;
    private static double currentSalary = 600.0;

    private static final double EXPENSES = 300.0;
    private static final double SALARY_INCREASE = 400.0;
    private static final int INC_SALARY_PERIOD = 6;
    private static final int INVEST_PERIOD = 38;
    private static final double SAVING_PERCENTAGE = 0.1;
    private static final double INCOME_PERCENTAGE = 1.02;

    public static void main(String[] args) {
        System.out.print("Заработано за " + INVEST_PERIOD + " месяцев: " + calculate());
    }

    private static double calculate() {
        for (int i = 1; i <= INVEST_PERIOD; i++) {
            if (i % INC_SALARY_PERIOD == 0) {
                raiseSalary();
            }
            getIncomeFromInvestments();
            putInBank(currentSalary - EXPENSES);
            invest(currentSalary * SAVING_PERCENTAGE);
//            System.out.println(i + ". Баланс в банке: " + bankBalance);
//            System.out.println(i + ". Баланс на брокерск. счете: " + brokerBalance);
        }
        return bankBalance + brokerBalance;
    }

    private static void raiseSalary() {
        currentSalary += SALARY_INCREASE;
    }

    private static void putInBank(double sum) {
        bankBalance += sum;
    }

    private static void invest(double sum) {
        brokerBalance += sum;
        bankBalance -= sum;
    }

    private static void getIncomeFromInvestments() {
        brokerBalance *= INCOME_PERCENTAGE;
    }

}
