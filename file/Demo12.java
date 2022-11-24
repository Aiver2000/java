package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo12 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");
        String rootDirPath = scanner.next();
        System.out.println("请输入要删除的文件名:");
        String toDeleteName = scanner.next();
        File rootDir = new File(rootDirPath);
        if(!rootDir.isDirectory()){
            System.out.println("输入路径有误");
            return;
        }
        //树-目录的遍历
        scanDir(rootDir,toDeleteName);
    }

    private static void scanDir(File rootDir, String toDeleteName) {
        File[] files = rootDir.listFiles();
        if(files == null){
            return;
        }
        for (File f:files){
            if(f.isFile()){
                if(f.getName().contains(toDeleteName)){
                    deleteFile(f);
                }
            }else if(f.isDirectory()){
                scanDir(f,toDeleteName);
            }
        }

    }

    private static void deleteFile(File f) {
        try {
            System.out.println(f.getCanonicalPath() + "确认要删除文件?(Y/n)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if(choice.equals("Y") || choice.equals("y")){
                f.delete();
                System.out.println("文件删除成功！");
            }else {
                System.out.println("文件取消删除！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
