package com.basicMultiThreading;

public class ThreadPriority {


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());
    }


    // By default the Main Thread will have NORM priority
    // If a new a Thread is created it will inherit the priority of its parent thread.
    // MAX priority threads will get scheduled first by JVM and will get more CPU time
}
