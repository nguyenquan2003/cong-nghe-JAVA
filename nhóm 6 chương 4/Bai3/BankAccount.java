/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3;

/**
 *
 * @author ADMIN
 */
public class BankAccount {
   private int balance;
    private String accountName;

    public BankAccount(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public String getAccountName() {
        return accountName;
    }
}
