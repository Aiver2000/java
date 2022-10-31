package myLibrary.operation;

import myLibrary.book.Book;
import myLibrary.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{

    public void work(BookList bookList){
        System.out.println("请输入要删除的图书的名字");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int index = 0;
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getPos(i).getName())){
                index = i;
                break;
            }
        }
        if(i >= bookList.getUsedSize()){
            System.out.println("没有你想删除的书！");
            return;
        }
        for (int j = index; j < bookList.getUsedSize()-1; j++) {
            Book book = bookList.getPos(j+1);
            bookList.setBook(j,book);
        }

        bookList.setUsedSize(bookList.getUsedSize()-1);
        bookList.setBook(bookList.getUsedSize(),null);

        System.out.println("删除图书！");
    }

}
