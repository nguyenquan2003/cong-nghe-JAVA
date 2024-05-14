/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3;

/**
 *
 * @author ADMIN
 */
public class Bank {
    private static BankAccount[] accounts;

    public static int getTotalBalance() {
        int totalBalance = 0;
        for (BankAccount account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public static void main(String[] args) {
        accounts = new BankAccount[2];
        accounts[0] = new BankAccount("Account1", 1000);
        accounts[1] = new BankAccount("Account2", 2000);

        TransferThread[] threads = new TransferThread[5];
        for (int i = 0; i < threads.length; i++) {
            int fromAccount = i % 2;
            int toAccount = (i + 1) % 2;
            threads[i] = new TransferThread("Thread-" + i, accounts[fromAccount], accounts[toAccount], 100);
            threads[i].start();
        }

        for (TransferThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
