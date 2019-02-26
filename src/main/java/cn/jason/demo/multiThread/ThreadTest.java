package cn.jason.demo.multiThread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        lock.unlock();
    }
}
