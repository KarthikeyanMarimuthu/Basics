package com.basicSynchronisation;

import java.util.Date;

public class SynchronisationBlock {

        public static int counter1 = 0;
        public static int counter2 = 0;


        // Monitor Objects
        public static final Object lock1= new Object();
        public static final Object lock2= new Object();


        public static void main(String[] args) {

        {


            Thread t1 = new Thread (() ->{

                increment1();
            });

            Thread t2 = new Thread( () ->{

                increment2();
            });

            t1.start();
            t2.start();
            System.out.println(new Date());

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(counter1 + "  "+ counter2);
            System.out.println(new Date());

        }

    }
        private static void increment1(){

            // Synchronised Block
            synchronized (lock1){
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 1");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    counter1++;
                }
            }
    }


        private static void increment2(){

        // Synchronised Block
        synchronized (lock2){
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter2++;
            }
        }

    }

        // This 2 threads which doesn't invoke the same synchronised method will not run parallel,
        // bcoz first thread will acquire lock in whole CLass object level
    }
