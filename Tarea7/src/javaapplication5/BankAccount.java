package javaapplication5;

public class BankAccount {

    private long accountNumber;
    private double amount;

    public BankAccount(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountInfo() {
        return String.format("Número de cuenta: %d, Saldo: %.2f", this.getAccountNumber(), this.getAmount());
    }
}
