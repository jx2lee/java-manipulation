package com.jx2lee.thejava.dynamicproxy.proxypattern;

public class BookServiceProxy implements BookService {
    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("============");
        System.out.println("BookServiceProxy.rent");
        System.out.println("============");
    }

    @Override
    public void returnBook(Book book) {

    }
}
