package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {
    public static int[] topK(int[] array,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k){
                maxHeap.offer(array[i]);
            }else {
                int top = maxHeap.peek();
                if(top > array[i]){
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = maxHeap.poll();
        }
        return tmp;


    }

    public static void main(String[] args) {
        int[] array = {18,21,8,10,34,12};
        int[] ret = topK(array,3);
        System.out.println(Arrays.toString(ret));
    }
}
