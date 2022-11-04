package queue;

public class MyCircularQueue {

    public int[] elem;
    public int front;
    public int rear;

    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        elem[rear] = value;
        rear = (rear+1)%elem.length;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front+1) % elem.length;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return elem[front];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return elem[(rear-1+elem.length)%elem.length];

    }

    public boolean isEmpty() {
        return front == rear;

    }

    public boolean isFull() {
        if((this.rear+1) % elem.length == front){
            return true;
        }
        return false;

    }
}
