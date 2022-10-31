package com.xxz.demo5;

class Animal{
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

}
interface IFlying{
    void fly();
}
interface IRunning{
    void Run();
}
interface ISwimming{
    void swimming();
}
class Bird extends Animal implements IFlying{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+"正在飞");
    }
}
class Frog extends Animal implements IRunning,ISwimming{
    public Frog(String name) {
        super(name);
    }

    @Override
    public void Run() {
        System.out.println(this.name+"正在跑");
    }

    @Override
    public void swimming() {
        System.out.println(this.name+"正在游泳");
    }
}

class Duck extends Animal implements IRunning,ISwimming,IFlying{
    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+"正在飞");

    }

    @Override
    public void Run() {
        System.out.println(this.name+"正在跑");

    }

    @Override
    public void swimming() {
        System.out.println(this.name+"正在游泳");

    }
}
public class test4 {
    public static void runFunc(IRunning iRunning){
        iRunning.Run();
    }
    public static void swimmingFunc(ISwimming iSwimming){
        iSwimming.swimming();
    }
    public static void main(String[] args) {
        runFunc(new Duck("yazi"));
        runFunc(new Frog("qingwa"));
        swimmingFunc(new Duck("YAZI"));
        swimmingFunc(new Frog("QINGWA"));

    }
}
