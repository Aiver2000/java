package interClass;


class OuterClass{
    public int data1 = 1;
    public int data2 = 2;
    public static int data3 = 3;

    class InnerClass{
        public int data4 = 4;
        private int data5 = 5;
        public static final int data6 = 6;

        public InnerClass(){
            System.out.println("不带参数的inner类构造方法");
        }
        public void test(){
            System.out.println("InnerClass::Test()");
        }
    }

    public void func1(){
        System.out.println("我是普通类");
    }
}


public class test {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();
    }


}
