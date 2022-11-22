package thread;

public class Demo13 {
    public static void main(String[] args) {
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//                //System.out.println(Thread.currentThread().getName());
//                System.out.println(this.getName());
//            }
//        };
//        t.start();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run(){
                //System.out.println(this.);
                Thread.currentThread().getName();
            }
        });
        System.out.println(Thread.currentThread().getName());
    }
}
