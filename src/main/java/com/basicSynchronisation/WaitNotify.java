package com.basicSynchronisation;

public class WaitNotify {

    public static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            try {
                method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() ->{
            try {
                method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void method1() throws InterruptedException {

        synchronized (LOCK){

            System.out.println("Hi from Thread 1");
            // Object will tell the current thread to wait.
            LOCK.wait();
            System.out.println("Back again to Thread 1");

        }
    }

    private static void method2() throws InterruptedException {

        synchronized (LOCK){

            System.out.println("Hi from Thread 2");
            // Object will notify other thread once this block of execution completes
            // if notify is not given the Thread one will remain in Wait state.
            LOCK.notify();
            System.out.println("Hello from Thread 2 even after notify... ");

        }
    }
}
