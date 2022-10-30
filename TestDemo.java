public class TestDemo {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(3,4);
        doubleLinkedList.display();


    }
    public static void main3(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);

        System.out.println(doubleLinkedList.contains(1));
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(5);
        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(6);

        System.out.println(doubleLinkedList.size());
        doubleLinkedList.remove(6);
        doubleLinkedList.display();



    }
    public static void main2(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //myLinkedList.createList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);
       // myLinkedList.remove(5);
        myLinkedList.display();

        //myLinkedList.reverseList();
        //myLinkedList.display();
        //myLinkedList.display2(myLinkedList.reverseList());
    }
    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //myLinkedList.createList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addIndex(0,99);
        myLinkedList.addIndex(10,22);
        myLinkedList.addIndex(2,99);


        myLinkedList.display();
        System.out.println(myLinkedList.contains(22));
        System.out.println(myLinkedList.size());
    }
}
