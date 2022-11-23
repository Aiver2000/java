package thread;

class Counter{
    public int count;
    synchronized public void increase(){
        synchronized (this){
            count++;
        }
    }
}
public class Demo15 {
    private static Counter counter = new Counter();
    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(()->{
           for (int i = 0;i<50000;i++){
               counter.increase();
           }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0;i<50000;i++){
                counter.increase();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.count);

    }
}
