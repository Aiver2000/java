package file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo6 {
    public static void main(String[] args) {
        File f = new File("./");
        System.out.println(Arrays.toString(f.listFiles()));
    }
}
