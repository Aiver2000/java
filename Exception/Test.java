package Exception;


import java.util.InputMismatchException;
import java.util.Scanner;

class Person implements Cloneable{
    public int id;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}






public class Test {

    public static void main(String[] args) {


    }
    public static void main5(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(10 / n);

        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入有误");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算数异常");
        } finally {
            System.out.println("finally 执行了");
        }

    }




    public static void main3(String[] args) {
        int[] array = {1,2,3};
        try{
            array = null;
            System.out.println(array[2]);
        }catch (ArrayIndexOutOfBoundsException |NullPointerException e){
            e.printStackTrace();
            System.out.println("我捕捉到了一个数组越界异常，或空指针异常");
        }

        System.out.println("hello!!");
    }
    public static void main4(String[] args) {
        int[] array = {1,2,3};
        try{
            array = null;
            System.out.println(array[2]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("我捕捉到了一个数组越界异常");
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("空指针异常");
        }

        System.out.println("hello!!");
    }






    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        System.out.println(n);
    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person1 =(Person) person.clone();
        //int[] array = {1,2,3};
        //System.out.println(array[3]);
        //System.out.println(10/0);
        //String str = null;
        //System.out.println(str.length());
    }
}
