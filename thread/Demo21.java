package thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo21 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.put("hello");
        String s = queue.take();


    }
}
