package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account account = new Account(1001, "Alex", 1000.00);

        BusinessAccount businessAccount = new BusinessAccount(1002, "Maria", 1000.00, 500.00);

        // Upcasting
        Account account2 = businessAccount;
        Account account3 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account account4 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // Downcasting

        BusinessAccount account5 = (BusinessAccount) account2;
        account5.loan(100.00);

        // BusinessAccount account6 = (BusinessAccount) account4;

        if (account4 instanceof BusinessAccount) {
            BusinessAccount account6 = (BusinessAccount) account4;
            account6.loan(100.00);
            System.out.println("Loan!");
        }

        if (account4 instanceof SavingsAccount) {
            SavingsAccount account6 = (SavingsAccount) account4;
            account6.updateBalance();
            System.out.println("Updated balance!");
        }

        // Sobreposição/Sobrescrita

        account.withdraw(200.00);
        System.out.println(account.getBalance());
        Account savingsAccount = new SavingsAccount(1005, "John", 1000.00, 0.01);
        savingsAccount.withdraw(200.00);
        System.out.println(savingsAccount.getBalance());
        businessAccount.withdraw(200.00);
        System.out.println(businessAccount.getBalance());

        // Polimorfismo

        Account x = new Account(1020, "Rafael", 1000.00);
        Account y = new SavingsAccount(1023, "Beatriz", 1000.00, 0.01);

        x.withdraw(50.00);
        y.withdraw(50.00);

        System.out.println("---------Polimorfismo-----------");
        System.out.println(x.getBalance());
        System.out.println(y.getBalance());

    }
}