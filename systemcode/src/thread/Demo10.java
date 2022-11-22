package thread;

public class Demo10 {
    private static boolean isQuit = false;

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while (!isQuit) {
                System.out.println("hello thread!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isQuit = true;
        System.out.println("终止t线程");

    }
}
