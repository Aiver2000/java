package queue;

class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }
}
public class myqueue {
    public Node head;
    public Node last;

    public void offer(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            last = node;
        }
        last.next = node;
        last =last.next;
    }

    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int oldVal = head.val;
        head = head.next;
        return oldVal;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return head.val;
    }

}
