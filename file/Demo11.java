package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo11 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("E:\\学习\\BIT\\JAVA\\test.txt")){
            writer.write("xyz");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
