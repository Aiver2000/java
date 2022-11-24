package file;

import java.io.File;

public class Demo7 {
    public static void main(String[] args) {
        File f = new File("./aaa");
        File f2 = new File("./zzz");
        f.renameTo(f2);
    }
}
