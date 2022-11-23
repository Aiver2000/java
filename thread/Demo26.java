package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool{
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    static class Worker extends Thread{
        private BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private List<Thread> workers = new ArrayList<>();
    public MyThreadPool(int n ){
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker(queue);
            worker.start();
            workers.add(worker);
        }
    }

    public void submit(Runnable runnable){
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
public class Demo26 {
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(10);
        for (int i = 0; i < 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello thread pool");
                }
            });
        }

    }

}
