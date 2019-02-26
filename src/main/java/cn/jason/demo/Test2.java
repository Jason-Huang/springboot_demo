package cn.jason.demo;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test2 {

    private int data = 0;
    private AtomicInteger aiData = new AtomicInteger();

    public Test2() {
    }

//    public void add1() {
//        data++;
//    }

    public synchronized void add2() {
        aiData.getAndIncrement();
    }

    public void print() {
        System.out.println("===========================================================================================" + aiData.intValue());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-thread-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(10, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(20));

        int threadCount = 2000;
        final Test2 t = new Test2();
        for (int i = 0; i < threadCount; i++) {
            singleThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                t.add2();
            });
        }
        Thread.sleep(2000);
        singleThreadPool.shutdown();
        t.print();
    }

}
