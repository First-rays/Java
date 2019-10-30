package bookmanager.user;

import bookmanager.book.BookList;
import bookmanager.operation.IOperation;

abstract public class User {
    protected String name;
    abstract public int menu();

    public User(String name) {
        this.name = name;
    }
    protected IOperation []operations;

    public void doOperation(int choice, BookList book){

        operations[choice].work(book);
    }

}
