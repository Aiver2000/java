package myLibrary.operation;

import myLibrary.book.BookList;

import java.util.Scanner;

public class RemoveOperation implements IOperation{

    public void work(BookList bookList){
        System.out.println("请输入你要归还的书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getPos(i).getName())){
                bookList.getPos(i).setBorrowed(false);
                System.out.println("归还成功！");
                System.out.println(bookList.getPos(i));
                return;
            }
        }
        System.out.println("没有你要归还的这本书！");
    }

}