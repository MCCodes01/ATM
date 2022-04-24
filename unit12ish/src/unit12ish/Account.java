package unit12ish;

//Account.java

/**
 * This class implements basic properties of account
 * such as credit, debit and initialization
 */
public abstract class Account {
    protected double balance;

    /**
     * Getters and setters for balance
     */
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * This method adds amount to balance if valid
     */
    public void credit(double amount) {
        if (isValidAmount(amount)) {
            balance += amount;
        }
    }

    /**
     * This method subtracts amount from balance if valid
     */
    public void debit(double amount) {
        if (isValidAmount(amount) && amount <= balance) {
            balance -= amount;
        }
    }

    private boolean isValidAmount(double amount) {
        return amount >= 0;
    }
}

