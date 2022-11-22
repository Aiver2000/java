package thread;

public class Demo18 {
    private static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized(locker){
                System.out.println("wait前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait后");
            }
        });
        t1.start();

        Thread.sleep(3000);

        Thread t2 = new Thread(()->{
            synchronized (locker){
                System.out.println("通知前");
                locker.notify();
                System.out.println("通知后");
            }
        });
        t2.start();
    }
}
