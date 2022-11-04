import java.util.*;

class myArrayList<E>{
    private Object[] elementData;
    private int usedSize;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    public myArrayList(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public myArrayList(int capacity){
        if(capacity > 0 ){
            this.elementData = new Object[capacity];
        }else if(capacity == 0){
            this.elementData = new Object[0];
        }else {
            throw new IllegalArgumentException("初始化容量不能为负数");
        }
    }
    public boolean add(E e){
        ensureCapacityInternal(usedSize+1);
        elementData[usedSize++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity){
        int capacity = calculateCapacity(elementData,minCapacity);
        ensureExplicitCapacity(capacity);
    }
    private void ensureExplicitCapacity(int minCapacity){
        if(minCapacity - elementData.length >0){
            grow(minCapacity);
        }
    }
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE -8;
    private void grow(int minCapacity){
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity+(oldCapacity>>1);
        if(newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        if(newCapacity - MAX_ARRAY_SIZE>0){
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }

    private static int hugeCapacity(int minCapacity){
        if(minCapacity < 0){
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE:
                MAX_ARRAY_SIZE;
    }
    private static int calculateCapacity(Object[] elementData,int minCapacity){
        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            return Math.max(10,minCapacity);
        }
        return minCapacity;
    }


    public void add(int index,E e){
        rangeCheckForAdd(index);
        ensureCapacityInternal(usedSize+1);
        copy(index,e);
        usedSize++;
    }
    private void copy(int index,E e){
        for (int i = usedSize-1; i >=index; i--) {
            elementData[i+1] = elementData[i];
        }
        elementData[index] = e;
    }

    private void rangeCheckForAdd(int index){
        if(index<0 || index>size()){
            throw new IndexOutOfBoundsException("index 位置不合法，别插我");
        }
    }
    public int size(){
        return this.usedSize;
    }




}





public class test2 {
    public static void main(String[] args) {
        myArrayList<String> list = new myArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("ac");
        list.add("abd");
        list.add(0,"aaaa");
        System.out.println("asdfasdfaf");

    }
    public static void main6(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(13);
        list1.add("aaaa");

        System.out.println(list1);
    }

    public static void main5(String[] args) {
        List<String> list= new ArrayList<>(20);
        list.add("hello");
        list.add("bit");
        list.add("hehe");
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()){
            String ret = it.next();
            if(ret.equals("hello")){
                it.remove();
            }else {
                System.out.println(ret+" ");
            }
        }
    }

    public static void main4(String[] args) {
        List<String> list= new ArrayList<>(20);
        ArrayList<String> list1 = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("hehe");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (String s:
             list) {
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("===============");
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()){
            System.out.println(it.next()+" ");
        }




        ArrayList<String> list2 = new ArrayList<>(list1);

    }





    public static void main3(String[] args) {
        Integer a = -128;
        Integer b = -127;
        System.out.println(a == b);
    }
    public static void main1(String[] args) {
        /*String str = "1234";
        int ret = Integer.valueOf(str);
        System.out.println(ret +1);*/
        Integer a = 123;
        int b  = a;

        System.out.println(a);
        System.out.println(b);
        Integer a2 = Integer.valueOf(123);
        Integer a3 = new Integer(123);
        int b2 = a2.intValue();
        double d = a2.doubleValue();
        float f = a2.floatValue();


    }
}
