package myLibrary.operation;

import myLibrary.book.Book;
import myLibrary.book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{

    public void work(BookList bookList){
        System.out.println("请输入你要查找的书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getPos(i).getName())){
                System.out.println("找到了，信息如下：");
                System.out.println(bookList.getPos(i));
                return;
            }
        }
        System.out.println("没有找到这本书！");
    }

}
