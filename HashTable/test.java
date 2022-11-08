package HashTable;

import java.util.HashMap;
import java.util.Objects;

class Person{
    public String ID;
    public Person(String ID){
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(ID, person.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                '}';
    }
}

class HashBuck2<K,V>{
    static class Node<K,V>{
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key,V val){
            this.key = key;
            this.val = val;
        }
    }
    public Node<K,V>[] array = new Node[10];
    public int usedSize;

    public void put(K key,V val){
        int hash = key.hashCode();
        int index = hash %array.length;
        Node<K,V> cur = array[index];
        while (cur != null){
            if(cur.key.equals(key)){
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        Node<K,V> node = new Node<>(key,val);
        node.next=array[index];
        array[index] = node;
        this.usedSize++;

    }
    public V get(K key){
        int hash = key.hashCode();
        int index = hash%array.length;
        Node<K,V> cur = array[index];
        while (cur != null){
            if(cur.key.equals(key)){
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}


public class test {
    public static void main2(String[] args) {
        Person person1 = new Person("123");

        Person person2 = new Person("123");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        HashMap<Person,String> hashMap = new HashMap<>();



    }
    public static void main1(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(12,12);
        hashBuck.put(3,3);
        hashBuck.put(6,6);
        hashBuck.put(2,2);
        hashBuck.put(11,11);



    }
}
