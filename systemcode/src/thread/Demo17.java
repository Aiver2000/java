package thread;

public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized(object) {
            System.out.println("wait前");
            object.wait();
            System.out.println("wait后");
        }


    }
}
