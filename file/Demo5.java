package file;

import java.io.File;

public class Demo5 {
    public static void main(String[] args) {
        File f = new File("./aaa/bbb/ccc/ddd");
        f.mkdirs();
        System.out.println(f.isDirectory());
    }
}
