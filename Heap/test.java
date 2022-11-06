package Heap;

import java.util.PriorityQueue;

public class test {
    public static void main1(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(12);
        priorityQueue.offer(9);
        priorityQueue.offer(99);
        priorityQueue.offer(1);





    }
    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        myheap myheap = new myheap();
        myheap.createHeap(array);
        myheap.offer(99);
        System.out.println(myheap.poll());
    }
}
