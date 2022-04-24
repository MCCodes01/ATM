package unit12ish;

//Bank.java

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // create dummy accounts
        Account[] accounts = new Account[4];
        accounts[0] = new SavingsAccount(1000, 10);
        accounts[1] = new CheckingAccount(1000, 10);
        accounts[2] = new SavingsAccount(100, 5);
        accounts[3] = new CheckingAccount(500, 50);

        while (true) {
            // display menu
            System.out.println("1. Display accounts information");
            System.out.println("2. Credit");
            System.out.println("3. Debit");
            System.out.println("4. Exit");

            int userChoice = read.nextInt();
            switch (userChoice) {
                case 1:
                    for (Account account : accounts) {
                        displayInfo(account);
                    }
                    break;
                case 2:
                {
                    System.out.println("Enter account number (1-4): ");
                    int accountNumber = read.nextInt();
                    if (accountNumber < 1 || accountNumber > 4) {
                        System.out.println("Error: Invalid account number!");
                    } else {
                        System.out.println("Enter amount to credit: ");
                        double amount = read.nextDouble();
                        accounts[accountNumber - 1].credit(amount);
                        displayInfo(accounts[accountNumber - 1]);
                    }
                }
                    break;
                case 3:
                {
                    System.out.println("Enter account number (1-4): ");
                    int accountNumber = read.nextInt();
                    if (accountNumber < 1 || accountNumber > 4) {
                        System.out.println("Error: Invalid account number!");
                    } else {
                        System.out.println("Enter amount to debit: ");
                        double amount = read.nextDouble();
                        accounts[accountNumber - 1].debit(amount);
                        displayInfo(accounts[accountNumber - 1]);
                    }
                }
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:

            }
        }
    }

    private static void displayInfo(Account account) {
        System.out.println("********************************************");

        System.out.print("Account Type: ");
        if (account instanceof SavingsAccount) {
            System.out.println("Savings Account");
            System.out.println("Interest Rate: " + ((SavingsAccount) account).getInterestRate());
        }
        else {
            System.out.println("Checking Account");
            System.out.println("Fee Per Transaction: " + ((CheckingAccount) account).getFeePerTransaction());
        }

        System.out.println("Balance: " + account.getBalance());

        System.out.println("********************************************");
    }
}