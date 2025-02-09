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
    private static double expenses = 300.0;
    private static double salaryIncrease = 400.0;
    private static int increaseSalaryPeriod = 6;
    private static int investmentPeriod = 38;
    private static double savingPercentage = 0.1;
    private static double incomePercentage = 1.02;

    public static void main(String[] args) {
        System.out.print("Заработано за " + investmentPeriod + " месяцев: " + calculate());
    }

    private static double calculate() {
        for (int i = 1; i <= investmentPeriod; i++) {
            if (i % increaseSalaryPeriod == 0) raiseSalary();
            getIncomeFromInvestments();
            putInBank(currentSalary - expenses);
            invest(currentSalary * savingPercentage);
//            System.out.println(i + ". Баланс в банке: " + bankBalance);
//            System.out.println(i + ". Баланс на брокерск. счете: " + brokerBalance);
        }
        return bankBalance + brokerBalance;
    }

    private static void raiseSalary() {
        currentSalary += salaryIncrease;
    }

    private static void putInBank(double sum) {
        bankBalance += sum;
    }

    private static void invest(double sum) {
        brokerBalance += sum;
        bankBalance -= sum;
    }

    private static void getIncomeFromInvestments() {
        brokerBalance *= incomePercentage;
    }

}
