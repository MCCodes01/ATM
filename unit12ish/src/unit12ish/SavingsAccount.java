package unit12ish;

//SavingsAccount.java

/**
 * This class extends account class to add interest feature
 */
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    @Override
    public void credit(double amount) {
        super.credit(amount + calculateInterest());
    }

    // calculates interest on current balance
    public double calculateInterest() {
        return (balance * interestRate) / 100.0;
    }

    public double getInterestRate() {
        return interestRate;
    }
}