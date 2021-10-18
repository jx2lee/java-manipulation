package com.jx2lee.thejava.dynamicproxy.proxypattern;

import org.junit.jupiter.api.Test;

class BookServiceTest {

    BookService bookService = new DefaultBookService();
    BookService bookServiceProxy = new BookServiceProxy(new DefaultBookService());

    @Test
    public void BookService_의_rent_함수_호출() {
        Book book = new Book();
        book.setName("test");
        bookService.rent(book);
    }

    @Test
    public void BookServiceProxy_클래스를_통해_DefaultBookService_로_접근하여_rent_함수를_변경한다() {
        Book book = new Book();
        book.setName("test");
        bookServiceProxy.rent(book);
    }



}
