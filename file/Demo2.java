package file;

import java.io.File;

public class Demo2 {
    public static void main(String[] args) {
        File f = new File("./test.txt");
        System.out.println(f.exists());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
    }
}
