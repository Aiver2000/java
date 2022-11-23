package thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo28 {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();

        locker.lock();

        locker.unlock();
    }
}
