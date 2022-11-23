package thread;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

class MyTask implements Comparable<MyTask> {
    private Runnable runnable;
    private long time;

    public MyTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis()+delay;
    }

    public void run(){
        runnable.run();
    }

    public long getTime(){
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int)(this.time-o.time);
    }
}

class MyTimer{
    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    public void schedule(Runnable runnable,long delay){
        MyTask task = new MyTask(runnable,delay);
        queue.put(task);
        synchronized (locker){
            locker.notify();
        }
    }

    private Object locker = new Object();
    public MyTimer(){
        Thread thread = new Thread(()->{
            while (true){
                try {
                    MyTask task = queue.take();
                    long curTime = System.currentTimeMillis();
                    if(curTime<task.getTime()){
                        queue.put(task);
                        synchronized (locker){
                            locker.wait(task.getTime()-curTime);
                        }
                    }else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}

public class Demo24 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello timer");
            }
        },3000);
        System.out.println("main");
    }

}
