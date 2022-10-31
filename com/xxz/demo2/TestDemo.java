package com.xxz.demo2;

class Animal{
    public String name;
    public int age;
    protected int count;

    public Animal(String name,int age){
        eat();
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println(name+"animal:eat()");

    }
}
class Dog extends Animal{

    public Dog(String name,int age){
        super(name,age);
    }

    @Override
    public void eat(){
        System.out.println(name+"dog:eat()");

    }


}

class Bird extends Animal{
    public String wing;
    public String name;

    public Bird(String name,int age,String wing){
        super(name,age);
        this.wing = wing;
    }
    public void fly(){
        System.out.println(super.name+"fly()");
    }
}


public class TestDemo {
    public static void main(String[] args) {
        Animal animal =  new Dog("hh",19);

    }
    public static void main6(String[] args) {
        Animal animal = new Bird("gigi",20,"灰灰");
        Bird bird = (Bird) animal;
        bird.fly();
    }


    public static void main5(String[] args) {
        Animal animal =  new Dog("hh",19);
        if(animal instanceof Bird) {
            Bird bird = (Bird) animal;
            bird.fly();

        }
    }

    public static void func(Animal animal){

    }
    public static Animal func2(){
        Dog dog = new Dog("qq",30);
        return dog;
    }
    public static void main4(String[] args) {
       /* Dog dog = new Dog("hh",19);
        Animal animal = dog;*/
        Animal animal =  new Dog("hh",19);
        func(new Dog("hh",20));
    }
    public static void main3(String[] args) {
        Bird bird = new Bird("jj" , 20,"big");
        System.out.println(bird.count);

    }
    public static void main2(String[] args) {
        Bird bird = new Bird("jj" , 20,"big");
        System.out.println(bird.name);
        bird.eat();
        bird.fly();
    }

    public static void main1(String[] args) {
        Dog dog = new Dog("hh",19);
        System.out.println(dog.name);
        dog.eat();
        Bird bird = new Bird("jj" , 20,"big");
        System.out.println(bird.name);
        bird.eat();
        bird.fly();
    }
}
