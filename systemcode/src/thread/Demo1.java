package thread;

class Mythread extends Thread{
    @Override
    public void run() {
        System.out.println("hello thread");
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Thread t = new Mythread();
        t.start();
    }
}
