package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书的序号：");
        String id = scanner.next();
        for(int i = 0; i < bookList.getSize(); i++){
            Book book = bookList.getBook(i);
            if(!book.getId().equals(id)){
                continue;
            }
            if(book.isBorrowed()){
                System.out.println("书被借出！");
                break;
            }
            book.setBorrowed(true);
        }

    }
}
