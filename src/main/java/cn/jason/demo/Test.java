package cn.jason.demo;


import java.util.concurrent.*;

public class Test {
    private int data = 0;

    public void add1() {
        data++;
    }

    public synchronized void add2() {
        data++;
    }

    public void print() {
        System.out.println(data);
    }

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 200;
        final CountDownLatch cdl = new CountDownLatch(threadCount);
        final Test t = new Test();
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t.add2();
                    cdl.countDown();
                }
            }).start();
        }
        cdl.await();
        t.print();
        System.out.println("");
    }

}
