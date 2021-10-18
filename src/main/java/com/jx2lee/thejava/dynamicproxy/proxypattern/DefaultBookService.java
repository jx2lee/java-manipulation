package com.jx2lee.thejava.dynamicproxy.proxypattern;

public class DefaultBookService implements BookService{
    public void rent(Book book) {
        System.out.println("BookService.rent");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("book.getName() = " + book.getName());
    }
}
