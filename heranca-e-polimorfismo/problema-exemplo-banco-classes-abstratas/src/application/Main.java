package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
        accounts.add(new BusinessAccount(1002, "Bob", 1000.00, 400.00));
        accounts.add(new SavingsAccount(1003, "Bob", 300.00, 0.01));
        accounts.add(new BusinessAccount(1004, "Bob", 500.00, 500.00));

        double sum = 0.0;
        for (Account account : accounts) {
            sum += account.getBalance();
        }

        System.out.println("Total balance: " + String.format("%.2f", sum));

        for (Account account : accounts) {
            account.deposit(10);
        }

        for (Account account : accounts) {
            System.out.println("Updated account " + account.getNumber() + " balance: " + String.format("%.2f", account.getBalance()));
        }

    }
}