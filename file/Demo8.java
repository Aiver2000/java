package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo8 {
    public static void main(String[] args) {
//        try(InputStream inputStream = new FileInputStream("E:/学习/BIT/JAVA")){
//            while (true){
//                int b = inputStream.read();
//                if(b == -1){
//                    break;
//                }
//                System.out.println(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try(InputStream inputStream = new FileInputStream("E:/学习/BIT/JAVA/test.txt")) {
            while (true){
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                if(len == -1){
                    break;
                }
                for (int i = 0; i < len; i++) {
                    System.out.println(buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
