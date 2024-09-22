package com.basicMultiThreading;

public class DaemonThreads {


    public static void main(String[] args) {


        Thread t1 = new Thread( () -> {

            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });

        Thread t2 = new Thread( () -> {

            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });

        t1.setDaemon(true);
        t2.setDaemon(true);


        t1.start();
        t2.start();


        System.out.println("Main Process exits");
    }
}
