package thread;

public class Demo8 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           while (true){
               System.out.println("hello thread t1");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"thread t1");
        t1.start();

        Thread t2 = new Thread(()->{
            while (true){
                System.out.println("hello thread t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread t2");
        t2.start();
    }
}
