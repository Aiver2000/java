
class LNode{
    public int val;
    public LNode next;
    public LNode prev;
    public LNode(int val){
        this.val = val;
    }
}

public class DoubleLinkedList {
    public LNode head;
    public LNode last;

    public void display(){
        LNode cur = head;
        while (cur!=null){
            System.out.print(cur.val);
            cur=cur.next;
        }
        System.out.println();
    }
    public int size(){
        LNode cur = head;
        int size = 0;
        while (cur != null){
            size++;
            cur = cur.next;
        }
        return size;

    }
    public boolean contains(int key){
        LNode cur = head;
        while (cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void addFirst(int data){
        LNode node = new LNode(data);
        if(head==null){
            head = last = node;
        }else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
    public void addLast(int data){
        LNode node = new LNode(data);
        if(head == null){
            head=last=node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }
    public void remove(int key){
        LNode cur = head;
        while (cur != null){
            if(cur.val == key){
                if(cur == head){
                    head=head.next;
                    if(head !=null){
                        head.prev = null;
                    }else {
                        last =null;
                    }
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev = cur.prev;
                    }else{
                        last=last.prev;
                    }
                }
                return;
            }else{
                cur=cur.next;
            }
        }

    }
    public void removeAllKey(int key){
        LNode cur = head;
        while (cur != null){
            if(cur.val == key){
                if(cur == head){
                    head=head.next;
                    if(head !=null){
                        head.prev = null;
                    }else {
                        last =null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        last = last.prev;
                    }
                }
            }else{
                cur=cur.next;
            }
        }
    }

    public LNode searchIndex(int index){
        if(index<0 || index>size()){
            System.out.println("非法下标");
            return null;
        }
        LNode cur = head;
        while (index>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data){
        LNode node = new LNode(data);
        LNode cur = head;
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        cur = searchIndex(index);
        node.next=cur;
        cur.prev.next=node;
        node.prev=cur.prev;
        cur.prev=node;
    }

    /*public void clear(){
        LNode cur = head;
        LNode curNext = head;
        while (cur!=null){
            curNext = curNext.next;
            cur.next = null;
            cur.prev = null;
            cur = curNext;
        }
        head = null;
        last = null;

    }*/
    public void clear(){
        while (head!=null){
            LNode curNext = head.next;
            head.prev=null;
            head.next = null;
            head = curNext;
        }
        last=null;
    }







}
