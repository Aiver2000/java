package com.xxz.demo4;

abstract class Shape{
    public int a ;
    public void func(){
        System.out.println("普通方法");
    }
    public abstract void draw();
}
abstract class A extends Shape{

    public abstract void funcA();
}
class B extends A{

    @Override
    public void funcA() {

    }

    @Override
    public void draw() {

    }
}
class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("♦"+a);
        super.func();
    }
}
class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
class Triangle extends Shape {
    public void draw(){
        System.out.println("🔺");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}
public class Test {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape = new Rect();
        drawMap(shape);
        Cycle cycle = new Cycle();
        drawMap(cycle);
        //Shape shape1 = new Rect();


    }
}
