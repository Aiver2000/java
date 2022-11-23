package thread;

import java.util.Queue;

class MyBlockingQueue{
    private int[] data = new int[1000];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    private Object locker = new Object();

    public void put(int value) throws InterruptedException {
        synchronized(locker){
            if(size == data.length){
                locker.wait();
            }
            data[tail] = value;
            tail++;
            if(tail>=data.length){
                tail = 0;
            }
            //tail = tail % data.length; 1.可读性稍差  2.%操作相对于比较 对于计算机开销更大~
            size++;
            locker.notify();
        }

    }
    public Integer take() throws InterruptedException {
        synchronized (locker){
            if(size == 0){
                locker.wait();
            }
            int ret = data[head];
            head++;
            if(head >= data.length){
                head = 0;
            }
            size--;
            locker.notify();
            return ret;
        }
    }
}
public class Demo22 {
    private static MyBlockingQueue queue = new MyBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(()->{
            int num = 0;
            while (true){
                try {
                    System.out.println("生产了："+num);
                    queue.put(num);
                    num++;
                    //Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();

        Thread customer = new Thread(()->{
           while (true){
               try {
                   int num = queue.take();
                   System.out.println("消费者："+num);
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        customer.start();
    }
}
