package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍");
        System.out.println("请输入书的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int count = 0;
        for(int i = 0; i < bookList.getSize(); i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println(book);
                count++;
            }
        }
        if(count == 0){
            System.out.println("不存在此书籍！");
        } else{
            System.out.println("共找到" + count + "本书！");
        }
    }
}
