package thread;

public class Demo7 {
    private static final long count = 10_0000_0000;
    public static void serial(){
        long beg = System.currentTimeMillis();
        long a = 0;
        for (long i = 0;i<count;i++){
            a++;
        }
        long b = 0;
        for(long i = 0;i<count;i++){
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间: "+(end-beg) + "ms");
    }


    public static void concurrency() throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            long a = 0;
            for(long i = 0;i<count;i++){
                a++;
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
           long b = 0;
           for(long i = 0;i<count;i++){
               b++;
           }
        });
        t2.start();

        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("消耗时间： " +(end-beg) +" ms");
    }


    public static void main(String[] args) throws InterruptedException {
        serial();
        concurrency();
    }
}
