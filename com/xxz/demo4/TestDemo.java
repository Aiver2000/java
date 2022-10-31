package com.xxz.demo4;

interface IShape{
    void draw();
    default public void func() {
        System.out.println("接口default");
    }
//    public static void funcStatic(){
//        System.out.println("funcstatic");
//    }

}
abstract class User{
    private String name;

    public User(String name) {
        this.name = name;
    }
    public abstract void func();
    public String getName(){
        return this.name;
    }
}
class Admin extends User{
    public Admin(String name) {
        super(name);
    }

    @Override
    public void func() {

    }
}

public class TestDemo {
    public static void main(String[] args) {
        User user = new Admin("bit");
        System.out.println(user.getName());
    }
}
