package myLibrary.operation;

import myLibrary.book.Book;
import myLibrary.book.BookList;

public class DisplayOperation implements IOperation{

    public void work(BookList bookList){
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getPos(i);
            System.out.print(book);
            System.out.println();
        }
        System.out.println("打印结束！");
    }

}

