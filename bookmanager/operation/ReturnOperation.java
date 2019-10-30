package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还的书的编号: ");
        String id = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (!book.getId().equals(id)) {
                continue;
            }
            // 执行具体的还书操作
            if (!book.isBorrowed()) {
                System.out.println("这本书已经被归还了!");
                break;
            }
            System.out.println("归还成功！");
            book.setBorrowed(false);
        }

    }
}
