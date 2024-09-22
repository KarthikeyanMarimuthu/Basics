package com.basicSynchronisation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProducerConsumer {


    public static void main(String[] args) {



        Worker worker = new Worker(5,0, 0.25F);
        Thread t1 = new Thread( () ->{
            try {
                worker.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread( () ->{
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

    }
}


class Worker{
    int top ;
    int bottom;
    List<Integer> container;
    int count = 0;
    private static final Object LOCK = new Object();
    Date date ;
    float workingHours;


    public Worker(int top, int bottom, float workingHours){
        this.date = new Date();
        this.top = top;
        this.bottom = bottom;
        this.container = new ArrayList<>();
        this.workingHours = workingHours * 60 * 60 * 1000;

    }


    public void produce() throws InterruptedException {
        synchronized (LOCK){
            while(new Date().getTime() - this.date.getTime() < workingHours){
                if(container.size() == top){
                    System.out.println("Container is full Production going to wait");
                    LOCK.wait();
                }
                else{
                    System.out.println("Adding item in the Container");
                    container.add(count++);

                    // This notify will be effective when the above thread gets the Wait.
                    LOCK.notify();
                }
                Thread.sleep(500);
            }
            System.out.println("Working hours 15 minutes Completed");
            LOCK.notifyAll();
        }

    }

    public void consume() throws InterruptedException {
        synchronized (LOCK){
            while(new Date().getTime() - this.date.getTime() < workingHours){
                if(container.size() == bottom){
                    System.out.println("Container is empty Consumption is going to wait until there is any item");
                    LOCK.wait();
                }
                else{
                    System.out.println("Getting the item from the Container");
                    container.removeFirst();

                    // This notify will be effective when the above thread gets the Wait.
                    LOCK.notify();
                }
                Thread.sleep(500);
            }
            System.out.println("Working hours 15 minutes Completed");
            LOCK.notifyAll();
        }

    }



}