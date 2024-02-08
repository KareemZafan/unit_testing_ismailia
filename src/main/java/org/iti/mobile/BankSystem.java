package org.iti.mobile;

import java.math.BigDecimal;

public class BankSystem {

    private BigDecimal balance;

    public BankSystem() {
        balance = new BigDecimal(3000);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BankSystem(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getGetBalance() {
        return balance;
    }

    public void deposit(double value){
        balance = BigDecimal.valueOf(value + balance.doubleValue());
    }

    public void withdraw(double value){
        balance = BigDecimal.valueOf( balance.doubleValue() - value);
    }
}
