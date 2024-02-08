package org.iti.mobile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public Library(List<Book> books) {
        this.books = books;
    }

    public void addBooks(List<Book> bk){
        books.addAll(bk);
    }

    public int getBooksCount() {
        return  books.size();
    }

    public List<Book> getCurrentBooks(){
        return books;
    }
}
