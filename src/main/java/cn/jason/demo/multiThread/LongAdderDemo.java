package cn.jason.demo.multiThread;

import java.util.concurrent.atomic.LongAdder;

class LongAdderDemo implements Runnable {
    //    private int serialNumber = 0;
//    private AtomicInteger serialNumber = new AtomicInteger();
    private LongAdder la = new LongAdder();

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber() {
//        return serialNumber++;
        // 自增运算
        // return serialNumber.getAndIncrement();
        la.increment();
        return la.intValue();
    }
}