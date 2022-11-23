package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo27 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num = new AtomicInteger(0);

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5_0000; i++) {
                num.getAndIncrement();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5_0000; i++) {
                num.getAndIncrement();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(num.get());

    }
}
