package HashTable;

import java.util.HashSet;

public class HashBuck {
    static class Node{
        public int key;
        public int val;
        public Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    public static final double DEFAULT_LOAD_FACTOR = 0.75;
    public Node[] array;
    public int usedSize;
    public HashBuck(){
        this.array = new Node[10];
    }
    public void put(int key,int val){
        int index = key % this.array.length;
        Node cur = array[index];
        while (cur != null){
            if(cur.key == key){
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key,val);
        node.next=array[index];
        array[index] = node;
        this.usedSize++;
        if(loadFactor() >= DEFAULT_LOAD_FACTOR){
            resize();
        }

    }
    private void resize(){
        Node[] newArray = new Node[array.length*2];
        for(int i = 0;i<array.length;i++){
            Node cur = array[i];
            while(cur != null){
                int index = cur.key%newArray.length;
                Node curNext = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }

    private double loadFactor(){
        return 1.0*usedSize/array.length;
    }


    public int get(int key){
        int index = key%array.length;
        Node cur = array[index];
        while (cur!=null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }



}
