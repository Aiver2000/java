package com.xxz.demo5;

interface IA{
    int A = 10;
    void funcA();
}
interface IB{
    void funcB();
}
abstract class BC{
    abstract void funcBC();
}
class AC extends BC implements IA,IB{
    @Override
    public void funcB() {
        System.out.println("B::funcB()");
    }
    @Override
    public void funcA() {
        System.out.println("A::funcA");
        System.out.println(A);
    }

    @Override
    void funcBC() {
        System.out.println("class BC ::funcBC");
    }
}

public class Test2 {

    public static void main(String[] args) {
        final int a = 10;
        System.out.println(a);
    }
}
