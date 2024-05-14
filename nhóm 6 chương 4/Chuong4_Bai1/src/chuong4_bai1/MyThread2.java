/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chuong4_bai1;

public class MyThread2 extends Thread {

    private int start;
    private int end;

    public MyThread2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("Thread 1")) {
            System.out.println("Thread 1: Even numbers from " + start + " to " + end);
            for (int i = start; i <= end; i++) {
                if (i % 2 == 0) {
                    System.out.println("Thread 1: " + i);
                }
            }
        } else if (threadName.equals("Thread 2")) {
            System.out.println("Thread 2: Odd numbers from " + start + " to " + end);
            for (int i = start; i <= end; i++) {
                if (i % 2 != 0) {
                    System.out.println("Thread 2: " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread2 thread1 = new MyThread2(1, 10);
        MyThread2 thread2 = new MyThread2(1, 10);

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        try {
            thread1.join(); // Wait for thread1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
