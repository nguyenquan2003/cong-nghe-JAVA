/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author ADMIN
 */
public class TransferThread extends Thread {
    private BankAccount fromAccount;
    private BankAccount toAccount;
    private int amount;
    private static Lock lock = new ReentrantLock();

    public TransferThread(String name, BankAccount fromAccount, BankAccount toAccount, int amount) {
        super(name);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Chuyen khoan " + amount + " tu tai khoan "
                    + fromAccount.getAccountName() + " den tai khoan " + toAccount.getAccountName());
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Tong tien trong ngan hang: " + Bank.getTotalBalance());
        } finally {
            lock.unlock();
        }
    }
}
