package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo25 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello threadpool");
                }
            });
        }

    }


}
