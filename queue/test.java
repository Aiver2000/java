package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class test {

    public static void main(String[] args) {
        myqueue myqueue = new myqueue();
        myqueue.offer(1);
        myqueue.offer(2);
        myqueue.offer(3);
        System.out.println(myqueue.peek());
        myqueue.poll();
        myqueue.poll();
        System.out.println(myqueue.peek());

        //myqueue.poll();
        System.out.println(myqueue.peek());

        //myqueue.poll();


    }

    public static void main2(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        deque.offerFirst(2);
        System.out.println(deque.peekLast());

    }

    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

    }

}
