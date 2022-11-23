package thread;

import java.util.concurrent.CountDownLatch;

public class Demo31 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(()->{
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+" 到达终点！");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }

        latch.await();
        System.out.println("比赛结束!");

    }
}
