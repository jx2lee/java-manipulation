package com.jx2lee.thejava.dynamicproxy;

import com.jx2lee.thejava.dynamicproxy.proxypattern.Book;
import com.jx2lee.thejava.dynamicproxy.proxypattern.BookService;
import com.jx2lee.thejava.dynamicproxy.proxypattern.DefaultBookService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceDynamicProxyTest {


    BookService bookService = new DefaultBookService();
    BookService bookServiceDynamic = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(),
            new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("===========");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("===========");
                    return invoke;
                }
            });

    // interface 기반 프록시 생성만이 가능하다.
    BookService bookServiceDynamicForRent = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(),
            new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("rent")) {
                        System.out.println("===========");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("===========");
                        return invoke;
                    }
                    return method.invoke(bookService, args);
                }
            });

    @Test
    public void BookService_의_rent_함수를_호출한다() {
        Book book = new Book();
        book.setName("test");
        bookService.rent(book);
        System.out.println();
        System.out.println();
    }

    @Test
    public void 동적_프록시_객체를_생성하여_변경된_rent_함수를_변경한다() {
        Book book = new Book();
        book.setName("test");
        bookServiceDynamic.rent(book);
        bookServiceDynamic.returnBook(book);
        System.out.println();
        System.out.println();
    }

    @Test
    public void 동적_프록시_객체를_생성하여_rent_함수에만_적용한다() {
        Book book = new Book();
        book.setName("test");
        bookServiceDynamicForRent.rent(book);
        bookServiceDynamicForRent.returnBook(book);
    }
}
