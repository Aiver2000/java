package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo10 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("E:\\学习\\BIT\\JAVA\\test.txt")){
            while (true){
                char[] buffer = new char[1024];
                int len = reader.read(buffer);
                if(len == -1){
                    break;
                }
//                for(int i = 0;i<len;i++){
//                    System.out.println(buffer[i]);
//                }
                String s = new String(buffer,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
