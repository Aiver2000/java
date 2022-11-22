package thread;

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("hello");
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
