/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chuong4_bai1;


public class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", Number: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        
        Thread thread1 = new Thread(myThread1);
        thread1.setName("Thread 1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        // khởi tao
        Thread thread2 = new Thread(myThread1);
        thread2.setName("Thread 2");
        thread2.setPriority(Thread.MIN_PRIORITY);
        //start
        thread1.start();
        thread2.start();
    }
    
}
