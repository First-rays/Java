package bookmanager.operation;

import bookmanager.book.BookList;

public class PrintOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("打印所有书籍");
        for(int i = 0; i < bookList.getSize(); i++){
            System.out.println(bookList.getBook(i));
        }
        System.out.println("共计"+ bookList.getSize()+"本书！");
    }
}
