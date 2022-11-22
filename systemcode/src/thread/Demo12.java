package thread;

public class Demo12 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 15; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        try {
            t.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
