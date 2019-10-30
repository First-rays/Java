package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除书籍的编号：");
        String id = scanner.next();
        int i = 0;
        for(; i < bookList.getSize(); i++){
            Book book = bookList.getBook(i);
            if(book.getId().equals(id)){
                break;
            }
        }
        if(i >= bookList.getSize()){
            System.out.println("未找到要查找的书籍！");
            return;
        }
        Book lastBook = bookList.getBook(bookList.getSize() - 1);
        bookList.setBook(i, lastBook);
        bookList.setSize(bookList.getSize() - 1);
        System.out.println("删除成功！");
    }
}
