package com.xxz.demo5;

interface IShape{
    void draw();
    default public void func() {
        System.out.println("接口default");
    }
//    public static void funcStatic(){
//        System.out.println("funcstatic");
//    }

}
class Rect implements IShape{
    @Override
    public void draw() {
        System.out.println("♦");
    }

//    @Override
//    public void func() {
//        System.out.println("重写接口的默认方法");
//    }
}
public class Test {
    public static void main(String[] args) {
        IShape iShape = new Rect();
        iShape.draw();
        iShape.func();
    }
}
