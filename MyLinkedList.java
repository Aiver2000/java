class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    public ListNode head;

    public void createList(){
        ListNode listNode1 = new ListNode(12);
        ListNode listNode2 = new ListNode(22);
        ListNode listNode3 = new ListNode(32);
        ListNode listNode4 = new ListNode(42);
        ListNode listNode5 = new ListNode(52);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        this.head = listNode1;

    }




    public void display(){
        ListNode cur = this.head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display2(ListNode newHead){
        ListNode cur = newHead;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur!=null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while (cur!=null){
            cur = cur.next;
            count++;
        }
        return count;
    }
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(head==null){
            head = node;
        }else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    public ListNode findIndex(int index){
        ListNode cur =this.head;
        while (index-1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data){
        if(index <0 ||index>size()){
            System.out.println("index?????????");
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = findIndex(index);
        node.next = cur.next;
        cur.next=node;
    }

    public ListNode searchPrev(int key){
        ListNode cur = this.head;
        while (cur.next!=null){
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public void remove(int key){
        if(this.head == null){
            System.out.println("??????????????????");
            return;
        }
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        ListNode cur = searchPrev(key);
        if(cur == null){
            System.out.println("???????????????????????????");
            return;
        }
        cur.next=cur.next.next;
    }

    public ListNode removeAllKey(int key){
        if(this.head == null){
            return null;
        }
        ListNode prev = this.head;
        ListNode cur = prev.next;

        while (cur != null){
            if(cur.val == key){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(head.val == key){
            head = head.next;
        }
        return this.head;
    }


    public void clear(){
        //this.head = null;
        while (this.head != null){
            ListNode curNext = head.next;
            head.next = null;
            head = curNext;
        }
    }


    public ListNode reverseList(){
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode curNext = head.next;
        ListNode prev = null;
        while(cur!= null){
            curNext=cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    public ListNode middleNode(){
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast !=null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
            System.out.println();
        }
        return slow;
    }

    public ListNode FindKthToTail(int k) {
        if(head == null || k<=0 ){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(k>1){
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        if(head.next==null){
            return head;
        }
        while (cur != null){
            if(cur.val <x ){
                if(bs==null){
                    bs=be=cur;
                }else {
                    be.next=cur;
                    be = cur;
                }
            }else {
                if(as == null){
                    as = ae = cur;
                }else {
                    ae.next = cur;
                    ae=cur;
                }
            }
            cur = cur.next;
        }
        if(bs == null){
            return as;
        }else{

            be.next=as;
            if(ae!=null){
                ae.next=null;
            }
            return bs;
        }
    }

    public ListNode deleteDuplication(){
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null){
            if(cur.next!= null && cur.val == cur.next.val) {
                while (cur.next!=null&&cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur=cur.next;
            }else {
                tmp.next=cur;
                cur =cur.next;
                tmp=tmp.next;
            }

        }
        tmp.next=null;
        return newHead.next;

    }
    public boolean chkPalindrome() {
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = slow.next;
        ListNode curNext = cur;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        while(cur != null){
            curNext=cur.next;
            cur.next = slow;
            cur = curNext;
            slow=slow.next;
        }
        while (slow!=head || slow != head.next ){
            if(head.val == slow.val){
                head=head.next;
                slow=slow.next;
            }else {
                return false;
            }
        }
        return true;


    }



}
