package myLibrary.operation;

import myLibrary.book.Book;
import myLibrary.book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{

    public void work(BookList bookList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名");
        String name = scanner.nextLine();
        System.out.println("请输入作者");
        String author = scanner.nextLine();
        System.out.println("请输入类型");
        String type = scanner.nextLine();
        System.out.println("请输入价格");
        int  price = scanner.nextInt();

        Book book = new Book(name,author,price,type);
        bookList.setBook(bookList.getUsedSize(), book);
        bookList.setUsedSize(bookList.getUsedSize()+1);
        System.out.println("新增图书！");


    }

}
