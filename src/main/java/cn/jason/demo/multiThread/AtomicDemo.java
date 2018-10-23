package cn.jason.demo.multiThread;

class AtomicDemo implements Runnable {
    private int serialNumber = 0;
//    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber++;
        // 自增运算
        // return serialNumber.getAndIncrement();
    }
}