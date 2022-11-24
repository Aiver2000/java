package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo9 {
    public static void main(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("E:\\学习\\BIT\\JAVA\\test.txt")){
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);
            byte[] buffer = new byte[]{97,98,99};
            outputStream.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
