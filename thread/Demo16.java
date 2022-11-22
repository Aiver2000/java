package thread;


import java.util.Scanner;

public class Demo16 {
    private static volatile int isQuit = 0;

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while (isQuit==0) {

            }
            System.out.println("循环结束!  t线程退出!");
        });
        t.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个isQuit的值：");
        isQuit = scanner.nextInt();
        System.out.println("main 执行完毕!");

    }

}
