package unit12ish;

//CheckingAccount.java

public class CheckingAccount extends Account {
    private double feePerTransaction;

    public CheckingAccount(double balance, double feePerTransaction) {
        this.balance = balance;
        this.feePerTransaction = feePerTransaction;
    }

    @Override
    public void credit(double amount) {
        // check if amount is greater than 0
        // if it is check amount + balance is greater than fee of transaction
        if (amount > 0 && amount + balance >= feePerTransaction) {
            balance += amount;
            balance -= feePerTransaction;
        }
    }

    @Override
    public void debit(double amount) {
        // check if amount is greater than 0 if it is check
        // the transaction fee and amount both should be less than or
        // equal to balance from which they are being debited
        if (amount > 0 && balance - amount - feePerTransaction >= 0) {
            balance -= amount;
            balance -= feePerTransaction;
        }
    }

    public double getFeePerTransaction() {
        return feePerTransaction;
    }
}