package com.xxz.demo5;

interface IA1{
    void funcA();
}
interface IB2 extends IA1{
    void funcB();
}

class C implements IB2{
    @Override
    public void funcB() {

    }

    @Override
    public void funcA() {

    }
}
public class Test3 {

}
