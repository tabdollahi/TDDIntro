package com.thoughtworks.tddintro.accountbalance;

public class Account {
    private int balance;

    Account(int balance){
        this.balance = balance;
    }

    public int deposit(int amount){
        balance += amount;
        return balance;
    }

    public int withdraw(int amount){
        int newBalance = balance - amount;
        if (newBalance > 0){
            balance = newBalance;
        }
        return balance;
    }
}
