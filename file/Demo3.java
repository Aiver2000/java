package file;

import java.io.File;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        File f = new File("./test.txt");
        System.out.println(f.exists());
        f.createNewFile();
        System.out.println(f.exists());

    }
}
