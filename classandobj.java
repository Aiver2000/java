/**
 * 静态变量，只能定义为类变量，不能定义在普通方法中
 * 静态方法中，只能调用静态方法（或new对象调用普通方法）
 * 普通方法，可以调用普通方法，可以调用静态方法
 *
 *
 */






class Calculator{
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add(){
        return num1+num2;
    }
    public int sub(){
        return num1-num2;
    }
    public double mul(){
        return num1*num2;
    }
    public double div(){
        return num1*1.0/num2;
    }

}

class MyValue{
    public int val;
}
public class classandobj {
    public static void swap(MyValue myV1,MyValue myV2){
        int tmp = myV1.val;
        myV1.val = myV2.val;
        myV2.val = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        swap(myValue1,myValue2);
        System.out.println(myValue1.val+" "+ myValue2.val);

    }


    public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(1);
        calculator.setNum2(2);
        System.out.println(calculator.add());

    }

}

















/*
class Person{
    private String name;
    public int age;



    public Person(){
        this("高博");
        System.out.println("Person()::不带参数构造方法");
    }
    {
        System.out.println("实例代码块");
    }
    static {
        System.out.println("静态代码块");
    }
    public Person(String name){
        this.name = name;
        System.out.println("Person()::带参数的构造方法");
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println(name+" 吃饭 ");
        int size = 0;
    }
    private void sleep(){
        System.out.println(name+"正在睡觉");
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" +  name+ '\'' +
                ", age=" + age +

                '}';
    }
*/
/*    public String toString(){
        return "姓名"+name+"年龄"+age;
    }*//*

}
*/














/*    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getName());
        person.setName("huya");
        System.out.println(person);

    }*/




 /*   public static void main2(String[] args) {
        //Person person = new Person();
        //Person.count = 1999;
        //System.out.println(Person.count);
        System.out.println("###################");
        //Person person1 = new Person();
        //Person.count ++;
        //System.out.println(Person.count);
    }

    public static void main1(String[] args) {
        //Person person = null;
        int a;
        Person person = new Person();
        //person.name = "lqx";
        //System.out.println(person.name);
        System.out.println(person.age);
        //System.out.println(person.add);


        Person person1 = new Person();
        //System.out.println(person1.name);
        System.out.println(person1.age);
        //System.out.println(person1.add);
    }

}


*/
