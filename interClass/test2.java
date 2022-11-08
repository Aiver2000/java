package interClass;

import javax.sound.midi.Soundbank;

class OuterClass2{
    public int data1 = 1;
    public int data2 = 2;
    public static int data3 = 3;

    static class InnerClass{
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;

        public void test(){
            System.out.println(new OuterClass2().data1);
            System.out.println("InnerClass::test");
        }

    }
}
public class test2 {
    public static void main(String[] args) {
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();
        innerClass.test();
    }
}
