package file;

import java.io.*;
import java.util.Scanner;

public class Demo14 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");
        String rootDirPath = scanner.next();
        System.out.println("请输入要查询的关键词：");
        String word = scanner.next();
        File rootDir = new File(rootDirPath);
        if(!rootDir.isDirectory()){
            System.out.println("输入路径非法！");
            return;
        }
        scanDir(rootDir,word);

    }

    private static void scanDir(File rootDir, String word) throws IOException {
        File[] files = rootDir.listFiles();
        if(files == null){
            return;
        }
        for(File f:files){
            if(f.isFile()){
                if(containsWord(f,word)){
                    System.out.println(f.getCanonicalPath());
                }
            }else if(f.isDirectory()){
                scanDir(f,word);
            }
        }
    }

    private static boolean containsWord(File f, String word) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Reader reader = new FileReader(f)){
            char[] buffer = new char[1024];
            while (true){
                int len = reader.read(buffer);
                if(len == -1){
                    break;
                }
                stringBuilder.append(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.indexOf(word) != -1;
    }
}
