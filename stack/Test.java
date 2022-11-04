package lesson2;

import java.util.Arrays;
import java.util.Stack;

class myStack{
    public int[] elem;
    public int usedSize;
    public myStack(){
        elem = new int[5];
    }

    public void push(int val){
        if(isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++] = val;
    }

    public boolean isFull(){
        return usedSize == elem.length;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，别删");
        }
        usedSize--;
        return elem[usedSize];
    }

    public boolean isEmpty(){
        return usedSize == 0;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("栈空,无值");
        }
        return elem[usedSize-1];
    }




}




public class Test {
    public static void main(String[] args) {
        myStack myStack = new myStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.peek());


    }
}
