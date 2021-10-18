package com.jx2lee.thejava.dynamicproxy;

import com.jx2lee.thejava.dynamicproxy.proxypattern.Book;
import com.jx2lee.thejava.dynamicproxy.proxypattern.BookService;
import com.jx2lee.thejava.dynamicproxy.proxypattern.BookServiceClass;
import com.jx2lee.thejava.dynamicproxy.proxypattern.DefaultBookService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BookServiceDynamicProxyUsingCglibTest {

    @Test
    public void 클래스_간_동적_프록시_객체를_생성한다_cglib() {
        MethodInterceptor handler = new MethodInterceptor() {
            BookServiceClass bookServiceClass = new BookServiceClass();
            @Override

            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws InvocationTargetException, IllegalAccessException {
                System.out.println("===========");
                Object invoke = method.invoke(bookServiceClass, objects);
                System.out.println("===========");
                return invoke;
            }
        };

        BookServiceClass bookServiceDynamicBetweenClass = (BookServiceClass) Enhancer.create(BookServiceClass.class, handler);
        Book book = new Book();
        book.setName("클래스_간_동적_프록시_객체를_생성한다");
        bookServiceDynamicBetweenClass.rent();
        bookServiceDynamicBetweenClass.returnBook(book);
        System.out.println();
        System.out.println();
    }

    @Test
    public void 클래스_간_동적_프록시_객체를_생성시_rent_함수에만_적용한다_cglib() {
        MethodInterceptor handler = new MethodInterceptor() {
            BookServiceClass bookServiceClass = new BookServiceClass();
            @Override

            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws InvocationTargetException, IllegalAccessException {
                if (method.getName().equals("rent")) {
                    System.out.println("===========");
                    Object invoke = method.invoke(bookServiceClass, objects);
                    System.out.println("===========");
                    return invoke;
                }
                return method.invoke(bookServiceClass, objects);
            }
        };

        BookServiceClass bookServiceDynamicBetweenClass = (BookServiceClass) Enhancer.create(BookServiceClass.class, handler);
        Book book = new Book();
        book.setName("클래스_간_동적_프록시_객체를_생성한다");
        bookServiceDynamicBetweenClass.rent();
        bookServiceDynamicBetweenClass.returnBook(book);
        System.out.println();
        System.out.println();
    }
}
