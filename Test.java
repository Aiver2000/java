class Money implements Cloneable{
    public double m = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;
    public Money money = new Money();
    public void eat(){
        System.out.println("eat");
    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person tmp = (Person) super.clone();
        tmp.money = (Money) this.money.clone();
        //return super.clone();
        return tmp;

    }

}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 =(Person) person.clone();
        person.money.m = 20.0;
        System.out.println(person.money.m);
        System.out.println(person2.money.m);
        System.out.println("====================");

    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();

        Person person2 =(Person) person.clone();
        System.out.println(person2);


    }


}
