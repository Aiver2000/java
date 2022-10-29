/**
 * 静态变量，只能定义为类变量，不能定义在普通方法中
 * 静态方法中，只能调用静态方法（或new对象调用普通方法）
 * 普通方法，可以调用普通方法，可以调用静态方法
 *
 *
 */
class Person{
    public String name;
    public int age;
    public char add;
    public static int count;


    public void eat(){
        System.out.println(name+" 吃饭 ");
        int size = 0;
    }
    public void sleep(){
        System.out.println(name+"正在睡觉");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", add=" + add +
                '}';
    }
/*    public String toString(){
        return "姓名"+name+"年龄"+age;
    }*/
}


public class classandobj {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
    }




    public static void main2(String[] args) {
        //Person person = new Person();
        Person.count = 1999;
        System.out.println(Person.count);
        System.out.println("###################");
        //Person person1 = new Person();
        Person.count ++;
        System.out.println(Person.count);
    }

    public static void main1(String[] args) {
        //Person person = null;
        int a;
        Person person = new Person();
        person.name = "lqx";
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.add);


        Person person1 = new Person();
        System.out.println(person1.name);
        System.out.println(person1.age);
        System.out.println(person1.add);
    }

}



