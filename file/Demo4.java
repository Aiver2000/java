package file;

import java.io.File;

public class Demo4 {
    public static void main(String[] args) {
        File f = new File("./test.txt");
        f.delete();
    }
}
