package com.basicMultiThreading;


public class RunnableThreadExample {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadOne());

        Thread t2 = new Thread(new ThreadTwo());

        Thread t3 = new Thread(() -> {
            for( int i = 0; i< 5; i++){
                System.out.println("Thread 3 is printing "+ i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }


}


class ThreadOne implements Runnable {


    @Override
    public void run() {

        for( int i = 0; i< 5; i++){
            System.out.println("Thread 1 is printing "+ i);
        }
    }
}


class ThreadTwo implements Runnable {


    @Override
    public void run() {
        for( int i = 0; i< 5; i++){
            System.out.println("Thread 2 is printing "+ i);
        }
    }
}