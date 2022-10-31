package com.xxz.demo3;


class Shape{
    public void draw(){
        System.out.println("Shape::draw()");
    }
}

class Rect extends Shape{
    public void draw(){
        System.out.println("♦");
    }
}

class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
class Triangle extends Shape{
    public void draw(){
        System.out.println("🔺");
    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}
public class Test {
    public static void main(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        Shape[] shapes = {rect,rect,flower,triangle,new Cycle()};
        for (Shape shape:
             shapes) {
            shape.draw();
        }
    }


    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main2(String[] args) {
        drawMap(new Triangle());

        drawMap(new Rect());
        drawMap(new Flower());
    }

    public static void main1(String[] args) {
        Shape shape = new Rect();
        shape.draw();
        Shape shape1 = new Flower();
        shape1.draw();
    }
}
