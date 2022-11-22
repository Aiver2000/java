package thread;

public class Demo11 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("这是收尾工作！");
                    break;
                }
            }
        });
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
