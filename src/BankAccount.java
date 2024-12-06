import java.util.ArrayList;
import java.util.List;
class BankAccount {

    private String accountNumber;
    private double balance;
    private boolean isBlocked;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.isBlocked = false;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void deposit(double amount) {
        if (!isBlocked && amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (!isBlocked && amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public void blockAccount() {
        isBlocked = true;
    }

    public void unblockAccount() {
        isBlocked = false;
    }

    public void transferTo(BankAccount recipient, double amount) {
        if (!isBlocked && !recipient.isBlocked() && amount > 0 && balance >= amount) {
            withdraw(amount);
            recipient.deposit(amount);
        }
    }
}

class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    public BankAccount createAccount(String accountNumber, double initialBalance) {
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.add(account);
        return account;
    }

    public void blockAccount(BankAccount account) {
        account.blockAccount();
    }

    public void unblockAccount(BankAccount account) {
        account.unblockAccount();
    }
}
