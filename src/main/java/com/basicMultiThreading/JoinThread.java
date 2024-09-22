package com.basicMultiThreading;

public class JoinThread {

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            for (int i = 0; i< 100; i++){
                System.out.println(i);
            }
        });


        Thread t2 = new Thread(() ->{
            for (int i = 0; i< 100; i++){
                System.out.println(i);
            }
        });


        t1.start();
        t2.start();

        // If we want the two threads to complete and execute the rest of the code by Main thread we ne need use join method.


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Thread 1 and 2 finished its executions");
    }
}
