package thread;

public class Demo6 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("hello");
        });
        t.start();
    }
}
