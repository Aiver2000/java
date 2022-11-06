package Heap;

import java.util.Arrays;

public class myheap {
    public int[] elem;
    public int usedSize;
    public myheap(){
        this.elem = new int[10];
    }


    public void shiftDown(int parent,int len){
        int child = 2*parent+1;
        while(child<len){
            if( child+1 < len &&elem[child] < elem[child+1]){
                child++;
            }
            if(elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }
    public void createHeap(int[] array){
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
        for (int parent = ((usedSize-1)-1)/2; parent >= 0; parent--) {
            shiftDown(parent,usedSize);
        }

    }

    private void shiftUp(int child){
        int parent = (child-1)/2;
        while(child>0){
            if(elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (parent-1)/2;
            }else {
                break;
            }
        }
    }

    public void offer(int val){
        if(isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++] = val;
        shiftUp(usedSize-1);

    }

    public boolean isFull(){
        return usedSize == elem.length;
    }

    public int poll(){
        if(isEmpty()){
            throw  new RuntimeException("优先级队列为空!");
        }
        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = tmp;
        usedSize--;
        shiftDown(0,usedSize);
        return tmp;
    }
    public boolean isEmpty(){
        return usedSize == 0;
    }

    public int peek(){
        if(isEmpty()){
            throw  new RuntimeException("优先级队列为空!");
        }
        return elem[0];
    }

}
