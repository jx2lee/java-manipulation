package com.jx2lee.thejava.di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerServiceTest {

    @Test
    public void getObject_BookRepository_함수를_통해_정상적으로_객체를_생성한다(){
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService_함수를_통해_정상적으로_객체를_생성한다(){
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }

    @Test
    public void test() {
        BookService test = new BookService();
        assertNotNull(test.bookRepository);
    }
}
