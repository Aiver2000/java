package generic;

import java.util.ArrayList;

class MyArray1{
    public Object[] objects = new Object[10];
    public void set(int pos,Object val){
        objects[pos] = val;
    }

    public Object get(int pos){
        return objects[pos];
    }
}

class Alg<T extends Comparable<T>>{
    public T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i])<0){
                max = array[i];
            }
        }
        return max;
    }
}
class Alg1/*<T extends Comparable<T>>*/{
    public static <T extends Comparable<T> > T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i])<0){
                max = array[i];
            }
        }
        return max;
    }
}

class MyArray<T /*extends Number*/>{
    //public T[] objects = new T[10];
    public T[] objects = (T[]) new Object[10];

    public void set(int pos,T val){
        objects[pos] = val;
    }

    public T get(int pos){
        return objects[pos];
    }
}

class Alg3{
    public static <T> void print(ArrayList<T> list){
        for(T x: list){
            System.out.println(x);
        }
    }
    public static void print2(ArrayList<?> list){
        for(Object x: list){
            System.out.println(x);
        }
    }
}

class Person{

}
class Student extends Person{

}
public class test {
    public static void main(String[] args) {
        ArrayList<? super Person> arrayList = new ArrayList<Person>();
        ArrayList<? super Person> arrayList2 = new ArrayList<Student>();

    }

    public static void main3(String[] args) {
        Alg<Integer> alg = new Alg<>();
        Integer[] array = {1,2,3,4};
        System.out.println(alg.findMax(array));
    }
    public static void main2(String[] args) {
        MyArray<String> myArray = new MyArray<>();
        myArray.set(0,"hehe");
        String str = myArray.get(0);
    }
    public static void main1(String[] args) {
        MyArray1 myArray = new MyArray1();
        myArray.set(0,"hehe");
        myArray.set(1,10);
        String str =(String) myArray.get(0);
    }
}
