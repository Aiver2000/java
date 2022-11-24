package file;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File f = new File("E:/学习/BIT/JAVA/test.txt");
        System.out.println(f.getParent());
        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        File f2 = new File("./test.txt");
        System.out.println(f2.getParent());
        System.out.println(f2.getName());
        System.out.println(f2.getPath());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getCanonicalPath());
    }
}
