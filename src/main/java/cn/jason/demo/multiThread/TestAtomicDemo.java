package cn.jason.demo.multiThread;

/**
 * @author huangcheng
 */
public class TestAtomicDemo {
    public static void main(String[] args) {

        LongAdderDemo lad = new LongAdderDemo();
        AtomicDemo ad = new AtomicDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
            new Thread(lad).start();
        }
    }
}