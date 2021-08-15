package com.cnkonica.example.biz.test.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) throws Exception{
        final int max = 10;
        final int loopCount = 100000;
        long costTime = 0;
        final AtomicInteger value1 = new AtomicInteger(0);
        for (int m = 0; m < max; m++) {
            long start1 = System.nanoTime();
            Thread[] ts = new Thread[max];
            for(int i=0;i<max;i++) {
                ts[i] = new Thread() {
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {
                            value1.incrementAndGet();
                        }
                    }
                };
            }
            for(Thread t:ts) {
                t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        System.out.println("cost1: " + (costTime) + ":" + value1);
        //
        System.out.println();
        costTime = 0;
        //
        Object lock = new Object();
        for (int m = 0; m < max; m++) {
            long start1 = System.nanoTime();
            Thread[] ts = new Thread[max];
            for(int i=0;i<max;i++) {
                ts[i] = new Thread() {
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {
                            synchronized(lock) {
                                ++staticValue;
                            }
                        }
                    }
                };
            }
            for(Thread t:ts) {
                t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        //
        System.out.println("cost2: " + (costTime) + ":" + staticValue);

        costTime = 0;
        Lock lock1 = new ReentrantLock();
        for (int m = 0; m < max; m++) {
            long start1 = System.nanoTime();
            Thread[] ts = new Thread[max];

            for(int i=0;i<max;i++) {
                ts[i] = new Thread() {
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {

                                lock1.lock();
                            try{
                                ++number;
                            }finally {
                                lock1.unlock();
                            }
                        }
                    }
                };
            }
            for(Thread t:ts) {
                t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        System.out.println("cost3: " + (costTime) + ":" + number);
        //
        System.out.println();
    }
    static int staticValue = 0;
    static int number =0;

}
